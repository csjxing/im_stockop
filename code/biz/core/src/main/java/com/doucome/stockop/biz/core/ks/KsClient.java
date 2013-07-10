package com.doucome.stockop.biz.core.ks;

import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.request.KsRequest;
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.ks.response.KsResponse;
import com.doucome.stockop.biz.core.model.StockAccountDTO;

/**
 * 长链接客户端
 * @author langben 2013-7-6
 *
 */
public interface KsClient {

	/**
	 * 执行request请求，需要登陆情况下
	 * @param <T>
	 * @param request
	 * @return
	 * @throws KsException
	 */
	<T extends KsResponse> T execute(KsRequest<T> request) throws KsException ; 
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws KsException
	 */
	KsLoginResponse login(KsLoginRequest request) throws KsException ; 
	
	/**
	 * 
	 * @return
	 */
	StockAccountDTO getAccount() ;
	
	/**
	 * 
	 * @return
	 */
	boolean isLogin() ;
}
