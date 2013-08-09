package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.SubDataRequestAware;
import com.doucome.stockop.biz.core.ks.constant.SeqGenrator;
import com.doucome.stockop.biz.core.ks.response.KsQueryStockMarketResponse;
import com.doucome.stockop.biz.core.utils.NetworkUtils;

/**
 * 查询股票行情
 * @author langben 2013-8-9
 *
 */
public class KsQueryStockMarketRequest extends KsRequest<KsQueryStockMarketResponse> implements SubDataRequestAware {

	public KsQueryStockMarketRequest() {
		this.function = 19 ;
		this.ip = NetworkUtils.getCachedLocalIP();
		this.seq = SeqGenrator.nextSeq() ;
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
	 * 股票代码
	 */
	private String stockCode ;
	
	/**
	 * 委托方式
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String commissionWay ;

	@Override
	public Class<KsQueryStockMarketResponse> getResponseClass() {
		return KsQueryStockMarketResponse.class ;
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

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}
	
}

