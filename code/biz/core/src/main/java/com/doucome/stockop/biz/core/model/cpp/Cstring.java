package com.doucome.stockop.biz.core.model.cpp;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.AbstractModel;
import com.doucome.stockop.biz.core.utils.FormatTransfer;

/**
 * C++ char[] 封装，用于表示字符串
 * @author langben 2013-6-28
 *
 */
@SuppressWarnings("serial")
@CppByteLen(-1)
public class Cstring extends AbstractModel implements CType {

	private String value ;
		
	public Cstring(){
		
	}
	
	public Cstring(String value){
		this.value = value ;
	}
	
	@Override
	public byte[] getNativeBuff() {
		if(value == null) {
			return new byte[0] ;
		}
		return FormatTransfer.stringToBytes(value) ;
	}

	@Override
	public void readNativeBuff(byte[] b) {
		value = FormatTransfer.lbytesToString(b) ;
	}
	
	public String getValue(){
		return value ;
	}
}
