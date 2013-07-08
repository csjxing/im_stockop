package com.doucome.stockop.biz.core.ks;

import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;

public interface KsClientFactory {

	/**
	 * 通过账号和密码，创建一个长连接
	 */
	KsClient newClient(KsLoginRequest loginRequest) throws KsException ;

	/**
	 * 根据accountId查找client
	 * @param accountId
	 * @return
	 */
	KsClient findClient(String accountId) ;
}
