package com.doucome.stockop.web.inter.action.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.doucome.stockop.biz.core.ks.KsClient;
import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.core.ks.request.KsQueryStockMarketRequest;
import com.doucome.stockop.biz.core.ks.response.KsQueryStockMarketResponse;
import com.doucome.stockop.biz.core.utils.ArrayStringUtils;
import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

/**
 * 查询行情
 * @author langben 2013-8-9
 *
 */
public class QueryStockMarketsAction extends InterBasicAction {
	
	private JsonModel<Map<String,KsQueryStockMarketResponse>> json = new JsonModel<Map<String,KsQueryStockMarketResponse>>() ;

	/**
	 * 股票代码，多个以‘,’分隔
	 */
	private String stockCodes ;
	
	@Override
	public String execute() throws Exception {
		
		List<String> stockCodeList = ArrayStringUtils.toList(stockCodes) ;
		
		KsClient client = interAuthz.getClient() ;
		
		if(CollectionUtils.isEmpty(stockCodeList)) {
			json.setDetail("stockop.query.stockMarket.stock.required");
			json.setCode(JsonModel.CODE_ILL_ARGS);
			return SUCCESS ;
		}
		
		Map<String,KsQueryStockMarketResponse> map = new HashMap<String,KsQueryStockMarketResponse>() ;
		
		for(String stockCode : stockCodeList) {
			//查询
			KsQueryStockMarketRequest request = new KsQueryStockMarketRequest() ;
			//queryCommissionRequest.setCommissionPrice(new BigDecimal(34)) ;
			request.setMarketCode("1") ;
			request.setCustomerCode(interAuthz.getAccountId()) ;
			request.setStockCode(stockCode) ;
			request.setCommissionWay(KsConstant.COMMISSION_WAY) ;
			request.setSourceExchangeCode(interAuthz.getAccount().getDepositExchangeCode()) ;
			KsQueryStockMarketResponse response = client.execute(request) ;
			map.put(stockCode, response) ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(map) ;
		
		return SUCCESS ;
	}

	public JsonModel<Map<String,KsQueryStockMarketResponse>> getJson() {
		return json;
	}

	public void setStockCodes(String stockCodes) {
		this.stockCodes = stockCodes;
	}
	
}
