package com.doucome.stockop.biz.core.ks.enums;

/**
 * 买卖类型
 * @author langben 2013-7-2
 *
 */
public enum DealStatusEnums {
	/**
	 *未成交
	 */
	DOT_DEAL("W"),

	/**
	 * 已成
	 */
	DEAL("0") ,
	
	/**
	 * 部成
	 */
	PART_DEAL("1") ,
	
	/**
	 * 场内撤单
	 */
	IN_CANCELLATION("2") ,
	
	/**
	 * 部撤
	 */
	PART_CANCELLATION("3") ,
	
	/**
	 * 场外撤单
	 */
	OUT_CANCELLATION("4") ,
	
	/**
	 * 已报
	 */
	REPORTED("9") ,
	
	/**
	 * 请求撤单
	 */
	REQUEST_CANCELLATION("C") ,
	
	/**
	 * 撤单已发
	 */
	CANCELLATION_ISSUED("D") ,
	
	/**
	 * 默认，未成交
	 */
	DEFAULT_DOT_DEAL("") ,
	
	;
	
	private DealStatusEnums(String  value) {
		this.value = value ;
	}
	
	private String value ;

	public String getValue() {
		return value;
	}
	
}
