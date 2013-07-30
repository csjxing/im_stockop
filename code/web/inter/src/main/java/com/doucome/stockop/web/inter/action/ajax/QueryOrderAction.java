package com.doucome.stockop.web.inter.action.ajax;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.doucome.stockop.biz.core.ks.request.KsQueryCommissionsRequest;
import com.doucome.stockop.biz.core.ks.response.KsQueryCommissionsResponse;
import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

/**
 * 
 * @author wei
 * 
 */
public class QueryOrderAction extends InterBasicAction {

	private static final long serialVersionUID = 3108678216078082574L;

	private JsonModel<KsQueryCommissionsResponse> json = new JsonModel<KsQueryCommissionsResponse>();

	private String stockCode;

	/**
	 * @param stockCode the stockCode to set
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Override
	public String execute() throws Exception {

		KsQueryCommissionsRequest queryCommissionRequest = new KsQueryCommissionsRequest();
		// queryCommissionRequest.setCommissionPrice(new BigDecimal(34)) ;
		queryCommissionRequest.setMarketCode("1");
		queryCommissionRequest.setCustomerCode(interAuthz.getAccount()
				.getCustomerCode());
		queryCommissionRequest.setStockCode(stockCode);
		queryCommissionRequest.setCommissionWay("WSWT");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		queryCommissionRequest.setStartDate(date);

		KsQueryCommissionsResponse queryCommissionResponse = interAuthz
				.getClient().execute(queryCommissionRequest);
		if (queryCommissionResponse.isSuccess()) {
			json.setData(queryCommissionResponse);
			json.setCode(JsonModel.CODE_SUCCESS);
		} else {
			json.setDetail(queryCommissionResponse.getMsg());
			json.setCode(JsonModel.CODE_FAIL);
		}
		return SUCCESS;
	}

	public JsonModel<KsQueryCommissionsResponse> getJson() {
		return json;
	}

}
