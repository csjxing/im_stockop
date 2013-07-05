package com.doucome.stockop.biz.core.utils;

import com.sun.jna.Structure;


public class StructureUtils {

	public static <T> Object nativeBuff2Object(byte[] buff , Class<? extends Structure> clz) {
		try {
			Structure o = clz.newInstance() ;
			
			int len = buff.length ;
			if(len > o.size()) {
				len = o.size() ;
			}
			
			o.getPointer().write(0, buff, 0, len) ;
			o.read() ;
			return o ;
			
		} catch (InstantiationException e) {
			throw new IllegalStateException(e.getMessage()) ;
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e.getMessage()) ;
		}
			
	}
	
	public static byte[] object2NativeBuff(Structure o) {
		if(o == null) {
			return new byte[0] ;
		}
		int len = o.size() ;
		byte[] buff = new byte[len] ;
		o.write() ;
		o.getPointer().read(0, buff, 0, len) ;
		return buff ;
	} 
	
}
