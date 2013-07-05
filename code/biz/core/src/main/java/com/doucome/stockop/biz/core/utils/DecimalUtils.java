package com.doucome.stockop.biz.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.doucome.stockop.biz.core.constant.DecimalConstant;

public class DecimalUtils {
	
	public static boolean equal(BigDecimal d1 , BigDecimal d2) {
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		return d1.compareTo(d2) == 0 ;
	}
	
	/**
	 * >= 0
	 * @param bd
	 * @return
	 */
	public static boolean isGreaterEqualThan0(BigDecimal d){
		d = nullToZero(d) ;
		int i = d.compareTo(DecimalConstant.ZERO) ;
		return i >= 0 ;
	}
	
	/**
	 * > 0
	 * @param bd
	 * @return
	 */
	public static boolean isGreaterThan0(BigDecimal d){
		d = nullToZero(d) ;
		int i = d.compareTo(DecimalConstant.ZERO) ;
		return i > 0 ;
	}
	
	public static String format(BigDecimal d , String format){
		d = nullToZero(d) ;
		DecimalFormat f = new DecimalFormat(format);
        return f.format(d);
	}

	/**
	 * 判断 d1 大于 d2
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean greatThan(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		int i = d1.compareTo(d2) ;
		return i == 1 ;
	}
	
	/**
	 * 判断 d1 小于 d2
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean lessThan(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		int i = d1.compareTo(d2) ;
		return i == -1 ;
	}
	
	/**
	 * 判断 d1 大于等于 d2
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean greatEqualThan(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		int i = d1.compareTo(d2) ;
		return i == -1 ? false : true ;
	}
	
	/**
	 * 判断d1 小于等于 d2
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean lessEqualThan(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		int i = d1.compareTo(d2) ;
		return i == 1 ? false : true ;
	}
	
	/**
	 * multiply
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		return d1.multiply(d2) ;
	}
	
	public static BigDecimal divide(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		return d1.divide(d2) ;
	}
	
	public static BigDecimal substract(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		return d1.subtract(d2) ;
	}

	public static BigDecimal add(BigDecimal d1 , BigDecimal d2){
		d1 = nullToZero(d1) ;
		d2 = nullToZero(d2) ;
		return d1.add(d2) ;
	}
	
	public static BigDecimal abs(BigDecimal d) {
		d = nullToZero(d) ;
		return d.abs() ;
	}
	
	public static BigDecimal nullToZero(BigDecimal d) {
		if(d == null) {
			return new BigDecimal(0) ;
		}
		return d ;
	}
}
