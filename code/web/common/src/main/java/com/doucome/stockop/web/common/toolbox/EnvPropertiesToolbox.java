package com.doucome.stockop.web.common.toolbox;



import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.constant.EnvConstant;
import com.doucome.stockop.biz.core.constant.URIConstant;
import com.doucome.stockop.biz.core.service.impl.DefaultUriService;
import com.doucome.stockop.biz.core.utils.EnvPropertiesUtil;


/**
 * EnvPropertiesToolbox velocity toolbox
 * @author langben 2011-12-23
 *
 */
public class EnvPropertiesToolbox {
	
	/**
	 * getProperty
	 * @param key
	 * @return
	 */
	public String getProperty(String key){
		return EnvPropertiesUtil.getProperty(key) ;
	}
	
	public String getProp(String key){
		return getProperty(key) ;
	}
	
	public boolean isProduction(){
		String production = EnvPropertiesUtil.getProperty(EnvConstant.STOCKOP_PRODUCTION) ;
		if(StringUtils.equals(production, "true")){
			return true ;
		}
		return false ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.SERVER) ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStaticroot(){
		return DefaultUriService.getFactoryURI(URIConstant.STATIC_SERVER) ;
	}
	
	public String getBopsRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.BOPS_SERVER) ;
	}
	
}
