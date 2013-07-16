package com.doucome.stockop.biz.core.ks.request;

import java.math.BigDecimal;

import com.doucome.stockop.biz.core.ks.SubDataRequestAware;
import com.doucome.stockop.biz.core.ks.constant.SeqGenrator;
import com.doucome.stockop.biz.core.ks.response.KsQueryCommissionsResponse;
import com.doucome.stockop.biz.core.utils.NetworkUtils;

/**
 * 委托（挂单）查询
 * @author langben 2013-7-10
 *
 */
public class KsQueryCommissionsRequest extends KsRequest<KsQueryCommissionsResponse> implements SubDataRequestAware {

	public KsQueryCommissionsRequest() {
		this.function = 14 ;
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
	 * 起始日期
	 */
	private String startDate ;
	
	/**
	 * 结束日期
	 */
	private String endDate ;
	
	/**
	 * 合同号，为空格时查询所有数据
	 */
	private Integer contract ;
	
	/**
	 * 证券代码，为空格时查询所有股票数据
	 */
	private String stockCode ;
	
	/**
	 * 最多返回数量
	 */
	private Integer maxResultCount ;
	
	/**
	 * 索引日期
	 */
	private String indexDate ;
	
	/**
	 * 索引合同号
	 */
	private Integer indexContract ;
	
	/**
	 * 委托方式
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String commissionWay ; 
	
	/**
	 * 索引市场代码
	 */
	private String indexMarketCode ;
	
	/**
	 * 排序,0-市场代码、1-委托时间、2-委托时间倒序
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String sort ;
	
	/**
	 * 查询买卖标志 , 1买入、2卖出
	 */
	private String sellOrBuy ;

	/**
	 * 查询委托价格
	 */
	private BigDecimal commissionPrice ;
	
	/**
	 * 委托数量
	 */
	private Integer commissionAmount ;
	
	/**
	 * 是否汇总，空、0表示不汇总，对委托数量、委托价格、成交数量、成交价格进行汇总和求平均值
	 */
	private String isTotal ;
	
	/**
	 * 可撤委托标志,空或0表示全部,1表示只查询可撤委托
	 */
	private Integer canCancellationFlag ;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getContract() {
		return contract;
	}

	public void setContract(Integer contract) {
		this.contract = contract;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Integer getMaxResultCount() {
		return maxResultCount;
	}

	public void setMaxResultCount(Integer maxResultCount) {
		this.maxResultCount = maxResultCount;
	}

	public String getIndexDate() {
		return indexDate;
	}

	public void setIndexDate(String indexDate) {
		this.indexDate = indexDate;
	}

	public Integer getIndexContract() {
		return indexContract;
	}

	public void setIndexContract(Integer indexContract) {
		this.indexContract = indexContract;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

	public String getIndexMarketCode() {
		return indexMarketCode;
	}

	public void setIndexMarketCode(String indexMarketCode) {
		this.indexMarketCode = indexMarketCode;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSellOrBuy() {
		return sellOrBuy;
	}

	public void setSellOrBuy(String sellOrBuy) {
		this.sellOrBuy = sellOrBuy;
	}

	public BigDecimal getCommissionPrice() {
		return commissionPrice;
	}

	public void setCommissionPrice(BigDecimal commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	public Integer getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(Integer commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public String getIsTotal() {
		return isTotal;
	}

	public void setIsTotal(String isTotal) {
		this.isTotal = isTotal;
	}

	public Integer getCanCancellationFlag() {
		return canCancellationFlag;
	}

	public void setCanCancellationFlag(Integer canCancellationFlag) {
		this.canCancellationFlag = canCancellationFlag;
	}

	@Override
	public Class<KsQueryCommissionsResponse> getResponseClass() {
		return KsQueryCommissionsResponse.class ;
	}
	
}

