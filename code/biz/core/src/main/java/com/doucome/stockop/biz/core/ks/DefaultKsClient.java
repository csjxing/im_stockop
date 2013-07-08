package com.doucome.stockop.biz.core.ks;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;
import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsRequest;
import com.doucome.stockop.biz.core.ks.response.KsResponse;
import com.sun.jna.Native;

public class DefaultKsClient implements KsClient {

	private Socket socket ;
	
	private byte[] buff = new byte[4096] ;
	
	private Lock lock = new ReentrantLock() ;
	
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
		lock.lock() ;
		try {
			String reqStr = request.toRequest() ;
			if(StringUtils.isBlank(reqStr)) {
				throw new KsException(ErrorEnums.INPUT_PARAM_ERROR , "input request[" + request + "] error !") ;
			}
			
			try {
				socket.getOutputStream().write(Native.toByteArray(reqStr)) ;
			} catch (IOException e) {
				throw new KsException(ErrorEnums.NETWORK_ERROR , e.getMessage() , e) ;
			}
			
			try {
				socket.getInputStream().read(buff) ;
				String resp = Native.toString(buff) ;
				ResponseParser<T> parser = new ResponseParser<T>(request.getResponseClass()) ;
				T response = parser.parse(resp) ;
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
}
