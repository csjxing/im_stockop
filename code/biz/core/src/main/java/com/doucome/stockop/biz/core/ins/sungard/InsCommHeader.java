package com.doucome.stockop.biz.core.ins.sungard;

import com.doucome.stockop.biz.core.annotation.CPlusType;
import com.doucome.stockop.biz.core.annotation.Type;

/**
 * 金仕达协议指令头
 * @author langben 2013-6-26
 *
 */
public class InsCommHeader {
	
	public InsCommHeader(byte[] head) {
		
	}

	@CPlusType(Type.BYTE)
	private byte cmd ;
	
	@CPlusType(Type.BYTE)
	private byte flag ;
	
	@CPlusType(Type.INT)
	private int error ;
	
	@CPlusType(Type.BYTE)
	private byte resultCode ;
	
	@CPlusType(Type.BYTE)
	private byte encryptMethod ;
	
	@CPlusType(Type.BYTE)
	private byte compressMethod ;
	
	@CPlusType(Type.WORD)
	private int orgLen ;
	
	@CPlusType(Type.WORD)
	private int len ;
	
	@CPlusType(Type.LONG)
	private int userdata ;

	@CPlusType(Type.WORD)
	private int crc ;

	public byte getCmd() {
		return cmd;
	}

	public void setCmd(byte cmd) {
		this.cmd = cmd;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public byte getResultCode() {
		return resultCode;
	}

	public void setResultCode(byte resultCode) {
		this.resultCode = resultCode;
	}

	public byte getEncryptMethod() {
		return encryptMethod;
	}

	public void setEncryptMethod(byte encryptMethod) {
		this.encryptMethod = encryptMethod;
	}

	public byte getCompressMethod() {
		return compressMethod;
	}

	public void setCompressMethod(byte compressMethod) {
		this.compressMethod = compressMethod;
	}

	public int getOrgLen() {
		return orgLen;
	}

	public void setOrgLen(int orgLen) {
		this.orgLen = orgLen;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getUserdata() {
		return userdata;
	}

	public void setUserdata(int userdata) {
		this.userdata = userdata;
	}

	public int getCrc() {
		return crc;
	}

	public void setCrc(int crc) {
		this.crc = crc;
	}
	
	
}
