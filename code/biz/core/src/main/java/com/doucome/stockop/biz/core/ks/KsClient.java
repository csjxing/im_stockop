package com.doucome.stockop.biz.core.ks;

import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsRequest;
import com.doucome.stockop.biz.core.ks.response.KsResponse;

/**
 * 长链接维持
 * @author langben 2013-7-6
 *
 */
public interface KsClient {

	public <T extends KsResponse> T execute(KsRequest<T> request) throws KsException ; 
}
