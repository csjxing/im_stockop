package com.doucome.stockop.biz.core;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.doucome.stockop.biz.core.model.Employee1;
import com.doucome.stockop.biz.core.utils.NativeConvertUtils;

public class StockOPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("127.0.0.1", 5050);
		System.out.println("send content:  name=kingfish  "+"value="+(1));
		Employee1 e = new Employee1() ;
		e.setName("Jack Âí") ;
		e.setId(1023) ;
		e.setSalary(12.34f) ;
		sock.getOutputStream().write(e.getNativeBuff());
		System.out.println();
		
		byte[] buff = new byte[1024] ;
		sock.getInputStream().read(buff);
		Employee1 EmpResp = (Employee1)NativeConvertUtils.nativeBuff2Object(buff, Employee1.class) ;
		System.out.println("recv : " + EmpResp);
		sock.close();
	}
}
