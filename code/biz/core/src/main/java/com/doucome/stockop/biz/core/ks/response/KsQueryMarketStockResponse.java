package com.doucome.stockop.biz.core.ks.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.doucome.stockop.biz.common.utils.NumberUtils;
import com.doucome.stockop.biz.core.ks.SubDataResponseAware;


/**
 * 查询券商可融券余额 (56号包)返回
 * @author langben 2013-7-10
 *
 */
public class KsQueryMarketStockResponse extends KsResponse implements SubDataResponseAware<KsQueryMarketStockResponse.SubData>{

	/**
	 * 记录个数
	 */
	private Integer recordCount ;
	
	/**
	 * 子记录
	 */
	private List<SubData> subDataList = new ArrayList<SubData>() ;

	@Override
	public int getSubDataCount() {
		return NumberUtils.parseInt(recordCount) ;
	}

	@Override
	public List<SubData> getSubData() {
		return subDataList ;
	}
	
	@Override
	public Class<SubData> getSubDataClass() {
		return KsQueryMarketStockResponse.SubData.class ;
	}
		
	/**
	 * 只考虑返回明细值的情况
	 * @author langben 2013-7-10
	 *
	 */
	public static class SubData extends KsSubDataResponse {
		
		/**
		 * 市场代码
		 */
		private String marketCode ;
		
		/**
		 * 股东账号
		 */
		private String stockholder ;
		
		/**
		 * 证券代码
		 */
		private String stockCode ;
	
		/**
		 * 证券名称
		 */
		private String stockName ;
		
		/**
		 * 余额(加上当日买卖)
		 */
		private Integer balance ;
		
		/**
		 * 可用余额
		 */
		private Integer availableBalance ;
		
		/**
		 * 当日买入成交数量
		 */
		private Integer todayBuyDealCount;
		
		/**
		 * 当日卖出成交数量
		 */
		private Integer todaySellDealCount ;
		
		/**
		 * 当日买入成交金额
		 */
		private BigDecimal todayBuyDealAmount ;
		
		/**
		 * 成本价格
		 */
		private BigDecimal costPrice ;
		
		/**
		 * 最新价格
		 */
		private BigDecimal recentPrice ;
		
		/**
		 * 市值
		 */
		private BigDecimal marketValue ;
		
		/**
		 * 浮动盈亏（汇总查询时、股东帐号为空格）
		 */
		private BigDecimal floatingProfitAndLoss ;
		
		/**
		 * 当日卖出成交金额
		 */
		private BigDecimal todaySellDealAmount ;
		
		/**
		 * 点评日期
		 */
		private String commentDate ;
		
		/**
		 * 一句话点评信息
		 */
		private String oneWordComment ;
		
		/**
		 * 国债净价（非国债为最新价）
		 */
		private BigDecimal nationalDebtNetPrice ;
		
		/**
		 * 每百元应计利息（非国债为0）
		 */
		private BigDecimal accrualEveryHundred ;
		
		/**
		 * 买入均价
		 */
		private BigDecimal buyAvgPrice ;
		
		/**
		 * 总库存（含超限库存）
		 */
		private BigDecimal totalInStock ;
		
		/**
		 * 总市值（含超限库存）
		 */
		private BigDecimal totalMarketValue ;

		public String getMarketCode() {
			return marketCode;
		}

		public void setMarketCode(String marketCode) {
			this.marketCode = marketCode;
		}

		public String getStockholder() {
			return stockholder;
		}

		public void setStockholder(String stockholder) {
			this.stockholder = stockholder;
		}

		public String getStockCode() {
			return stockCode;
		}

		public void setStockCode(String stockCode) {
			this.stockCode = stockCode;
		}

		public String getStockName() {
			return stockName;
		}

		public void setStockName(String stockName) {
			this.stockName = stockName;
		}

		public Integer getBalance() {
			return balance;
		}

		public void setBalance(Integer balance) {
			this.balance = balance;
		}

		public Integer getAvailableBalance() {
			return availableBalance;
		}

		public void setAvailableBalance(Integer availableBalance) {
			this.availableBalance = availableBalance;
		}

		public Integer getTodayBuyDealCount() {
			return todayBuyDealCount;
		}

		public void setTodayBuyDealCount(Integer todayBuyDealCount) {
			this.todayBuyDealCount = todayBuyDealCount;
		}

		public Integer getTodaySellDealCount() {
			return todaySellDealCount;
		}

		public void setTodaySellDealCount(Integer todaySellDealCount) {
			this.todaySellDealCount = todaySellDealCount;
		}

		public BigDecimal getTodayBuyDealAmount() {
			return todayBuyDealAmount;
		}

		public void setTodayBuyDealAmount(BigDecimal todayBuyDealAmount) {
			this.todayBuyDealAmount = todayBuyDealAmount;
		}

		public BigDecimal getCostPrice() {
			return costPrice;
		}

		public void setCostPrice(BigDecimal costPrice) {
			this.costPrice = costPrice;
		}

		public BigDecimal getRecentPrice() {
			return recentPrice;
		}

		public void setRecentPrice(BigDecimal recentPrice) {
			this.recentPrice = recentPrice;
		}

		public BigDecimal getMarketValue() {
			return marketValue;
		}

		public void setMarketValue(BigDecimal marketValue) {
			this.marketValue = marketValue;
		}

		public BigDecimal getFloatingProfitAndLoss() {
			return floatingProfitAndLoss;
		}

		public void setFloatingProfitAndLoss(BigDecimal floatingProfitAndLoss) {
			this.floatingProfitAndLoss = floatingProfitAndLoss;
		}

		public BigDecimal getTodaySellDealAmount() {
			return todaySellDealAmount;
		}

		public void setTodaySellDealAmount(BigDecimal todaySellDealAmount) {
			this.todaySellDealAmount = todaySellDealAmount;
		}

		public String getCommentDate() {
			return commentDate;
		}

		public void setCommentDate(String commentDate) {
			this.commentDate = commentDate;
		}

		public String getOneWordComment() {
			return oneWordComment;
		}

		public void setOneWordComment(String oneWordComment) {
			this.oneWordComment = oneWordComment;
		}

		public BigDecimal getNationalDebtNetPrice() {
			return nationalDebtNetPrice;
		}

		public void setNationalDebtNetPrice(BigDecimal nationalDebtNetPrice) {
			this.nationalDebtNetPrice = nationalDebtNetPrice;
		}

		public BigDecimal getAccrualEveryHundred() {
			return accrualEveryHundred;
		}

		public void setAccrualEveryHundred(BigDecimal accrualEveryHundred) {
			this.accrualEveryHundred = accrualEveryHundred;
		}

		public BigDecimal getBuyAvgPrice() {
			return buyAvgPrice;
		}

		public void setBuyAvgPrice(BigDecimal buyAvgPrice) {
			this.buyAvgPrice = buyAvgPrice;
		}

		public BigDecimal getTotalInStock() {
			return totalInStock;
		}

		public void setTotalInStock(BigDecimal totalInStock) {
			this.totalInStock = totalInStock;
		}

		public BigDecimal getTotalMarketValue() {
			return totalMarketValue;
		}

		public void setTotalMarketValue(BigDecimal totalMarketValue) {
			this.totalMarketValue = totalMarketValue;
		}	
		
	}
	
}
