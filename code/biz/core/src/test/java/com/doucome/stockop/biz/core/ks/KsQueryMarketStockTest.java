package com.doucome.stockop.biz.core.ks;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.stockop.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.stockop.biz.core.ks.enums.MarketCodeEnums;
import com.doucome.stockop.biz.core.ks.enums.TrasactionTypeEnums;
import com.doucome.stockop.biz.core.ks.request.KsBatchCancellationRequest;
import com.doucome.stockop.biz.core.ks.request.KsCommissionRequest;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.ks.request.KsQueryCommissionsRequest;
import com.doucome.stockop.biz.core.ks.request.KsQueryMarketStockRequest;
import com.doucome.stockop.biz.core.ks.response.KsBatchCancellationResponse;
import com.doucome.stockop.biz.core.ks.response.KsCommissionResponse;
import com.doucome.stockop.biz.core.ks.response.KsQueryCommissionsResponse;
import com.doucome.stockop.biz.core.ks.response.KsQueryMarketStockResponse;

/**
 * 查询可用余额
 * @author langben 2013-7-16
 *
 */
@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class KsQueryMarketStockTest extends AbstractBaseJUnit4Test {

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
		
//		KsQueryMarketStockRequest query = new KsQueryMarketStockRequest() ;
//		query.setMarketCode(MarketCodeEnums.SH_A.getValue()) ;//上海A股
//		query.setSourceExchangeCode("027") ;
//		query.setCustomerCode("1880710027") ;
//		query.setQueryMarketCode(MarketCodeEnums.SH_A.getValue()) ;
//		//query.setQueryStockCode("000001") ;
//		KsQueryMarketStockResponse resp = client.execute(query) ;
//		System.out.println(resp);
//		System.out.println("");
		
		
		//挂单（委托）
//		KsCommissionRequest commissionRequest = new KsCommissionRequest() ;
//		commissionRequest.setMarketCode("1") ;
//		commissionRequest.setStockCode("601318") ;
//		commissionRequest.setStockholder("E000041111") ;
//		commissionRequest.setTrasacationType(TrasactionTypeEnums.SECURITIES_SELL.getValue()) ;
//		commissionRequest.setAmount(100) ;
//		commissionRequest.setPrice(new BigDecimal("40")) ;
//		commissionRequest.setCommissionWay("WSWT") ;
//		//调用
//		KsCommissionResponse commissionResp = client.execute(commissionRequest) ;
//		System.out.println(commissionResp);
//		
//		Integer commissionBatch = commissionResp.getCommissionBatch() ;
//		
		
		//撤单
		KsBatchCancellationRequest cancelRequest = new KsBatchCancellationRequest() ;
		cancelRequest.setMarketCode("1") ;
		cancelRequest.setCustomerCode("1880710027") ;
		cancelRequest.setCommissionBatch(5216) ;
		cancelRequest.setCommissionWay("WSWT") ;
		cancelRequest.setSourceExchangeCode("027") ;
		//调用
		KsBatchCancellationResponse cancelResponse = client.execute(cancelRequest) ;
		System.out.println(cancelResponse);
		
		//查询挂单
		KsQueryCommissionsRequest queryCommissionRequest = new KsQueryCommissionsRequest() ;
		//queryCommissionRequest.setCommissionPrice(new BigDecimal(34)) ;
		queryCommissionRequest.setMarketCode("1") ;
		queryCommissionRequest.setCustomerCode("1880710027") ;
		queryCommissionRequest.setStockCode("601318") ;
		queryCommissionRequest.setCommissionWay("WSWT") ;
		queryCommissionRequest.setStartDate("20130730") ;
		queryCommissionRequest.setSellOrBuy(TrasactionTypeEnums.SECURITIES_SELL.getValue()) ;
		
		
		KsQueryCommissionsResponse queryCommissionResponse = client.execute(queryCommissionRequest) ;
		System.out.println(queryCommissionResponse);
	}
	
	
}
