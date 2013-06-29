package com.doucome.stockop.biz.core.ins.sungard;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.NativeStruct;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cstring;

/**
 * 金仕达协议登陆
 * @author langben 2013-6-28
 *
 */
@SuppressWarnings("serial")
public class InsReqConnect extends NativeStruct {

	private Cbyte encryptMethod ;
	
	private Cbyte compressMethod ;
	
	@CppByteLen(30)
	private Cstring sAppName ;
	
	@CppByteLen(30)
	private Cstring sAppVersion ;
	
	@CppByteLen(20)
	private Cstring szDLLName ;
	
	@CppByteLen(8)
	private Cstring pDLLID ;
	
	@CppByteLen(22)
	private Cstring szMacAddress ;
	
	@CppByteLen(20)
	private Cstring szIP ;
	
	@CppByteLen(20)
	private Cstring szOPNO ;
	
	@CppByteLen(20)
	private Cstring szOPPass ;
	
	@CppByteLen(256)
	private Cstring pKey ;

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

	public Cstring getsAppName() {
		return sAppName;
	}

	public void setsAppName(Cstring sAppName) {
		this.sAppName = sAppName;
	}

	public Cstring getsAppVersion() {
		return sAppVersion;
	}

	public void setsAppVersion(Cstring sAppVersion) {
		this.sAppVersion = sAppVersion;
	}

	public Cstring getSzDLLName() {
		return szDLLName;
	}

	public void setSzDLLName(Cstring szDLLName) {
		this.szDLLName = szDLLName;
	}

	public Cstring getSzMacAddress() {
		return szMacAddress;
	}

	public void setSzMacAddress(Cstring szMacAddress) {
		this.szMacAddress = szMacAddress;
	}

	public Cstring getSzIP() {
		return szIP;
	}

	public void setSzIP(Cstring szIP) {
		this.szIP = szIP;
	}

	public Cstring getSzOPNO() {
		return szOPNO;
	}

	public void setSzOPNO(Cstring szOPNO) {
		this.szOPNO = szOPNO;
	}

	public Cstring getSzOPPass() {
		return szOPPass;
	}

	public void setSzOPPass(Cstring szOPPass) {
		this.szOPPass = szOPPass;
	}

	public Cstring getpKey() {
		return pKey;
	}

	public void setpKey(Cstring pKey) {
		this.pKey = pKey;
	}

	public Cstring getpDLLID() {
		return pDLLID;
	}

	public void setpDLLID(Cstring pDLLID) {
		this.pDLLID = pDLLID;
	}
	
}
