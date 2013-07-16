package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.constant.SeqGenrator;
import com.doucome.stockop.biz.core.ks.response.KsBatchCancellationResponse;
import com.doucome.stockop.biz.core.utils.NetworkUtils;

/**
 * 批量撤单
 * @author langben 2013-7-10
 *
 */
public class KsBatchCancellationRequest extends KsRequest<KsBatchCancellationResponse> {

	public KsBatchCancellationRequest() {
		this.function = 120 ;
		this.ip = NetworkUtils.getCachedLocalIP();
		this.seq = SeqGenrator.nextSeq() ;
	}
	
	/**
	 * 市场代码
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String marketCode ;
	
	/**
	 * 预留
	 */
	private String reserved ;
	
	/**
	 * 客户号
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String customerCode ;
	
	/**
	 * 批号（空或0表示全部撤单）
	 */
	private Integer commissionBatch ;
	
	/**
	 * 委托方式
	 */
	private String commissionWay ;
	
	@Override
	public Class<KsBatchCancellationResponse> getResponseClass() {
		return KsBatchCancellationResponse.class ;
	}

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Integer getCommissionBatch() {
		return commissionBatch;
	}

	public void setCommissionBatch(Integer commissionBatch) {
		this.commissionBatch = commissionBatch;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

}
