package com.doucome.stockop.biz.core.ins.sungard;

import com.doucome.stockop.biz.core.model.NativeStruct;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cint;
import com.doucome.stockop.biz.core.model.cpp.Clong;
import com.doucome.stockop.biz.core.model.cpp.Cword;

/**
 * 金仕达协议指令头
 * @author langben 2013-6-26
 *
 */
@SuppressWarnings("serial")
public class InsCommHeader extends NativeStruct {

	private Cbyte cmd ;
	
	private Cbyte flag ;
	
	private Cint error ;
	
	private Cbyte resultCode ;
	
	private Cbyte encryptMethod ;
	
	private Cbyte compressMethod ;
	
	private Cword orgLen ;
	
	private Cword len ;
	
	private Clong userdata ;

	private Cword crc ;

	public Cbyte getCmd() {
		return cmd;
	}

	public void setCmd(Cbyte cmd) {
		this.cmd = cmd;
	}

	public Cbyte getFlag() {
		return flag;
	}

	public void setFlag(Cbyte flag) {
		this.flag = flag;
	}

	public Cint getError() {
		return error;
	}

	public void setError(Cint error) {
		this.error = error;
	}

	public Cbyte getResultCode() {
		return resultCode;
	}

	public void setResultCode(Cbyte resultCode) {
		this.resultCode = resultCode;
	}

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

	public Cword getOrgLen() {
		return orgLen;
	}

	public void setOrgLen(Cword orgLen) {
		this.orgLen = orgLen;
	}

	public Cword getLen() {
		return len;
	}

	public void setLen(Cword len) {
		this.len = len;
	}

	public Clong getUserdata() {
		return userdata;
	}

	public void setUserdata(Clong userdata) {
		this.userdata = userdata;
	}

	public Cword getCrc() {
		return crc;
	}

	public void setCrc(Cword crc) {
		this.crc = crc;
	}

}
