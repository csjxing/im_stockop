package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.response.KsCancellationResponse;

/**
 * 撤单
 * @author langben 2013-7-8
 *
 */
public class KsCancellationRequest extends KsRequest<KsCancellationResponse> {

	@Override
	public Class<KsCancellationResponse> getResponseClass() {
		return KsCancellationResponse.class;
	}

}
