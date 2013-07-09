package com.doucome.stockop.biz.core.model;

import java.io.IOException;
import java.net.Socket;

import com.doucome.stockop.biz.common.utils.IPUtils;
import com.sun.jna.Native;

public class TestInsHeader {

	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("10.10.10.14", 9001);
		String userPassReq = "R|10.10.10.137|100|2|027|0||1880370004|147258|kswt|"  ;
		String userReq = "R|10.10.10.137|100|1|027|0||1880710027|WSW2T||" ;
		String login = "R|10.10.10.137|101|61|27|0||1880710027|147258|WSWT|||" ;
		byte[] b = Native.toByteArray(userReq) ;
		sock.getOutputStream().write(b) ;
		byte[] buff = new byte[2048] ;
		sock.getInputStream().read(buff);
		String recv = Native.toString(buff,"gbk") ;
		System.out.println("Recv : " + recv);
		
		sock.close();
		
	}
}
