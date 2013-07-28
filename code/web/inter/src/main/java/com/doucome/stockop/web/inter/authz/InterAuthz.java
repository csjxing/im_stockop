package com.doucome.stockop.web.inter.authz;

import com.doucome.stockop.biz.core.ks.KsClient;

/**
 * 
 * @author langben 2013-5-21
 *
 */
public interface InterAuthz {
  
    public boolean isLogin(); 

    public String getAccountId() ;
    
    public KsClient getClient() ;
}
