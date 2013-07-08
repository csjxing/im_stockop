package com.doucome.stockop.biz.core.ks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;

public class DefaultKsClientFactory implements KsClientFactory {
	
	private String server ;
	
	private int serverPort ;

	private Map<String,KsClient> clientMap = new ConcurrentHashMap<String,KsClient>() ;
	
	private Lock lock = new ReentrantLock() ;
	
	@Override
	public KsClient newClient(KsLoginRequest loginRequest) throws KsException {
		
		String accountId = loginRequest.getAccount() ;
		
		lock.lock() ;
		
		try {
			//FIXME 优化登陆，包括处理超时，登出等
			if(clientMap.containsKey(accountId)) {
				return clientMap.get(accountId) ;
			} 
			
			KsClient client = new DefaultKsClient(server ,serverPort) ; //链接服务器
			KsLoginResponse response = client.execute(loginRequest) ; //执行登陆操作
			if(response.isSuccess()) {
				clientMap.put(accountId, client) ;
				return client ;
			} else {
				throw new KsException(response.getError() , response.getErrorMsg()) ;
			}
			
		} finally {
			lock.unlock() ;
		}
	}
	
	@Override
	public KsClient findClient(String accountId) {
		return clientMap.get(accountId) ;
	}
	

	public void setServer(String server) {
		this.server = server;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

}
