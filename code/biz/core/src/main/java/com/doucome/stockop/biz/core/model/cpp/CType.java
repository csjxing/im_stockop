package com.doucome.stockop.biz.core.model.cpp;

public interface CType {
	
	/**
	 * 4�ֽڶ���
	 */
	public static int pragma_pack = 4 ;

	/**
	 * תΪ���ֽ���ǰ�����ֽ��ں��byte����
	 * @return
	 */
	byte[] getNativeBuff() ;
	
	/**
	 * ���ⲿbuff����
	 * @param b
	 * @return
	 */
	void readNativeBuff(byte[] b) ;
}
