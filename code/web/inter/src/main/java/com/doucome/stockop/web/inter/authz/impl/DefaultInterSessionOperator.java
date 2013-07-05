package com.doucome.stockop.web.inter.authz.impl;

import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.model.StockAccountDTO;
import com.doucome.stockop.web.inter.authz.InterSessionOperator;
import com.doucome.stockop.web.inter.context.AuthzContext;
import com.doucome.stockop.web.inter.context.AuthzContextHolder;
import com.doucome.stockop.web.inter.context.AuthzContextModelEnums;


public class DefaultInterSessionOperator implements InterSessionOperator {
 
     
    @Override 
	public boolean load(StockAccountDTO account) {
        if (account == null || StringUtils.isEmpty(account.getAccountId())) {
            return false;
        }
        AuthzContext authzContext = AuthzContextHolder.getContext();
        authzContext.clearModels();
        authzContext.setAccountId(account.getAccountId()) ;
        authzContext.setModel(AuthzContextModelEnums.ACCOUNT_KEY, account);
        authzContext.setAuthentication(true, true);
        return true;
	}

 
    @Override
    public boolean unload() {
        AuthzContext authzContext = AuthzContextHolder.getContext();
        authzContext.setAuthentication(false, true);
        return true;
    }

	

}
