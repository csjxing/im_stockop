package com.doucome.stockop.biz.core.ks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.doucome.stockop.biz.core.constant.LogConstant;
import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;
import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.model.StockAccountDTO;
import com.doucome.stockop.biz.core.utils.MD5Utils;

public class DefaultKsClientFactory implements KsClientFactory {
	
	private Log signinLog = LogFactory.getLog(LogConstant.signin_log) ;
	
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
				KsClient existsClient = clientMap.get(accountId) ;
				if(existsClient != null){
					StockAccountDTO acc = existsClient.getAccount() ;
					if(acc != null && StringUtils.equals(acc.getMd5Password(), MD5Utils.md5(loginRequest.getPassword())) ){
						return existsClient ;
					} else {
						throw new KsException(ErrorEnums.ACC_OR_PSD_ERROR , "stockop.login.accOrPsd.error") ;
					}
				}
			} 
			
			KsClient client = new DefaultKsClient(server ,serverPort) ; //链接服务器
			KsLoginResponse response = client.login(loginRequest) ; //执行登陆操作
			if(response.isSuccess()) {
				clientMap.put(accountId, client) ;
				if(signinLog.isInfoEnabled()) {
					signinLog.info("signin success account[" + accountId + "] " + response) ;
				}
				return client ;
			} else {
				throw new KsException(ErrorEnums.REMOTE_INVOKE_ERROR, response.getSubCode() ,  response.getMsg()) ;
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
