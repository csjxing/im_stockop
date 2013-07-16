package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.response.KsCancellationResponse;

/**
 * 撤单
 * @author langben 2013-7-8
 *
 */
public class KsCancellationRequest extends KsRequest<KsCancellationResponse> {

	public KsCancellationRequest() {
		
	}
	/**
	 * 市场代码
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String marketCode ;
	
	/**
	 * 保留
	 */
	private String reserved ;
	
	/**
	 * 客户号
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String customerCode ;
	
	/**
	 * 合同号
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private Integer contract ;
	
	/**
	 * 委托方式
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String commissionWay ;
	
	@Override
	public Class<KsCancellationResponse> getResponseClass() {
		return KsCancellationResponse.class;
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

	public Integer getContract() {
		return contract;
	}

	public void setContract(Integer contract) {
		this.contract = contract;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

}
