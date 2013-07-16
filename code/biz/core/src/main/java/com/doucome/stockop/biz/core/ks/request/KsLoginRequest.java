package com.doucome.stockop.biz.core.ks.request;

import com.doucome.stockop.biz.core.ks.constant.SeqGenrator;
import com.doucome.stockop.biz.core.ks.enums.AccountTypeEnums;
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.utils.NetworkUtils;

/**
 * 登陆req
 * @author langben 2013-7-6
 *
 */
public class KsLoginRequest extends KsRequest<KsLoginResponse> {
	
	public KsLoginRequest(){
		this.function = 61 ;
		this.seq = SeqGenrator.nextSeq() ;
		this.ip = NetworkUtils.getCachedLocalIP();
		this.accountType = AccountTypeEnums.CUSTOMER.getValue();
	}
	
	/**
	 * 账户类型
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String accountType ;
	
	/**
	 * 预留
	 */
	private String reserved ;
	
	/**
	 * 账号
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String account ;
	
	/**
	 * 密码
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String password ;
	
	/**
	 * 委托方式
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String commissionWay ;
	
	/**
	 * 可选，目的营业部代码（通买通卖）
	 */
	private Integer destExchangeCode ;

	/**
	 * 可选，结果集方式
	 * <p>空或0为正常多结果集返回，1为单结果集返回，即主帐号在同一个包返回</p>
	 */
	private Integer resultSet  ;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public Class<KsLoginResponse> getResponseClass() {
		return KsLoginResponse.class ;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

	public Integer getDestExchangeCode() {
		return destExchangeCode;
	}

	public void setDestExchangeCode(Integer destExchangeCode) {
		this.destExchangeCode = destExchangeCode;
	}

	public Integer getResultSet() {
		return resultSet;
	}

	public void setResultSet(Integer resultSet) {
		this.resultSet = resultSet;
	}

	
}
