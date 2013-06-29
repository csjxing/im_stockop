package com.doucome.stockop.biz.core;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.doucome.stockop.biz.core.ins.sungard.InsCommHeader;
import com.doucome.stockop.biz.core.model.cpp.Cbyte;
import com.doucome.stockop.biz.core.model.cpp.Cint;
import com.doucome.stockop.biz.core.model.cpp.Clong;
import com.doucome.stockop.biz.core.model.cpp.Cword;
import com.doucome.stockop.biz.core.utils.NativeConvertUtils;

public class StockOPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("127.0.0.1", 5050);
		
		InsCommHeader header = new InsCommHeader() ;
		header.setCmd(new Cbyte((byte)2)) ;
		header.setFlag(new Cbyte((byte)22)) ;
		header.setError(new Cint(-1023)) ;
		header.setResultCode(new Cbyte((byte)12)) ;
		header.setEncryptMethod(new Cbyte((byte)8)) ;
		header.setCompressMethod(new Cbyte((byte)4)) ;
		header.setOrgLen(new Cword(1323)) ;
		header.setLen(new Cword(12323)) ;
		header.setCrc(new Cword(2)) ;	
		header.setUserdata(new Clong(-2132323)) ;
		System.out.println("send content:  " + header);
		byte[] natBuff = header.getNativeBuff() ;
		
		sock.getOutputStream().write(natBuff);
		
		printf(natBuff) ;
		System.out.println("");
		byte[] buff = new byte[1024] ;
		sock.getInputStream().read(buff);
		printf(buff) ;
		InsCommHeader headerResp = (InsCommHeader)NativeConvertUtils.nativeBuff2Object(buff, InsCommHeader.class) ;
		System.out.println("recv : " + headerResp);
		sock.close();
	}
	
	private static void printf(byte[] bytes) {
		StringBuilder sb = new StringBuilder() ;
		for(byte b : bytes) {
			sb.append(b).append(",") ;
		}
		System.out.println(sb.toString());
	}
}
