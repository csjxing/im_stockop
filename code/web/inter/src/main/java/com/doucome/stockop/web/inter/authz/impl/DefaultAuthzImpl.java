package com.doucome.stockop.web.inter.authz.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.ks.KsClient;
import com.doucome.stockop.biz.core.ks.KsClientFactory;
import com.doucome.stockop.biz.core.model.StockAccountDTO;
import com.doucome.stockop.web.inter.authz.InterAuthz;
import com.doucome.stockop.web.inter.context.AuthzContext;
import com.doucome.stockop.web.inter.context.AuthzContextHolder;
import com.doucome.stockop.web.inter.context.AuthzContextModelEnums;

public class DefaultAuthzImpl implements InterAuthz {

	@Autowired
	private KsClientFactory ksClientFactory ;
	
	@Override
	public boolean isLogin() {
		
		AuthzContext authzContext = AuthzContextHolder.getContext();
		String authToken = authzContext.getAuthToken();
		String accountId = authzContext.getAccountId() ;
		if(StringUtils.isBlank(accountId)){
			return false ;
		}
		StockAccountDTO acc = (StockAccountDTO)authzContext.getModel(AuthzContextModelEnums.ACCOUNT_KEY) ;
		
		if(acc == null) {
			KsClient client = ksClientFactory.findClient(accountId) ;
			if(client != null && client.isLogin()) {
				StockAccountDTO inAccount = client.getAccount() ;
				if(inAccount != null && StringUtils.equals(inAccount.getAuthToken(),authToken)){
					authzContext.setModel(AuthzContextModelEnums.ACCOUNT_KEY, client.getAccount());
					authzContext.setAuthentication(true, true);
				}
			} 
		} 		
		
		return AuthzContextHolder.getContext().isAuthentication();
	}

	@Override
	public String getAccountId() {
		
		if(!isLogin()) {
			return null ;
		}
				
		AuthzContext authzContext = AuthzContextHolder.getContext();
		return authzContext.getAccountId() ;
	}

	@Override
	public KsClient getClient() {
		String accId = getAccountId() ;
		if(StringUtils.isBlank(accId)) {
			return null ;
		}
		return ksClientFactory.findClient(accId) ;
	}

	@Override
	public StockAccountDTO getAccount() {
		if(!isLogin()) {
			return null ;
		}
				
		AuthzContext authzContext = AuthzContextHolder.getContext();
		return (StockAccountDTO)authzContext.getModel(AuthzContextModelEnums.ACCOUNT_KEY) ;
	}

}
