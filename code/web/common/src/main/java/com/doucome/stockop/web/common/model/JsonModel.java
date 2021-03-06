package com.doucome.stockop.web.common.model;

import org.apache.commons.lang.StringUtils;

/**
 * JsonModel
 * @param <T>
 */
public class JsonModel<T> {
	
	public static final String CODE_SUCCESS = "success";
	public static final String CODE_FAIL = "fail";
	public static final String CODE_ILL_ARGS = "ill_args";	
	public static final String CODE_AUTH_FAIL = "auth_fail" ;
	
	private String code;
	
	private String detail ;
	
	private Integer errorCode ;

	private T data;
	
	public boolean isSuccess(){
		return StringUtils.equals(code,CODE_SUCCESS) ; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public void setSuccess(T data) {
		setCode(JsonModel.CODE_SUCCESS);
		setData(data);
	}
	
	public void setFail(String detail) {
		setCode(JsonModel.CODE_FAIL) ;
		setDetail(detail) ;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
