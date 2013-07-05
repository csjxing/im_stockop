package com.doucome.stockop.web.inter.authz;

import com.doucome.stockop.biz.core.model.StockAccountDTO;

/**
 * 
 * @author langben 2013-5-21
 * 
 */
public interface InterSessionOperator {
 
	 boolean load(StockAccountDTO account) ;
	 
	 boolean unload() ; 
}
