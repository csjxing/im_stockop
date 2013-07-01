package com.doucome.stockop.biz.core.utils;

public class ByteUtils {

	public static void setDefault(byte[] byteArray , byte val) {
		if(byteArray == null) {
			return ;
		}
		for(int i = 0 ; i < byteArray.length ; i ++) {
			byteArray[i] = val ;
		}
	}
	
	public static void setDefault(byte[] byteArray , byte val , int len) {
		if(byteArray == null) {
			return ;
		}
		if(len < 0 || len > byteArray.length) {
			len = byteArray.length ;
		}
		for(int i = 0 ; i < len ; i ++) {
			byteArray[i] = val ;
		}
	}
	
	public static int getLength(byte[] bytes){
		return getLength(bytes, Integer.MAX_VALUE) ;
	}
	
	public static int getLength(byte[] bytes , int maxLength) {
		if(bytes == null) {
			return 0 ;
		}
		int length = bytes.length ;
		if(maxLength < length) {
			length = maxLength ;
		}
		return length ;
	}
}
