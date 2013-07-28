package com.doucome.stockop.web.inter.authz.impl;

import com.doucome.stockop.biz.core.ks.KsClient;
import com.doucome.stockop.web.inter.authz.InterAuthz;
import com.doucome.stockop.web.inter.context.AuthzContext;
import com.doucome.stockop.web.inter.context.AuthzContextHolder;

public class DefaultAuthzImpl implements InterAuthz {

	@Override
	public boolean isLogin() {
		return AuthzContextHolder.getContext().isAuthentication();
	}

	@Override
	public String getAccountId() {
		AuthzContext authzContext = AuthzContextHolder.getContext();
		String authToken = authzContext.getAuthToken();
		String accountId = authzContext.getAccountId() ;

		return null;
	}

	@Override
	public KsClient getClient() {
		// TODO Auto-generated method stub
		return null;
	}

}
