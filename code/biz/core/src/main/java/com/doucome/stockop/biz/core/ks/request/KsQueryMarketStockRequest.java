package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.response.KsQueryMarketStockResponse;

/**
 * 查询券商可融券余额 (56号包)
 * @author langben 2013-7-10
 *
 */
public class KsQueryMarketStockRequest extends KsRequest<KsQueryMarketStockResponse> {

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
	 * 查询市场代码
	 */
	private String queryMarketCode ;
	
	/**
	 * 查询证券代码
	 */
	private String queryStockCode ;
	
	/**
	 * 股东代码
	 */
	private String stockholderCode ; 
	
	/**
	 * 索引市场代码
	 */
	private String indexMarketCode ;
	
	/**
	 * 索引证券代码
	 */
	private String indexStockCode ;
	
	/**
	 * 索引股东代码
	 */
	private String indexStockholderCode ; 
	
	/**
	 * 最多返回数量
	 */
	private Integer maxResultCount ;
	
	/**
	 * 操作功能，1明细、2汇总
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String operate ;
	
	/**
	 * 委托方式
	 */
	private String commissionWay ;
	
	/**
	 * 货币代码，当查询市场代码为空而货币代码不为空时，则查询该货币的市场{沪A和深A}
	 */
	private String currencyCode ;
	
	/**
	 * 是否返回合计值，1：返回合计值，其他不返回
	 */
	private String isTotal ;
	
	/**
	 * 点评起始日期
	 */
	private String commentStartDate ;
	
	/**
	 * 空：正常查询，1：已融券清单（股票负债），2:可融资买入的证券,3:可融券卖出的证券
	 */
	private String marginFlag ;
	
	@Override
	public Class<KsQueryMarketStockResponse> getResponseClass() {
		return KsQueryMarketStockResponse.class ;
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

	public String getQueryMarketCode() {
		return queryMarketCode;
	}

	public void setQueryMarketCode(String queryMarketCode) {
		this.queryMarketCode = queryMarketCode;
	}

	public String getQueryStockCode() {
		return queryStockCode;
	}

	public void setQueryStockCode(String queryStockCode) {
		this.queryStockCode = queryStockCode;
	}

	public String getStockholderCode() {
		return stockholderCode;
	}

	public void setStockholderCode(String stockholderCode) {
		this.stockholderCode = stockholderCode;
	}

	public String getIndexMarketCode() {
		return indexMarketCode;
	}

	public void setIndexMarketCode(String indexMarketCode) {
		this.indexMarketCode = indexMarketCode;
	}

	public String getIndexStockCode() {
		return indexStockCode;
	}

	public void setIndexStockCode(String indexStockCode) {
		this.indexStockCode = indexStockCode;
	}

	public String getIndexStockholderCode() {
		return indexStockholderCode;
	}

	public void setIndexStockholderCode(String indexStockholderCode) {
		this.indexStockholderCode = indexStockholderCode;
	}

	public Integer getMaxResultCount() {
		return maxResultCount;
	}

	public void setMaxResultCount(Integer maxResultCount) {
		this.maxResultCount = maxResultCount;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getIsTotal() {
		return isTotal;
	}

	public void setIsTotal(String isTotal) {
		this.isTotal = isTotal;
	}

	public String getCommentStartDate() {
		return commentStartDate;
	}

	public void setCommentStartDate(String commentStartDate) {
		this.commentStartDate = commentStartDate;
	}

	public String getMarginFlag() {
		return marginFlag;
	}

	public void setMarginFlag(String marginFlag) {
		this.marginFlag = marginFlag;
	}

}
