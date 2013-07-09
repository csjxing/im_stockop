package com.doucome.stockop.biz.core.ks.enums;

/**
 * 委托子业务
 * @author langben 2013-7-2
 *
 */
public enum CommissionSubsidiaryEnums {
	
	/**
	 * 正常委托
	 */
	NORMAL("000"),
	
	;
	
	private CommissionSubsidiaryEnums(String  value) {
		this.value = value ;
	}
	
	private String value ;

	public String getValue() {
		return value;
	}
	
}
