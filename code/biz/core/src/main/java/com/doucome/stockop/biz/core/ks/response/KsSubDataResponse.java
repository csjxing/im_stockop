package com.doucome.stockop.biz.core.ks.response;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.dal.model.AbstractModel;

public abstract class KsSubDataResponse extends AbstractModel {

	protected String flag = KsConstant.RESPONSE_FLAG;
	
	/**
	 * 发起源地址
	 */
	protected String ip ;
	
	/**
	 * 请求编号
	 */
	protected Long seq ;
		
	/**
	 * 
	 * @return
	 */
	public List<String> getHeaderFieldOrder() {
		List<String> order = new ArrayList<String>() ;
		order.add("flag") ;
		order.add("ip") ;
		order.add("seq") ;
		return order ;
	}
	
	public List<String> getFieldOrder() {
		Field[] fieldList = this.getClass().getDeclaredFields() ;
		List<String> order = getHeaderFieldOrder() ;
		if(ArrayUtils.isNotEmpty(fieldList)) {
			for(Field f : fieldList) {
				order.add(f.getName()) ;
			}
		}
		return order ;
	}
	
	/**
	 * -------------------------------------------------------------------------------------------------
	 */
	
	public String getFlag() {
		return flag;
	}

	public String getIp() {
		return ip;
	}

	public Long getSeq() {
		return seq;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

}
