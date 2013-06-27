package com.doucome.stockop.biz.core.model;

import com.doucome.stockop.biz.core.utils.NativeConvertUtils;

/**
 * �����ֽ���C++�ṹ����֧࣬�ֽ�����field���ͣ�
 * <ul>
 *  <li>byte</li>	
 *  <li>int</li>
 *  <li>float</li>
 *  <li>long</li>
 *  <li>String</li>
 * 	
 * </ul>
 * @author langben 2013-6-27
 *
 */
@SuppressWarnings("serial")
public abstract class NativeStruct extends AbstractModel {

	/**
	 * ת���ɽṹ�������
	 * @return
	 */
	public byte[] getNativeBuff() {
		return NativeConvertUtils.object2NativeBuff(this) ;
	}
}
