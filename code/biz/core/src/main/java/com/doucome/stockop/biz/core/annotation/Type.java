package com.doucome.stockop.biz.core.annotation;

/**
 * C++ »ù´¡ÀàÐÍ
 * @author langben 2013-6-26
 *
 */
public enum Type {
	BYTE(1),
	CHAR(2),
	WORD(2),
	DWORD(4) ,
	INT(4),
	LONG(4),
	FLOAT(4),
	STRING(-1);
	
	private Type(int byteLen) {
		this.byteLen = byteLen ;
	}
	
	private int byteLen ;

	public int getByteLen() {
		return byteLen;
	}
	
}
