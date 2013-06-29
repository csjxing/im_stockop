package com.doucome.stockop.biz.core.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.doucome.stockop.biz.core.model.cpp.CType;
import com.doucome.stockop.biz.core.model.cpp.Cstring;

/**
 * 
 * @author langben 2013-6-28
 *
 */
public class ReflectionExUtils {

	/**
	 * 是否实现了接口
	 * @param clz
	 * @param inter
	 * @return
	 */
	public static boolean isImplInterface(Class<?> clz , Class<?> inter) {
		Class<?>[] inters = clz.getInterfaces() ;
		if(ArrayUtils.isEmpty(inters)) {
			return false ;
		}
		String interName = inter.getName() ;
		for(Class<?> c : inters) {
			if(StringUtils.equals(c.getName(),interName)){
				return true ;
			}
		}
		return false ;
	}
	
}
