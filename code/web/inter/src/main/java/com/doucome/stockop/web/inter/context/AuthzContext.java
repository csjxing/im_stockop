package com.doucome.stockop.web.inter.context;

import java.util.HashMap;
import java.util.Map;

public class AuthzContext {

	private Map<AuthzContextModelEnums, Object> modelMap = new HashMap<AuthzContextModelEnums, Object>();

	private boolean touch;

	private boolean authentication;

	private AccountAuthzContext account = new AccountAuthzContext();

	public Object getModel(AuthzContextModelEnums key) {
		return modelMap.get(key);
	}

	public void setModel(AuthzContextModelEnums key, Object value) {
		modelMap.put(key, value);
	}

	public void clearModels() {
		modelMap.clear();
	}

	public boolean isAuthentication() {
		return authentication;
	}

	public void setAuthentication(boolean authentication, boolean touch) {
		this.authentication = authentication;
		if (touch) {
			this.touch = touch;
		}
	}

	public boolean isTouch() {
		return touch;
	}

	public void setTouch(boolean touch) {
		this.touch = touch;
	}

	public String getAccountId() {
		return account.getAccountId() ;
	}

	public void setAccountId(String accountId) {
		account.setAccountId(accountId) ;
	}

	public String getAuthToken() {
		return account.getAuthToken();
	}

	public void setAuthToken(String authToken) {
		account.setAuthToken(authToken);
	}

	private static class AccountAuthzContext {

		private String accountId;

		private String authToken;

		public String getAccountId() {
			return accountId;
		}

		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}

		public String getAuthToken() {
			return authToken;
		}

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}

		
	}

}
