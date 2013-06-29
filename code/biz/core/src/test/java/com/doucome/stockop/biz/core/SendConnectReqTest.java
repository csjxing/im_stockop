package com.doucome.stockop.biz.core;

import java.io.IOException;
import java.net.Socket;

import com.doucome.stockop.biz.core.ins.sungard.InsReqConnect;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cstring;
import com.doucome.stockop.biz.core.utils.NativeConvertUtils;

public class SendConnectReqTest {

	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("127.0.0.1", 5050);
		
		InsReqConnect reqConnect = new InsReqConnect() ;
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
		
		System.out.println("");
		byte[] buff = new byte[1024] ;
		sock.getInputStream().read(buff);
		
		InsReqConnect connectResp = (InsReqConnect)NativeConvertUtils.nativeBuff2Object(buff, InsReqConnect.class) ;
		System.out.println("recv : " + connectResp);
		sock.close();
	}
}
