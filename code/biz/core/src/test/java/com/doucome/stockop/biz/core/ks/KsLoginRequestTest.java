package com.doucome.stockop.biz.core.ks;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.stockop.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.stockop.biz.common.utils.IPUtils;
import com.doucome.stockop.biz.core.ks.request.KsCancellationRequest;
import com.doucome.stockop.biz.core.ks.request.KsCommissionRequest;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class KsLoginRequestTest extends AbstractBaseJUnit4Test {

	@Autowired
	private KsClientFactory ksClientFactory ;
	
	@Test
	public void test() {
		
		//建立一个长连接
		KsClient client = ksClientFactory.findClient("1880270158") ;
		if(client == null) {
			//登陆（创建client）
			KsLoginRequest loginRequest = new KsLoginRequest() ;
			loginRequest.setAccount("1880710027") ;
			loginRequest.setPassword("147258") ;
			loginRequest.setSourceExchangeCode("027") ;
			loginRequest.setCommissionWay("WSWT") ;
			client = ksClientFactory.newClient(loginRequest) ;
		} 
			
		//挂单（委托）
		KsCommissionRequest commissionRequest = new KsCommissionRequest() ;
		//组装参数
		//commissionRequest.setXXX
		//...
		//调用
		//KsCommissionResponse commissionResp = client.execute(commissionRequest) ;
		
		//撤单
		KsCancellationRequest cancelRequest = new KsCancellationRequest() ;
		//组装参数
		//cancelRequest.setXXX
		//...
		//调用
		//KsCancellationResponse cancelResponse = client.execute(cancelRequest) ;
		//
	}
	
	public static void main(String[] args) {
		Long ip = IPUtils.toAddrLong("114.103.152.67") ;
		System.out.println(ip);
	}
}
