package com.doucome.stockop.biz.core.model;

import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.utils.MD5Utils;
import com.doucome.stockop.biz.core.utils.UUIDUtils;
import com.doucome.stockop.biz.dal.model.AbstractModel;

/**
 * 账户
 * @author langben 2013-7-4
 *
 */
public class StockAccountDTO extends AbstractModel {
	
	public StockAccountDTO(KsLoginRequest req ,KsLoginResponse resp) {
		this.accountId = resp.getAccount() ;
		this.currenyCode = resp.getCurrencyCode() ;
		this.actualMarketCode = resp.getActualMarketCode() ;
		this.authToken = UUIDUtils.random20() ;
		this.customerCode = resp.getCustomerCode() ;
		this.md5Password = MD5Utils.md5(req.getPassword()) ;
	}

	/**
	 * 账号
	 */
	private String accountId ;
	
	/**
	 * 货币代码
	 */
	private String currenyCode ;
	
	/**
	 * 原输入帐号的实际市场代码
	 */
	private String actualMarketCode ;
	
	/**
	 * 用于验证的token
	 */
	private String authToken ;
	
	/**
	 * 客户号
	 */
	private String customerCode ;
	
	/**
	 * 开户营业部代码
	 */
	private String depositExchangeCode ;
	
	/**
	 * MD5 password
	 */
	private String md5Password ;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	

	public String getCurrenyCode() {
		return currenyCode;
	}

	public void setCurrenyCode(String currenyCode) {
		this.currenyCode = currenyCode;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getDepositExchangeCode() {
		return depositExchangeCode;
	}

	public void setDepositExchangeCode(String depositExchangeCode) {
		this.depositExchangeCode = depositExchangeCode;
	}

	public String getActualMarketCode() {
		return actualMarketCode;
	}

	public void setActualMarketCode(String actualMarketCode) {
		this.actualMarketCode = actualMarketCode;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getMd5Password() {
		return md5Password;
	}

	public void setMd5Password(String md5Password) {
		this.md5Password = md5Password;
	}
	
}
