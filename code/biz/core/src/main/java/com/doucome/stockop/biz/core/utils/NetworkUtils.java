package com.doucome.stockop.biz.core.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtils {

	public static String getLocalIP(){
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			String ip=addr.getHostAddress();//获得本机IP
			return ip ;
		} catch (UnknownHostException e) {
			throw new IllegalStateException(e.getMessage() , e) ;
		}
		
	}
}
