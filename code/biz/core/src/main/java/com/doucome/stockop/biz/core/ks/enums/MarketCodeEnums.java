package com.doucome.stockop.biz.core.ks.enums;

public enum MarketCodeEnums {

	/**
	 * 上海A股
	 */
	SH_A("1"),
	
	/**
	 * 深圳A股
	 */
	SZ_A("2") ,
	
	/**
	 * 上海B股
	 */
	SH_B("3") ,
	
	/**
	 * 深圳B股
	 */
	SZ_B("4") ,
	;
	
	private MarketCodeEnums(String value) {
		this.value = value ;
	}
	
	private String value ;

	public String getValue() {
		return value;
	}
	
}
