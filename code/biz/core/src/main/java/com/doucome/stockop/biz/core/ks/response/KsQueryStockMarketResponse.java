package com.doucome.stockop.biz.core.ks.response;

import java.math.BigDecimal;

/**
 * 股票行情
 * @author langben 2013-8-9
 *
 */
public class KsQueryStockMarketResponse extends KsResponse {

	/**
	 * 指数
	 */
	private BigDecimal index ;
	
	/**
	 * 固定价格标志，固定为N
	 */
	private String fixedPriceFlag ;
	
	/**
	 * 固定数量标志，固定为N
	 */
	private String fixedAmountFlag ;
	
	/**
	 * 证券代码
	 */
	private String stockCode ;
	
	/**
	 * 证券名称
	 */
	private String stockName ;
	
	/**
	 * 交易单位
	 */
	private Integer tradeUnit ;
	
	/**
	 * 市场委托许可
	 */
	private BigDecimal marketCommissionAllowance ;

	/**
	 * 绝对报价上限
	 */
	private BigDecimal absoluteQuoteUpperLimit ;
	
	/**
	 * 绝对报价下限
	 */
	private BigDecimal absoluteQuoteLowerLimit ;
	
	/**
	 * 最新价
	 */
	private BigDecimal recentPrice ;
	
	/**
	 * 最新价成交量
	 */
	private Integer recentPriceDealCount ;
	
	/**
	 * 总成交金额
	 */
	private BigDecimal totalDealAmount ;
	
	/**
	 * 昨日收盘价
	 */
	private BigDecimal YesterdayClosingPrice ;
	
	/**
	 * 买价1
	 */
	private BigDecimal buyPrice1 ;
	
	/**
	 * 买量1
	 */
	private Integer buyCount1 ;
	
	/**
	 * 买价2
	 */
	private BigDecimal buyPrice2 ;
	
	/**
	 * 买量2
	 */
	private Integer buyCount2 ;
	
	/**
	 * 买价3
	 */
	private BigDecimal buyPrice3 ;
	
	/**
	 * 买量3
	 */
	private Integer buyCount3 ;
	
	/**
	 * 卖价1
	 */
	private BigDecimal sellPrice1 ;
	
	/**
	 * 卖量1
	 */
	private Integer sellCount1 ;
	
	/**
	 * 卖价2
	 */
	private BigDecimal sellPrice2 ;
	
	/**
	 * 卖量2
	 */
	private Integer sellCount2 ;
	
	/**
	 * 卖价3
	 */
	private BigDecimal sellPrice3 ;
	
	/**
	 * 卖量3
	 */
	private Integer sellCount3 ;
	
	/**
	 * 中买单位
	 */
	private Integer inBuyUnit ;
	
	/**
	 * 中卖单位
	 */
	private Integer inSellUnit ;
	
	/**
	 * 涨跌
	 */
	private String roseOrFell ;
	
	/**
	 * 涨跌幅度
	 */
	private BigDecimal roseOrFellRange ;
	
	/**
	 * 今开盘价
	 */
	private BigDecimal todayOpeningPrice ;
	
	/**
	 * 最高价
	 */
	private BigDecimal topPrice ;
	
	/**
	 * 最低价
	 */
	private BigDecimal bottomPrice ;
	
	/**
	 * 停牌标志
	 */
	private String suspensionFlag ;
	
	/**
	 * 涨跌值
	 */
	private BigDecimal roseOrFellValue ;
	
	/**
	 * 买价4
	 */
	private BigDecimal buyPrice4 ;
	
	/**
	 * 买量4
	 */
	private Integer buyCount4 ;
	
	/**
	 * 卖价4
	 */
	private BigDecimal sellPrice4 ;
	
	/**
	 * 卖量4
	 */
	private Integer sellCount4 ;
	
	/**
	 * 每百元应计利息额
	 */
	private BigDecimal hundredsAccrual ; 
	
	/**
	 * 国债全价
	 */
	private BigDecimal nationalDebtDirtyPrice ;
	
	/**
	 * 证券类别（大类+类别）
	 */
	private String stockType ;
	
	/**
	 * 买价5
	 */
	private BigDecimal buyPrice5 ;
	
	/**
	 * 买量5
	 */
	private Integer buyCount5 ;
	
	/**
	 * 卖价5
	 */
	private BigDecimal sellPrice5 ;
	
	/**
	 * 卖量5
	 */
	private Integer sellCount5 ;
	
	/**
	 * 基金标志
	 */
	private String fundFlag ;

	/**
	 * 昨日净值
	 */
	private BigDecimal yestodayNetValue ;
	
	/**
	 * 最近净值
	 */
	private BigDecimal recentNetValue ;
	
	/**
	 * 净值差
	 */
	private BigDecimal netValueDiff ;
	
	/**
	 * 净值差比例（含%）
	 */
	private BigDecimal netValueDiffPercent ;
	
	/**
	 * 价格档位
	 */
	private BigDecimal priceGear ;

	public BigDecimal getIndex() {
		return index;
	}

	public void setIndex(BigDecimal index) {
		this.index = index;
	}

	public String getFixedPriceFlag() {
		return fixedPriceFlag;
	}

	public void setFixedPriceFlag(String fixedPriceFlag) {
		this.fixedPriceFlag = fixedPriceFlag;
	}

	public String getFixedAmountFlag() {
		return fixedAmountFlag;
	}

	public void setFixedAmountFlag(String fixedAmountFlag) {
		this.fixedAmountFlag = fixedAmountFlag;
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

	public Integer getTradeUnit() {
		return tradeUnit;
	}

	public void setTradeUnit(Integer tradeUnit) {
		this.tradeUnit = tradeUnit;
	}

	public BigDecimal getMarketCommissionAllowance() {
		return marketCommissionAllowance;
	}

	public void setMarketCommissionAllowance(BigDecimal marketCommissionAllowance) {
		this.marketCommissionAllowance = marketCommissionAllowance;
	}

	public BigDecimal getAbsoluteQuoteUpperLimit() {
		return absoluteQuoteUpperLimit;
	}

	public void setAbsoluteQuoteUpperLimit(BigDecimal absoluteQuoteUpperLimit) {
		this.absoluteQuoteUpperLimit = absoluteQuoteUpperLimit;
	}

	public BigDecimal getAbsoluteQuoteLowerLimit() {
		return absoluteQuoteLowerLimit;
	}

	public void setAbsoluteQuoteLowerLimit(BigDecimal absoluteQuoteLowerLimit) {
		this.absoluteQuoteLowerLimit = absoluteQuoteLowerLimit;
	}

	public BigDecimal getRecentPrice() {
		return recentPrice;
	}

	public void setRecentPrice(BigDecimal recentPrice) {
		this.recentPrice = recentPrice;
	}

	public Integer getRecentPriceDealCount() {
		return recentPriceDealCount;
	}

	public void setRecentPriceDealCount(Integer recentPriceDealCount) {
		this.recentPriceDealCount = recentPriceDealCount;
	}

	public BigDecimal getTotalDealAmount() {
		return totalDealAmount;
	}

	public void setTotalDealAmount(BigDecimal totalDealAmount) {
		this.totalDealAmount = totalDealAmount;
	}

	public BigDecimal getYesterdayClosingPrice() {
		return YesterdayClosingPrice;
	}

	public void setYesterdayClosingPrice(BigDecimal yesterdayClosingPrice) {
		YesterdayClosingPrice = yesterdayClosingPrice;
	}

	public BigDecimal getBuyPrice1() {
		return buyPrice1;
	}

	public void setBuyPrice1(BigDecimal buyPrice1) {
		this.buyPrice1 = buyPrice1;
	}

	public Integer getBuyCount1() {
		return buyCount1;
	}

	public void setBuyCount1(Integer buyCount1) {
		this.buyCount1 = buyCount1;
	}

	public BigDecimal getBuyPrice2() {
		return buyPrice2;
	}

	public void setBuyPrice2(BigDecimal buyPrice2) {
		this.buyPrice2 = buyPrice2;
	}

	public Integer getBuyCount2() {
		return buyCount2;
	}

	public void setBuyCount2(Integer buyCount2) {
		this.buyCount2 = buyCount2;
	}

	public BigDecimal getBuyPrice3() {
		return buyPrice3;
	}

	public void setBuyPrice3(BigDecimal buyPrice3) {
		this.buyPrice3 = buyPrice3;
	}

	public Integer getBuyCount3() {
		return buyCount3;
	}

	public void setBuyCount3(Integer buyCount3) {
		this.buyCount3 = buyCount3;
	}

	public BigDecimal getSellPrice1() {
		return sellPrice1;
	}

	public void setSellPrice1(BigDecimal sellPrice1) {
		this.sellPrice1 = sellPrice1;
	}

	public Integer getSellCount1() {
		return sellCount1;
	}

	public void setSellCount1(Integer sellCount1) {
		this.sellCount1 = sellCount1;
	}

	public BigDecimal getSellPrice2() {
		return sellPrice2;
	}

	public void setSellPrice2(BigDecimal sellPrice2) {
		this.sellPrice2 = sellPrice2;
	}

	public Integer getSellCount2() {
		return sellCount2;
	}

	public void setSellCount2(Integer sellCount2) {
		this.sellCount2 = sellCount2;
	}

	public BigDecimal getSellPrice3() {
		return sellPrice3;
	}

	public void setSellPrice3(BigDecimal sellPrice3) {
		this.sellPrice3 = sellPrice3;
	}

	public Integer getSellCount3() {
		return sellCount3;
	}

	public void setSellCount3(Integer sellCount3) {
		this.sellCount3 = sellCount3;
	}

	public Integer getInBuyUnit() {
		return inBuyUnit;
	}

	public void setInBuyUnit(Integer inBuyUnit) {
		this.inBuyUnit = inBuyUnit;
	}

	public Integer getInSellUnit() {
		return inSellUnit;
	}

	public void setInSellUnit(Integer inSellUnit) {
		this.inSellUnit = inSellUnit;
	}

	public String getRoseOrFell() {
		return roseOrFell;
	}

	public void setRoseOrFell(String roseOrFell) {
		this.roseOrFell = roseOrFell;
	}

	public BigDecimal getRoseOrFellRange() {
		return roseOrFellRange;
	}

	public void setRoseOrFellRange(BigDecimal roseOrFellRange) {
		this.roseOrFellRange = roseOrFellRange;
	}

	public BigDecimal getTodayOpeningPrice() {
		return todayOpeningPrice;
	}

	public void setTodayOpeningPrice(BigDecimal todayOpeningPrice) {
		this.todayOpeningPrice = todayOpeningPrice;
	}

	public BigDecimal getTopPrice() {
		return topPrice;
	}

	public void setTopPrice(BigDecimal topPrice) {
		this.topPrice = topPrice;
	}

	public BigDecimal getBottomPrice() {
		return bottomPrice;
	}

	public void setBottomPrice(BigDecimal bottomPrice) {
		this.bottomPrice = bottomPrice;
	}

	public String getSuspensionFlag() {
		return suspensionFlag;
	}

	public void setSuspensionFlag(String suspensionFlag) {
		this.suspensionFlag = suspensionFlag;
	}

	public BigDecimal getRoseOrFellValue() {
		return roseOrFellValue;
	}

	public void setRoseOrFellValue(BigDecimal roseOrFellValue) {
		this.roseOrFellValue = roseOrFellValue;
	}

	public BigDecimal getBuyPrice4() {
		return buyPrice4;
	}

	public void setBuyPrice4(BigDecimal buyPrice4) {
		this.buyPrice4 = buyPrice4;
	}

	public Integer getBuyCount4() {
		return buyCount4;
	}

	public void setBuyCount4(Integer buyCount4) {
		this.buyCount4 = buyCount4;
	}

	public BigDecimal getSellPrice4() {
		return sellPrice4;
	}

	public void setSellPrice4(BigDecimal sellPrice4) {
		this.sellPrice4 = sellPrice4;
	}

	public Integer getSellCount4() {
		return sellCount4;
	}

	public void setSellCount4(Integer sellCount4) {
		this.sellCount4 = sellCount4;
	}

	public BigDecimal getHundredsAccrual() {
		return hundredsAccrual;
	}

	public void setHundredsAccrual(BigDecimal hundredsAccrual) {
		this.hundredsAccrual = hundredsAccrual;
	}

	public BigDecimal getNationalDebtDirtyPrice() {
		return nationalDebtDirtyPrice;
	}

	public void setNationalDebtDirtyPrice(BigDecimal nationalDebtDirtyPrice) {
		this.nationalDebtDirtyPrice = nationalDebtDirtyPrice;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public BigDecimal getBuyPrice5() {
		return buyPrice5;
	}

	public void setBuyPrice5(BigDecimal buyPrice5) {
		this.buyPrice5 = buyPrice5;
	}

	public Integer getBuyCount5() {
		return buyCount5;
	}

	public void setBuyCount5(Integer buyCount5) {
		this.buyCount5 = buyCount5;
	}

	public BigDecimal getSellPrice5() {
		return sellPrice5;
	}

	public void setSellPrice5(BigDecimal sellPrice5) {
		this.sellPrice5 = sellPrice5;
	}

	public Integer getSellCount5() {
		return sellCount5;
	}

	public void setSellCount5(Integer sellCount5) {
		this.sellCount5 = sellCount5;
	}

	public String getFundFlag() {
		return fundFlag;
	}

	public void setFundFlag(String fundFlag) {
		this.fundFlag = fundFlag;
	}

	public BigDecimal getYestodayNetValue() {
		return yestodayNetValue;
	}

	public void setYestodayNetValue(BigDecimal yestodayNetValue) {
		this.yestodayNetValue = yestodayNetValue;
	}

	public BigDecimal getRecentNetValue() {
		return recentNetValue;
	}

	public void setRecentNetValue(BigDecimal recentNetValue) {
		this.recentNetValue = recentNetValue;
	}

	public BigDecimal getNetValueDiff() {
		return netValueDiff;
	}

	public void setNetValueDiff(BigDecimal netValueDiff) {
		this.netValueDiff = netValueDiff;
	}

	public BigDecimal getNetValueDiffPercent() {
		return netValueDiffPercent;
	}

	public void setNetValueDiffPercent(BigDecimal netValueDiffPercent) {
		this.netValueDiffPercent = netValueDiffPercent;
	}

	public BigDecimal getPriceGear() {
		return priceGear;
	}

	public void setPriceGear(BigDecimal priceGear) {
		this.priceGear = priceGear;
	}
	
}
