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
}
