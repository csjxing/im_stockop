package com.doucome.stockop.biz.core.ks.response;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.dal.model.AbstractModel;

public abstract class KsResponse extends AbstractModel {

	protected String flag = KsConstant.RESPONSE_FLAG ;
	
	/**
	 * 发起源地址
	 */
	protected String ip ;
	
	/**
	 * 请求编号
	 */
	protected Long seq ;
	
	/**
	 * 是否成功
	 */
	protected String success ; 
	
	/**
	 * 错误信息
	 */
	protected String msg ;
	
	/**
	 * 子错误码
	 */
	protected Integer subCode ;		
	
	public boolean isSuccess() {
		return StringUtils.equals(success , "Y") ;
	}
		
	/**
	 * 
	 * @return
	 */
	public List<String> getHeaderFieldOrder() {
		List<String> order = new ArrayList<String>() ;
		order.add("flag") ;
		order.add("ip") ;
		order.add("seq") ;
		order.add("success") ;
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

	public String getMsg() {
		return msg;
	}

	public Integer getSubCode() {
		return subCode;
	}

	public String getSuccess() {
		return success;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setSubCode(Integer subCode) {
		this.subCode = subCode;
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

	public void setSuccess(String success) {
		this.success = success;
	}
	
}
