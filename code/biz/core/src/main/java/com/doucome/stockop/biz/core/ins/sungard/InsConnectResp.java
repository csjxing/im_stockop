package com.doucome.stockop.biz.core.ins.sungard;

import com.doucome.stockop.biz.core.annotation.CppByteLen;
import com.doucome.stockop.biz.core.model.NativeStruct;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cstring;

/**
 * 登陆响应
 * @author langben 2013-6-29
 *
 */
@SuppressWarnings("serial")
public class InsConnectResp extends NativeStruct {

	/**
	 * 加密方式
	 */
	Cbyte encryptMethod;	
	
	/**
	 * 压缩算法
	 */
	Cbyte compressMethod;		    
	
	/**
	 *  柜台的版本号，5－－V5柜台、6－－V6柜台
	 */
	Cbyte version;				   
	
	/**
	 * 适用的委托方式代码
	 */
	Cstring cWtfs;					
	
	/**
	 * 供应商代码
	 */
	@CppByteLen(3)
	Cstring szGYS;			
	
	/**
	 * 适用的经纪公司代码
	 */
	@CppByteLen(9)
	Cstring szCompanyName;		 
	
	/**
	 * 服务器的日期
	 */
	@CppByteLen(9)
	Cstring szDate;	
	
	/**
	 * 服务器的时间
	 */
	@CppByteLen(9)
	Cstring szTime;				
	
	/**
	 *  服务器下一次使用的key
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
