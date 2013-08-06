package com.doucome.stockop.web.inter.action.ajax;

import com.doucome.stockop.biz.core.ks.request.KsQueryMarketStockRequest;
import com.doucome.stockop.biz.core.ks.response.KsQueryMarketStockResponse;
import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

/**
 * 
 * @author wei
 * 
 */
public class QueryMarketAction extends InterBasicAction {

	private static final long serialVersionUID = 3108678216078082574L;

	private JsonModel<KsQueryMarketStockResponse> json = new JsonModel<KsQueryMarketStockResponse>();

	private String stockCode;

	/**
	 * @param stockCode the stockCode to set
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Override
	public String execute() throws Exception {

		KsQueryMarketStockRequest queryMarketStockRequest = new KsQueryMarketStockRequest();
		queryMarketStockRequest.setMarketCode("1");
		queryMarketStockRequest.setCustomerCode(interAuthz.getAccount()
				.getCustomerCode());
		queryMarketStockRequest.setOperate("1");
		queryMarketStockRequest.setQueryStockCode(stockCode);
		queryMarketStockRequest.setCommissionWay("WSWT");

		KsQueryMarketStockResponse queryMarketStockResponse = interAuthz
				.getClient().execute(queryMarketStockRequest);
		if (queryMarketStockResponse.isSuccess()) {
			json.setData(queryMarketStockResponse);
			json.setCode(JsonModel.CODE_SUCCESS);
		} else {
			json.setDetail(queryMarketStockResponse.getMsg());
			json.setCode(JsonModel.CODE_FAIL);
		}
		return SUCCESS;
	}

	public JsonModel<KsQueryMarketStockResponse> getJson() {
		return json;
	}

}
