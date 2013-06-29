package com.doucome.stockop.biz.core.model.cpp;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.AbstractModel;
import com.doucome.stockop.biz.core.utils.FormatTransfer;

/**
 * c++ long
 * @author langben 2013-6-27
 *
 */
@CppByteLen(4)
public class Clong extends AbstractModel implements CType {
	
	public Clong(){
		
	}
	
	public Clong(int value) {
		this.value = value ;
	}

	/**
	 * c++ int 和 long 都是4字节，所以用int表示
	 */
	private int value ;
	
	@Override
	public byte[] getNativeBuff() {
		return FormatTransfer.toLH(value) ;
	}

	@Override
	public void readNativeBuff(byte[] b) {
		value = FormatTransfer.lBytesToInt(b) ;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
