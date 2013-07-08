package com.doucome.stockop.biz.core.ks.enums;

/**
 * 账户类型
 * @author langben 2013-7-2
 *
 */
public enum AccountTypeEnums {
	/**
	 * 客户号
	 */
	CUSTOMER("0"),
	
	/**
	 * 条码号或磁卡号
	 */
	BAR_OR_MAGNETIC_CARD("*") ,
	
	/**
	 * 上海A股
	 */
	SHANGHAI_A("1") ,
	;
	
	private AccountTypeEnums(String  value) {
		this.value = value ;
	}
	
	private String value ;

	public String getValue() {
		return value;
	}
	
}
