package com.doucome.stockop.biz.core.ks.enums;

public enum ErrorEnums {

	/**
	 * 链接错误
	 */
	NETWORK_ERROR(1000) ,
	
	INPUT_PARAM_ERROR(2001) ,
	
	INTERNAL_ERROR(3001) ,
	
	ACC_OR_PSD_ERROR(5001) ,
	;
	
	private ErrorEnums(int code) {
		this.code = code ;
	}
	
	private int code ;

	public int getCode() {
		return code;
	}
	
	
}
