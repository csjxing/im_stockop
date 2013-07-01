package com.doucome.stockop.biz.core.ins.sungard;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.NativeStruct;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cstring;

/**
 * ins response
 * @author langben 2013-6-29
 *
 */
@SuppressWarnings("serial")
public class InsConnectResp extends NativeStruct {

	/**
	 * 
	 */
	Cbyte encryptMethod;	
	
	/**
	 * 
	 */
	Cbyte compressMethod;		    
	
	/**
	 *  
	 */
	Cbyte version;				   
	
	/**
	 * 
	 */
	Cstring cWtfs;					
	
	/**
	 * 
	 */
	@CppByteLen(3)
	Cstring szGYS;			
	
	/**
	 * 
	 */
	@CppByteLen(9)
	Cstring szCompanyName;		 
	
	/**
	 * 
	 */
	@CppByteLen(9)
	Cstring szDate;	
	
	/**
	 * 
	 */
	@CppByteLen(9)
	Cstring szTime;				
	
	/**
	 *  
	 */
	@CppByteLen(32)
	Cstring Key;

	public Cbyte getEncryptMethod() {
		return encryptMethod;
	}

	public void setEncryptMethod(Cbyte encryptMethod) {
		this.encryptMethod = encryptMethod;
	}

	public Cbyte getCompressMethod() {
		return compressMethod;
	}

	public void setCompressMethod(Cbyte compressMethod) {
		this.compressMethod = compressMethod;
	}

	public Cbyte getVersion() {
		return version;
	}

	public void setVersion(Cbyte version) {
		this.version = version;
	}

	public Cstring getcWtfs() {
		return cWtfs;
	}

	public void setcWtfs(Cstring cWtfs) {
		this.cWtfs = cWtfs;
	}

	public Cstring getSzGYS() {
		return szGYS;
	}

	public void setSzGYS(Cstring szGYS) {
		this.szGYS = szGYS;
	}

	public Cstring getSzCompanyName() {
		return szCompanyName;
	}

	public void setSzCompanyName(Cstring szCompanyName) {
		this.szCompanyName = szCompanyName;
	}

	public Cstring getSzDate() {
		return szDate;
	}

	public void setSzDate(Cstring szDate) {
		this.szDate = szDate;
	}

	public Cstring getSzTime() {
		return szTime;
	}

	public void setSzTime(Cstring szTime) {
		this.szTime = szTime;
	}

	public Cstring getKey() {
		return Key;
	}

	public void setKey(Cstring key) {
		Key = key;
	}				     

}
