package com.doucome.stockop.biz.core.model.cpp;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.AbstractModel;
import com.doucome.stockop.biz.core.utils.FormatTransfer;

/**
 * c++ BYTE (unsigned char)
 * <p>C++ 的byte是非基本类型，与java的byte有区别。定义为unsigned char . 取值0~255</p>
 * @author langben 2013-6-27
 *
 */
@SuppressWarnings("serial")
@CppByteLen(1)
public class Cbyte extends AbstractModel implements CType {

	public Cbyte() {
		
	}
	
	public Cbyte(short value) {
		this.value = value ;
		_checkValue() ;
	}
	
	private short value ;
	
	@Override
	public byte[] getNativeBuff() {
		return FormatTransfer.toLH(value);
	}

	@Override
	public void readNativeBuff(byte[] b) {
		value = b[0]  ;
		if(value < 0 && value >= -128) {
			value = (short)(256 + value) ; 
		}
		_checkValue() ;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
		_checkValue() ;
	}

	private void _checkValue() {
		if(value < 0 || value > 255) {
			throw new IllegalStateException("Cbyte[" + value + "] is not in [0 - 255]") ;
		}
	}
}
