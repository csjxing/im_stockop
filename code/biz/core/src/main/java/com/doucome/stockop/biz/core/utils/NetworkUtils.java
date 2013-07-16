package com.doucome.stockop.biz.core.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtils {
	
	public static String cachedIp ;
	
	static {
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();//获得本机IP
			cachedIp = ip ;
		} catch (UnknownHostException e) {
			throw new IllegalStateException(e.getMessage() , e) ;
		}
	}

	public static String getCachedLocalIP(){
		return cachedIp ;
	}
}
