package com.doucome.stockop.biz.core.ks.enums;

/**
 * 买卖类型
 * @author langben 2013-7-2
 *
 */
public enum TrasactionTypeEnums {
	/**
	 * 基金申购
	 */
	FUND_PURCHASE("0"),
	
	/**
	 * 证券买入
	 */
	SECURITIES_BUY("1") ,
	
	/**
	 * 证券卖出
	 */
	SECURITIES_SELL("2") ,
	
	/**
	 * 债转股
	 */
	DEBT_EQUITY_SWAP("5") ,
	
	/**
	 * 回售
	 */
	BACK_SELL("6") ,
	
	/**
	 * 预买
	 */
	PRE_BUY("7") ,
	
	/**
	 * 预卖
	 */
	PRE_SELL("8") ,
	
	/**
	 * 基金赎回
	 */
	FUND_REDEMPTION("9") ,  
	
	/**
	 * 行权
	 */
	EXERCISE("Q") ,
	
	
	;
	
	private TrasactionTypeEnums(String  value) {
		this.value = value ;
	}
	
	private String value ;

	public String getValue() {
		return value;
	}
	
}
