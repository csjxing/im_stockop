package com.doucome.stockop.biz.core.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

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
	
	public static boolean isSubclassOf(Class<?> clz , Class<?> superClz) {
		Class<?> superClass = clz.getSuperclass() ;
		if(superClass == null) {
			return false ;
		}
		return StringUtils.equals(superClass.getName(), superClz.getName()) ;
		
	}
	
	public static String[] getFieldsName(Class<?> clz) {
		Field[] fieldList = clz.getFields() ;
		if(ArrayUtils.isEmpty(fieldList)) {
			return new String[0] ;
		}
		String[] fieldNameArr = new String[fieldList.length] ;
		for(int i = 0 ; i<fieldList.length ;i++) {
			fieldNameArr[i] = fieldList[i].getName() ;
		}
		return fieldNameArr ;
	}
}
