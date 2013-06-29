package com.doucome.stockop.biz.core.model.cpp;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.AbstractModel;
import com.doucome.stockop.biz.core.utils.FormatTransfer;

/**
 * c++ int ¿‡–Õ
 * @author langben 2013-6-27
 *
 */
@SuppressWarnings("serial")
@CppByteLen(4)
public class Cint extends AbstractModel implements CType {

	public Cint() {
		
	}
	
	public Cint(int value) {
		this.value = value ;
	}
	
	private int value ;
	
	@Override
	public byte[] getNativeBuff() {
		byte[] b = FormatTransfer.toLH(value) ;
		return b ;
	}

	@Override
	public void readNativeBuff(byte[] b) {
		value = FormatTransfer.lBytesToInt(b) ;
	}
	
	public int getValue() {
		return value ;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
