package com.doucome.stockop.biz.core.model;

import com.doucome.stockop.biz.core.ks.response.KsLoginResponse;
import com.doucome.stockop.biz.core.utils.UUIDUtils;

/**
 * 账户
 * @author langben 2013-7-4
 *
 */
public class StockAccountDTO extends AbstractModel {
	
	public StockAccountDTO(KsLoginResponse resp) {
		this.accountId = resp.getAccount() ;
		this.currentCode = resp.getCurrencyCode() ;
		this.actualMarketCode = resp.getActualMarketCode() ;
		this.authToken = UUIDUtils.random20() ;
	}

	/**
	 * 账号
	 */
	private String accountId ;
	
	/**
	 * 货币代码
	 */
	private String currentCode ;
	
	/**
	 * 原输入帐号的实际市场代码
	 */
	private String actualMarketCode ;
	
	/**
	 * 用于验证的token
	 */
	private String authToken ;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCurrentCode() {
		return currentCode;
	}

	public void setCurrentCode(String currentCode) {
		this.currentCode = currentCode;
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
	
}
