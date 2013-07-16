package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.constant.SeqGenrator;
import com.doucome.stockop.biz.core.ks.response.KsResponse;

/**
 * 用于读取后续包
 * @author langben 2013-7-16
 *
 */
public class KsSubDataRequest extends KsRequest<KsResponse> {

	/**
	 * 委托方式
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String commissionWay ;
	
	public KsSubDataRequest(){
		this.function = 0 ;
		this.seq = SeqGenrator.nextSeq() ;
	}
	
	@Override
	public Class<KsResponse> getResponseClass() {
		return KsResponse.class ;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

}
