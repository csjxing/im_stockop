package com.doucome.stockop.biz.core.utils;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

/**
 * 加解密工具类
 * @author cc
 * @since 2013-07-01
 */
public class KSEncryptDataUtils {
	
	static{
		System.setProperty("jna.library.path",System.getProperties().getProperty("java.class.path"));
	}
	
	private static final short ENFLAG = 0;
			
	private static final short UNFLAG = 1;
	
	private static final short ENCRYPT_TYPE_DES = 1;
	
	private static final String ENCRYPT_KEY = "cc";
	
	private static final KSEncryptDataLib KSENCRYPTDATALIB = KSEncryptDataLib.INSTANCE;
	
	public static String encrypt(String plainText){
		byte[] inbuf = FormatTransfer.stringToBytes(plainText);
		int inlen = inbuf.length;
		byte[] outbuf = new byte[1024]; 
		int outsize = outbuf.length;
		
		if(KSENCRYPTDATALIB.KSEncryptData(inbuf, inlen, outbuf, outsize, FormatTransfer.stringToBytes(ENCRYPT_KEY), ENFLAG, ENCRYPT_TYPE_DES)){
			return FormatTransfer.bytesToString(outbuf);
		}else{
			return "";
		}
		
	}
	
	public static String decrypt(String cipherText){
		byte[] inbuf = FormatTransfer.stringToBytes(cipherText);
		int inlen = inbuf.length;
		byte[] outbuf = new byte[1024]; 
		int outsize = outbuf.length;
		
		if(KSENCRYPTDATALIB.KSEncryptData(inbuf, inlen, outbuf, outsize, FormatTransfer.stringToBytes(ENCRYPT_KEY), UNFLAG, ENCRYPT_TYPE_DES)){
			return FormatTransfer.bytesToString(outbuf);
		}else{
			return "";
		}
	}
	
	interface KSEncryptDataLib extends StdCallLibrary { 
		
		KSEncryptDataLib INSTANCE = (KSEncryptDataLib)
				Native.loadLibrary("KSEncryptData", KSEncryptDataLib.class);
		
		boolean KSEncryptData(byte[] inbuf ,int inlen, byte[] outbuf,int outsize ,byte[] encryptKey, short flag ,short entype); 
	}
	
	public static void main(String[] args) {
		System.out.println(KSEncryptDataUtils.encrypt("e12fef"));
	}

}
