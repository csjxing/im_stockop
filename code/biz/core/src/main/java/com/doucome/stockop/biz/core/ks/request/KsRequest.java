package com.doucome.stockop.biz.core.ks.request;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.core.ks.response.KsResponse;

public abstract class KsRequest <T extends KsResponse> {	
	
	private String flag = "R" ;

	/**
	 * 发起源地址
	 */
	protected String ip ;
	
	/**
	 * 请求编号
	 */
	protected Integer seq ;
	
	/**
	 * 功能编码
	 */
	protected Integer function ;
	
	/**
	 * 发起（源）营业部代码
	 */
	protected Integer sourceExchangeCode ;
	
	public boolean check() {
		return true ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toRequest(){
		Field[] fieldList = this.getClass().getFields() ;
		StringBuilder reqBuff = new StringBuilder() ;
		for(Field f : fieldList) {
			ReflectionUtils.makeAccessible(f) ;
			Object o = ReflectionUtils.getField(f, this) ;
			if(o != null) {
				reqBuff.append(String.valueOf(o)) ;
			}  
			reqBuff.append(KsConstant.PROTOCOL_SPLIT) ;
		}
		return reqBuff.toString() ;
	}
	
	public abstract Class<T> getResponseClass() ;

	public String getFlag() {
		return flag;
	}

	public String getIp() {
		return ip;
	}

	public Integer getSeq() {
		return seq;
	}

	public Integer getFunction() {
		return function;
	}

	public Integer getSourceExchangeCode() {
		return sourceExchangeCode;
	}

	public void setSourceExchangeCode(Integer sourceExchangeCode) {
		this.sourceExchangeCode = sourceExchangeCode;
	}

}
