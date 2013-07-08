package com.doucome.stockop.biz.core.ks;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.ks.request.KsCancellationRequest;
import com.doucome.stockop.biz.core.ks.request.KsCommissionRequest;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.response.KsCancellationResponse;
import com.doucome.stockop.biz.core.ks.response.KsCommissionResponse;

public class KsLoginRequestTest {

	@Autowired
	private KsClientFactory ksClientFactory ;
	
	public void test() {
		
		//建立一个长连接
		KsClient client = ksClientFactory.findClient("1880270158") ;
		if(client == null) {
			//登陆（创建client）
			KsLoginRequest loginRequest = new KsLoginRequest() ;
			loginRequest.setAccount("1880710027") ;
			loginRequest.setPassword("147258") ;
			loginRequest.setSourceExchangeCode(27) ;
			loginRequest.setCommissionWay("WSWT") ;
			client = ksClientFactory.newClient(loginRequest) ;
		} 
			
		//挂单（委托）
		KsCommissionRequest commissionRequest = new KsCommissionRequest() ;
		//组装参数
		//commissionRequest.setXXX
		//...
		//调用
		KsCommissionResponse commissionResp = client.execute(commissionRequest) ;
		
		
		KsCancellationRequest cancelRequest = new KsCancellationRequest() ;
		//组装参数
		//cancelRequest.setXXX
		//...
		//调用
		KsCancellationResponse cancelResponse = client.execute(cancelRequest) ;
		//
	}
}
