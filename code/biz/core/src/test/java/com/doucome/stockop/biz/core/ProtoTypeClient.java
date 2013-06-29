package com.doucome.stockop.biz.core;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.doucome.stockop.biz.core.model.cpp.Cstring;

public class ProtoTypeClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("127.0.0.1", 5050);
		Cstring i = new Cstring("helloworld") ;
		sock.getOutputStream().write(i.getNativeBuff());
		
		
		byte[] buff = new byte[1024] ;
		sock.getInputStream().read(buff);
		Cstring resp = new Cstring() ;
		resp.readNativeBuff(buff) ;
		System.out.println("recv : " + resp);
		sock.close();
	}
}
