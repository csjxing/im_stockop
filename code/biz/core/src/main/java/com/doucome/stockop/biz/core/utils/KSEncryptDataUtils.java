package com.doucome.stockop.biz.core.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

/**
 * 加解密工具类
 * @author cc
 * @since 2013-07-01
 */
public class KSEncryptDataUtils {
	
	private static final Log log = LogFactory.getLog(KSEncryptDataUtils.class) ;
	
	private static final char[] ENCRYPT_KEY = {};
	
	private static final KSEncryptDataLib KSENCRYPTDATALIB = KSEncryptDataLib.INSTANCE;
	
	public static String encrypt(String plainText){
		char[] inbuf = plainText.toCharArray();
		int inlen = inbuf.length;
		char[] outbuf = new char[1024]; 
		int outsize = outbuf.length;
		
		if(KSENCRYPTDATALIB.KSEncryptData(inbuf, inlen, outbuf, outsize, ENCRYPT_KEY, (short)0, (short)1)){
			return new String(outbuf);
		}else{
			return "";
		}
		
	}
	
	public static String decrypt(String cipherText){
		char[] inbuf = cipherText.toCharArray();
		int inlen = inbuf.length;
		char[] outbuf = new char[1024]; 
		int outsize = outbuf.length;
		
		if(KSENCRYPTDATALIB.KSEncryptData(inbuf, inlen, outbuf, outsize, ENCRYPT_KEY, (short)1, (short)1)){
			return new String(outbuf);
		}else{
			return "";
		}
	}
	
	interface KSEncryptDataLib extends StdCallLibrary { 
		KSEncryptDataLib INSTANCE = (KSEncryptDataLib)
				Native.loadLibrary("KSEncryptData", KSEncryptDataLib.class);
		
		boolean KSEncryptData(char[] inbuf ,int inlen, char[] outbuf,int outsize ,char[] key, short flag ,short entype); 
	}
	
	public static void main(String[] args) {
		System.out.println(KSEncryptDataUtils.encrypt(""));
	}

}
