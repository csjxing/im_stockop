package com.doucome.stockop.biz.core.model;

import com.doucome.stockop.biz.core.utils.NativeConvertUtils;

/**
 * 网络字节序C++结构体基类，支持解析的field类型：
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
	 * 转换成结构体的数组
	 * @return
	 */
	public byte[] getNativeBuff() {
		return NativeConvertUtils.object2NativeBuff(this) ;
	}
}
