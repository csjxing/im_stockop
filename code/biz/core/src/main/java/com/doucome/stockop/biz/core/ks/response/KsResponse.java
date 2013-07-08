package com.doucome.stockop.biz.core.ks.response;

import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;
import com.doucome.stockop.biz.core.model.AbstractModel;

public abstract class KsResponse extends AbstractModel {
	
	private String flag = "A";
	
	/**
	 * 发起源地址
	 */
	protected String ip ;
	
	/**
	 * 请求编号
	 */
	protected Integer seq ;
	
	/**
	 * 
	 */
	protected String success ; 
	

	public boolean isSuccess() {
		return StringUtils.equals(success , "Y") ;
	}
	
	public ErrorEnums getError() {
		return null ;
	}
	
	public String getErrorMsg(){
		return null ;
	}
}
