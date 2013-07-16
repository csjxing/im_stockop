package com.doucome.stockop.biz.core.ks.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.doucome.stockop.biz.core.ks.SubDataResponseAware;
import com.doucome.stockop.biz.core.ks.enums.DealStatusEnums;

public class KsQueryCommissionsResponse extends KsResponse implements SubDataResponseAware<KsQueryCommissionsResponse.SubData> {

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
		return recordCount ;
	}

	@Override
	public List<SubData> getSubData() {
		return subDataList ;
	}

	@Override
	public Class<SubData> getSubDataClass() {
		return KsQueryCommissionsResponse.SubData.class ;
	}
	
	/**
	 * 只考虑返回明细值的情况
	 * @author langben 2013-7-10
	 *
	 */
	public static class SubData extends KsSubDataResponse {
		
		/**
		 * 股东账号
		 */
		private String stockholder ;
		
		/**
		 * 买卖类型名称
		 */
		private String transactionTypeName ;
		
		/**
		 * 证券代码
		 */
		private String stockCode ;
		
		/**
		 * 证券名称
		 */
		private String stockName ;
		
		/**
		 * 委托数量
		 */
		private Integer commissionAmount ;
		
		/**
		 * 委托价格
		 */
		private BigDecimal commissionPrice ;
		
		/**
		 *  合同号
		 */
		private Integer contract ;
		
		/**
		 * 成交数量
		 */
		private Integer dealAmount ;
		
		/**
		 * 成交价格
		 */
		private BigDecimal dealPrice ;
		
		/**
		 * 委托状态，固定为0
		 */
		private String commissionStatus ;
		
		/**
		 * 委托状态名称
		 */
		private String commissionStatusName ;
		
		/**
		 * 委托时间
		 */
		private String commissionDate ;
		
		/**
		 * 日期
		 */
		private String date ;
		
		/**
		 * 出错信息
		 */
		private String errorMsg ;
		
		/**
		 * 成功标志
		 */
		private String successFlag ;
		
		/**
		 * 市场代码
		 */
		private String marketCode ;
		
		/**
		 * 买卖类别标志 ,1买，2卖
		 */
		private String trasactionType ;
		
		/**
		 * 成交状态
		 * @see {@link DealStatusEnums }
		 */
		private String dealStatusFlag ;
		
		/**
		 * 买卖类型名称
		 */
		private String transactionTypeName1 ;
		
		/**
		 * 错误代码
		 */
		private String errorCode ;
		
		/**
		 * 撤单数量
		 */
		private Integer cancellationCount ;
		
		/**
		 * 委托属性,比如融资买入,融资卖出等等,中文输出
		 */
		private String commissionProp ;
		
		/**
		 * 成交金额
		 */
		private BigDecimal dealAmountTotal ;
		
		/**
		 * 平仓标志。1：平仓
		 */
		private String closeOutFlag ;
		
		/**
		 * 平仓标志名称
		 */
		private String closeOutFlagName ;
		
		/**
		 * 委托子业务
		 */
		private String commissionSubsidiary ;
		
		/**
		 * 约定号，委托子业务为z30、z40时必输
		 */
		private String agreement ;
		
		/**
		 * 对方交易单元，委托子业务为z30、z40时必输
		 */
		private String targetTradeUnit ;
		
		/**
		 * 还券模式
		 */
		private Integer returnSecuritiesMode ;

		public String getStockholder() {
			return stockholder;
		}

		public void setStockholder(String stockholder) {
			this.stockholder = stockholder;
		}

		public String getTransactionTypeName() {
			return transactionTypeName;
		}

		public void setTransactionTypeName(String transactionTypeName) {
			this.transactionTypeName = transactionTypeName;
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

		public Integer getCommissionAmount() {
			return commissionAmount;
		}

		public void setCommissionAmount(Integer commissionAmount) {
			this.commissionAmount = commissionAmount;
		}

		public BigDecimal getCommissionPrice() {
			return commissionPrice;
		}

		public void setCommissionPrice(BigDecimal commissionPrice) {
			this.commissionPrice = commissionPrice;
		}

		public Integer getContract() {
			return contract;
		}

		public void setContract(Integer contract) {
			this.contract = contract;
		}

		public Integer getDealAmount() {
			return dealAmount;
		}

		public void setDealAmount(Integer dealAmount) {
			this.dealAmount = dealAmount;
		}

		public BigDecimal getDealPrice() {
			return dealPrice;
		}

		public void setDealPrice(BigDecimal dealPrice) {
			this.dealPrice = dealPrice;
		}

		public String getCommissionStatus() {
			return commissionStatus;
		}

		public void setCommissionStatus(String commissionStatus) {
			this.commissionStatus = commissionStatus;
		}

		public String getCommissionStatusName() {
			return commissionStatusName;
		}

		public void setCommissionStatusName(String commissionStatusName) {
			this.commissionStatusName = commissionStatusName;
		}

		public String getCommissionDate() {
			return commissionDate;
		}

		public void setCommissionDate(String commissionDate) {
			this.commissionDate = commissionDate;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getErrorMsg() {
			return errorMsg;
		}

		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}

		public String getSuccessFlag() {
			return successFlag;
		}

		public void setSuccessFlag(String successFlag) {
			this.successFlag = successFlag;
		}

		public String getMarketCode() {
			return marketCode;
		}

		public void setMarketCode(String marketCode) {
			this.marketCode = marketCode;
		}

		public String getTrasactionType() {
			return trasactionType;
		}

		public void setTrasactionType(String trasactionType) {
			this.trasactionType = trasactionType;
		}

		public String getDealStatusFlag() {
			return dealStatusFlag;
		}

		public void setDealStatusFlag(String dealStatusFlag) {
			this.dealStatusFlag = dealStatusFlag;
		}

		public String getTransactionTypeName1() {
			return transactionTypeName1;
		}

		public void setTransactionTypeName1(String transactionTypeName1) {
			this.transactionTypeName1 = transactionTypeName1;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public Integer getCancellationCount() {
			return cancellationCount;
		}

		public void setCancellationCount(Integer cancellationCount) {
			this.cancellationCount = cancellationCount;
		}

		public String getCommissionProp() {
			return commissionProp;
		}

		public void setCommissionProp(String commissionProp) {
			this.commissionProp = commissionProp;
		}

		public BigDecimal getDealAmountTotal() {
			return dealAmountTotal;
		}

		public void setDealAmountTotal(BigDecimal dealAmountTotal) {
			this.dealAmountTotal = dealAmountTotal;
		}

		public String getCloseOutFlag() {
			return closeOutFlag;
		}

		public void setCloseOutFlag(String closeOutFlag) {
			this.closeOutFlag = closeOutFlag;
		}

		public String getCloseOutFlagName() {
			return closeOutFlagName;
		}

		public void setCloseOutFlagName(String closeOutFlagName) {
			this.closeOutFlagName = closeOutFlagName;
		}

		public String getCommissionSubsidiary() {
			return commissionSubsidiary;
		}

		public void setCommissionSubsidiary(String commissionSubsidiary) {
			this.commissionSubsidiary = commissionSubsidiary;
		}

		public String getAgreement() {
			return agreement;
		}

		public void setAgreement(String agreement) {
			this.agreement = agreement;
		}

		public String getTargetTradeUnit() {
			return targetTradeUnit;
		}

		public void setTargetTradeUnit(String targetTradeUnit) {
			this.targetTradeUnit = targetTradeUnit;
		}

		public Integer getReturnSecuritiesMode() {
			return returnSecuritiesMode;
		}

		public void setReturnSecuritiesMode(Integer returnSecuritiesMode) {
			this.returnSecuritiesMode = returnSecuritiesMode;
		}
		
	}

	
}
