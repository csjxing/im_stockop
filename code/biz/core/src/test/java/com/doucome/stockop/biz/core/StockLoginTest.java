package com.doucome.stockop.biz.core;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.doucome.stockop.biz.core.ins.sungard.InsConnectReq;
import com.doucome.stockop.biz.core.ins.sungard.InsConnectResp;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cstring;
import com.doucome.stockop.biz.core.utils.NativeConvertUtils;

public class StockLoginTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("58.246.146.130", 9001);
		
		InsConnectReq reqConnect = new InsConnectReq() ;
		reqConnect.setEncryptMethod(new Cbyte((short)12)) ;
		reqConnect.setCompressMethod(new Cbyte((short)14)) ;
		reqConnect.setsAppName(new Cstring("stock")) ;
		reqConnect.setsAppVersion(new Cstring("1.0.2")) ;
		reqConnect.setSzDLLName(new Cstring("dllName")) ;
		reqConnect.setpDLLID(new Cstring("2343")) ;
		reqConnect.setSzMacAddress(new Cstring("ANDW-DDDD-CCCC")) ;
		reqConnect.setSzIP(new Cstring("127.0.0.1")) ;
		reqConnect.setSzOPNO(new Cstring("9527")) ;
		reqConnect.setSzOPPass(new Cstring("123456")) ;
		reqConnect.setpKey(new Cstring("*****"));
		
		
		System.out.println("send content:  " + reqConnect);
		byte[] natBuff = reqConnect.getNativeBuff() ;
		
		sock.getOutputStream().write(natBuff);
		
		byte[] buff = new byte[2048] ;
		sock.getInputStream().read(buff);
		
		InsConnectResp connectResp = (InsConnectResp)NativeConvertUtils.nativeBuff2Object(buff, InsConnectResp.class) ;
		System.out.println("recv : " + connectResp);
		sock.close();
	}
}
