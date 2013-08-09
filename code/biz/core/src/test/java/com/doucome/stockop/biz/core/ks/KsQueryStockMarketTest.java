package com.doucome.stockop.biz.core.ks;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.stockop.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.request.KsQueryStockMarketRequest;
import com.doucome.stockop.biz.core.ks.response.KsQueryStockMarketResponse;

/**
 * 查询可用余额
 * @author langben 2013-7-16
 *
 */
@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class KsQueryStockMarketTest extends AbstractBaseJUnit4Test {

	@Autowired
	private KsClientFactory ksClientFactory ;
	
	@Test
	public void test() {
		
		//建立一个长连接
		KsClient client = ksClientFactory.findClient("1880710027") ;
		if(client == null) {
			//登陆（创建client）
			KsLoginRequest loginRequest = new KsLoginRequest() ;
			loginRequest.setAccount("1880710027") ;
			loginRequest.setPassword("147258") ;
			loginRequest.setSourceExchangeCode("027") ;
			loginRequest.setCommissionWay("WSWT") ;
			client = ksClientFactory.newClient(loginRequest) ;
		} 
	
		
		//查询
		KsQueryStockMarketRequest query = new KsQueryStockMarketRequest() ;
		//queryCommissionRequest.setCommissionPrice(new BigDecimal(34)) ;
		query.setMarketCode("1") ;
		query.setCustomerCode("1880710027") ;
		query.setStockCode("601318") ;
		query.setCommissionWay("WSWT") ;
		query.setSourceExchangeCode("027") ;
		
		KsQueryStockMarketResponse resp = client.execute(query) ;
		System.out.println(resp);
	}
	
	
}
