package com.doucome.stockop.biz.core.ks;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.constant.Constant;
import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;
import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.request.KsRequest;
import com.doucome.stockop.biz.core.ks.request.KsSubDataRequest;
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.ks.response.KsResponse;
import com.doucome.stockop.biz.core.ks.response.KsSubDataResponse;
import com.doucome.stockop.biz.core.model.StockAccountDTO;
import com.doucome.stockop.biz.core.utils.ReflectionExUtils;
import com.sun.jna.Native;

public class DefaultKsClient implements KsClient {

	private Socket socket ;
	
	private StockAccountDTO account ;
	
	//private byte[] buff = new byte[4096] ;
	
	private Lock lock = new ReentrantLock() ;
	
	private long timestamp = 0L ;
	
	private boolean isLogin = false ;
	
	private byte[] createBuffer() {
		return new byte[1024] ;
	}
	
	public DefaultKsClient(String server , int serverPort) throws KsException {
		try {
			socket = new Socket(server, serverPort) ;
			socket.setSoTimeout(5000) ;
			
		} catch (UnknownHostException e) {
			throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
		} catch (IOException e) {
			throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
		}
	}

	@Override
	public <T extends KsResponse> T execute(KsRequest<T> request) throws KsException {
		return _execute(request , true) ;
	}
	
	
	
	@Override
	public KsLoginResponse login(KsLoginRequest request) throws KsException {
		if(isLogin){
			throw new KsException(ErrorEnums.DUPLICATE_LOGIN , "account[" + request.getAccount() + "] is aready login") ;
		}
		KsLoginResponse response = _execute(request , false) ;
		account = new StockAccountDTO(request , response) ;
		isLogin = true ;
		return response;
	}
	
	private <T extends KsResponse> T _execute(KsRequest<T> request , boolean needLogin) throws KsException {
		if(needLogin && !isLogin) {
			throw new KsException(ErrorEnums.NEED_LOGIN , "request[" + request + "] not login") ;
		}
		lock.lock() ;
		try {
			String reqStr = request.toRequest() ;
			Long reqSeq = request.getSeq() ;
			if(StringUtils.isBlank(reqStr)) {
				throw new KsException(ErrorEnums.INPUT_ARGUMENT_ERROR , "input request[" + request + "] error !") ;
			}
			
			try {
				socket.getOutputStream().write(Native.toByteArray(reqStr)) ;
			} catch (IOException e) {
				throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
			}
			
			try {
				byte[] buff = createBuffer() ;
				socket.getInputStream().read(buff) ;
				String resp = Native.toString(buff,Constant.CHARSET_GBK) ;
				ResponseParser<T> parser = new ResponseParser<T>(request.getResponseClass()) ;
				T response = parser.parse(resp) ;
				Long respSeq = response.getSeq() ;
				//是否有子数据
				if(ReflectionExUtils.isImplInterface(response.getClass(), SubDataResponseAware.class)) {
					_awareSubData((SubDataResponseAware<?>) response , (SubDataRequestAware)request) ;
				}
				
				timestamp = System.currentTimeMillis() ;
				
				return response ; 
			} catch (IOException e) {
				throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
			} catch (Exception e) {
				throw new KsException(ErrorEnums.INTERNAL_ERROR , e.getMessage() , e) ;
			}
	
		} finally {
			lock.unlock() ;
		}
	}
	
	/**
	 * 处理子数据
	 * @param <T>
	 * @param response
	 * @throws IOException
	 */
	private <T extends KsSubDataResponse> void _awareSubData(SubDataResponseAware<T> response , SubDataRequestAware sourceRequest) throws IOException  {
		SubDataResponseAware<T> subDataAware = (SubDataResponseAware<T>)response ;
		int subDataCount = subDataAware.getSubDataCount() ;
		for(int i = 0 ;i<subDataCount ;i++) {
			//读子数据
			KsSubDataRequest subDataRequest = new KsSubDataRequest() ;
			subDataRequest.setCommissionWay(sourceRequest.getCommissionWay()) ;
			subDataRequest.setSourceExchangeCode(sourceRequest.getSourceExchangeCode()) ;
			String reqStr = subDataRequest.toRequest() ;
			try {
				socket.getOutputStream().write(Native.toByteArray(reqStr)) ;
			} catch (IOException e) {
				throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
			}
			byte[] buff = createBuffer() ;
			socket.getInputStream().read(buff) ;
			String subResp = Native.toString(buff,Constant.CHARSET_GBK) ;
			if(StringUtils.isNotBlank(subResp)) {
				SubDataResponseParser<T> subDataParser = new SubDataResponseParser<T>(subDataAware.getSubDataClass()) ;
				T object = subDataParser.parse(subResp) ;
				List<T> subDataList = response.getSubData() ;
				if(subDataList == null) {
					throw new IllegalStateException("SubDataAware[" + response.getClass() + "] method [getSubData] cant be return null !") ;
				}
				
				subDataList.add(object) ;
			}
			
		}
	}

	@Override
	public StockAccountDTO getAccount() {
		return account ;
	}

	@Override
	public boolean isLogin() {
		return isLogin ;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
