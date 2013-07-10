package com.doucome.stockop.biz.core.ks.enums;

public enum ErrorEnums {

	/**
	 * 连接错误
	 */
	NETWORK_ERROR(1000) ,
	
	/**
	 * 输入参数错误
	 */
	INPUT_ARGUMENT_ERROR(2001) ,
	
	/**
	 * 内部错误
	 */
	INTERNAL_ERROR(3001) ,
	
	/**
	 * 重复登录
	 */
	ALREADY_LOGIN(3002) ,
	
	/**
	 * 未登录
	 */
	NOT_LOGIN(3003) ,
	
	/**
	 * 调用远程业务错误
	 */
	REMOTE_INVOKE_ERROR(4001) ,
	
	/**
	 * 返回数据格式错误
	 */
	RESPONSE_FORMAT_ERROR(4002) ,
	
	/**
	 * 
	 */
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
