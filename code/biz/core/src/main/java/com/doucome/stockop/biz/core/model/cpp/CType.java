package com.doucome.stockop.biz.core.model.cpp;

public interface CType {
	 
	/**
	 * 4字节对齐
	 */
	public static int pragma_pack = 4 ;

	/**
	 * 转为低字节在前，高字节在后的byte数组
	 * @return
	 */
	byte[] getNativeBuff() ;
	
	/**
	 * 从外部buff解析
	 * @param b
	 * @return
	 */
	void readNativeBuff(byte[] b) ;
}
