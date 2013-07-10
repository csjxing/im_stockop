package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.response.KsBatchCancellationResponse;

/**
 * 批量撤单
 * @author langben 2013-7-10
 *
 */
public class KsBatchCancellationRequest extends KsRequest<KsBatchCancellationResponse> {

	@Override
	public Class<KsBatchCancellationResponse> getResponseClass() {
		return KsBatchCancellationResponse.class ;
	}

}
