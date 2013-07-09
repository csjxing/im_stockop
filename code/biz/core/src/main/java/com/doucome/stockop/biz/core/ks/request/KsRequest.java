package com.doucome.stockop.biz.core.ks.request;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.ReflectionUtils;

import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.core.ks.exception.KsRuleException;
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
	
	/**
	 * 检查输入参数
	 * @return
	 * @throws KsRuleException 输入的参数不符合要求
	 */
	public boolean check() throws KsRuleException {
		return true ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toRequest(){
		
		List<String> order = getFieldOrder() ;
		StringBuilder reqBuff = new StringBuilder() ;
		Class<?> clazz = this.getClass() ;
		for(String fieldName : order) {
			Field f = ReflectionUtils.findField(clazz, fieldName) ;
			if(f != null) {
				ReflectionUtils.makeAccessible(f) ;
				Object o = ReflectionUtils.getField(f, this) ;
				if(o != null) {
					reqBuff.append(String.valueOf(o)) ;
				}  
				reqBuff.append(KsConstant.PROTOCOL_SPLIT) ;
			}
		}
		
		return reqBuff.toString() ;
	}
	
	/**
	 * ResponseClass
	 * @return
	 */
	public abstract Class<T> getResponseClass() ;
	
	/**
	 * 
	 * @return
	 */
	public List<String> getFieldOrder() {
		Field[] fieldList = this.getClass().getDeclaredFields() ;
		List<String> order = new ArrayList<String>() ;
		order.add("flag") ;
		order.add("ip") ;
		order.add("seq") ;
		order.add("function") ;
		order.add("sourceExchangeCode") ;
		if(ArrayUtils.isNotEmpty(fieldList)) {
			for(Field f : fieldList) {
				order.add(f.getName()) ;
			}
		}
		return order ;
	}

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
