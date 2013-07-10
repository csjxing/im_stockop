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
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.ks.response.KsResponse;
import com.doucome.stockop.biz.core.ks.response.KsSubDataResponse;
import com.doucome.stockop.biz.core.model.StockAccountDTO;
import com.doucome.stockop.biz.core.utils.ReflectionExUtils;
import com.sun.jna.Native;

public class DefaultKsClient implements KsClient {

	private Socket socket ;
	
	private StockAccountDTO account ;
	
	private byte[] buff = new byte[4096] ;
	
	private Lock lock = new ReentrantLock() ;
	
	private long timestamp = 0L ;
	
	private boolean isLogin = false ;
	
	public DefaultKsClient(String server , int serverPort) throws KsException {
		try {
			socket = new Socket(server, serverPort) ;
		} catch (UnknownHostException e) {
			throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
		} catch (IOException e) {
			throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
		}
	}

	@Override
	public <T extends KsResponse> T execute(KsRequest<T> request) throws KsException {
		if(!isLogin) {
			throw new KsException(ErrorEnums.NOT_LOGIN , "request[" + request + "] not login") ;
		}
		lock.lock() ;
		try {
			String reqStr = request.toRequest() ;
			if(StringUtils.isBlank(reqStr)) {
				throw new KsException(ErrorEnums.INPUT_ARGUMENT_ERROR , "input request[" + request + "] error !") ;
			}
			
			try {
				socket.getOutputStream().write(Native.toByteArray(reqStr)) ;
			} catch (IOException e) {
				throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
			}
			
			try {
				socket.getInputStream().read(buff) ;
				String resp = Native.toString(buff,Constant.CHARSET_GBK) ;
				ResponseParser<T> parser = new ResponseParser<T>(request.getResponseClass()) ;
				T response = parser.parse(resp) ;
				
				//是否有子数据
				if(ReflectionExUtils.isImplInterface(response.getClass(), SubDataAware.class)) {
					_awareSubData((SubDataAware<?>) response) ;
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
	private <T extends KsSubDataResponse> void _awareSubData(SubDataAware<T> response) throws IOException  {
		SubDataAware<T> subDataAware = (SubDataAware<T>)response ;
		int subDataCount = subDataAware.getSubDataCount() ;
		for(int i = 0 ;i<subDataCount ;i++) {
			//读子数据
			socket.getInputStream().read(buff) ;
			String subResp = Native.toString(buff,Constant.CHARSET_GBK) ;
			if(StringUtils.isNotBlank(subResp)) {
				SubDataResponseParser<T> subDataParser = new SubDataResponseParser<T>(subDataAware.getSubDataClass()) ;
				T object = subDataParser.parse(subResp) ;
				List<T> subDataList = response.getSubData() ;
				if(subDataList == null) {
					throw new IllegalStateException("SubDataAware[" + response.getClass() + "] method [getSubData] cant be null !") ;
				}
				
				subDataList.add(object) ;
			}
			
		}
	}
	
	@Override
	public KsLoginResponse login(KsLoginRequest request) throws KsException {
		if(isLogin){
			throw new KsException(ErrorEnums.ALREADY_LOGIN , "account[" + request.getAccount() + "] is aready login") ;
		}
		KsLoginResponse response = execute(request) ;
		account = new StockAccountDTO(response) ;
		isLogin = true ;
		return response;
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
