package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.response.KsCommissionResponse;

/**
 * 委托（挂单）
 * @author langben 2013-7-8
 *
 */
public class KsCommissionRequest extends KsRequest<KsCommissionResponse>{

	@Override
	public Class<KsCommissionResponse> getResponseClass() {
		return KsCommissionResponse.class ;
	}

}
