package com.doucome.stockop.biz.core.model.cpp;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.AbstractModel;
import com.doucome.stockop.biz.core.utils.FormatTransfer;

/**
 * C++ WORD
 * @author langben 2013-6-27
 *
 */
@SuppressWarnings("serial")
@CppByteLen(2)
public class Cword extends AbstractModel implements CType {

	public Cword(){
		
	}
	
	public Cword(int value) {
		this.value = value ;
		_checkValue() ;
	}
	
	private int value ;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		_checkValue();
	}

	@Override
	public byte[] getNativeBuff() {
		return FormatTransfer.toLH(value) ;
	}

	@Override
	public void readNativeBuff(byte[] b) {
		//word两位，int是四位
		byte[] bb = FormatTransfer.bytesReverseOrder(b,4) ;
		value = FormatTransfer.hBytesToInt(bb) ;
		_checkValue();
	}
	
	private void _checkValue() {
		if(value < 0 || value > 65535) {
			throw new IllegalStateException("Cword[" + value + "] is not in [0 - 65535]") ;
		}
	}

}
