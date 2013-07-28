package com.doucome.stockop.web.inter.action.ajax;

import java.math.BigDecimal;

import com.doucome.stockop.biz.core.ks.enums.TrasactionTypeEnums;
import com.doucome.stockop.biz.core.ks.request.KsCommissionRequest;
import com.doucome.stockop.biz.core.ks.response.KsCommissionResponse;
import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

/**
 * 
 * @author wei
 * 
 */
public class CommissionAction extends InterBasicAction {

	private static final long serialVersionUID = 3108678216078082574L;

	private JsonModel<KsCommissionResponse> json = new JsonModel<KsCommissionResponse>();

	private String stockCode;

	private Integer amount;

	private BigDecimal price;

	@Override
	public String execute() throws Exception {

		KsCommissionRequest commissionRequest = new KsCommissionRequest();
		commissionRequest.setMarketCode("1");
		commissionRequest.setStockCode(stockCode);
		commissionRequest.setStockholder("E000041111");
		commissionRequest.setTrasacationType(TrasactionTypeEnums.SECURITIES_BUY
				.getValue());
		commissionRequest.setAmount(amount);
		commissionRequest.setPrice(price);
		commissionRequest.setCommissionWay("WSWT");
		KsCommissionResponse commissionResp = interAuthz.getClient().execute(
				commissionRequest);
		System.out.println(commissionResp);
		if (commissionResp.isSuccess()) {
			json.setData(commissionResp);
			json.setCode(JsonModel.CODE_SUCCESS);
		}else{
			json.setDetail(commissionResp.getMsg());
			json.setCode(JsonModel.CODE_FAIL);
		}
		return SUCCESS;
	}

	public JsonModel<KsCommissionResponse> getJson() {
		return json;
	}

}
