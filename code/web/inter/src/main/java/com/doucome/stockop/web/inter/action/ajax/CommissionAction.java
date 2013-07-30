package com.doucome.stockop.web.inter.action.ajax;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.doucome.stockop.biz.core.ks.constant.KsConstant;
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

	/**
	 * @param stockCode the stockCode to set
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String execute() throws Exception {
		
		if(StringUtils.isBlank(stockCode)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.commission.stockCode.required") ;
			return SUCCESS ;
		}
		
		if(amount == null) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.commission.amount.required") ;
			return SUCCESS ;
		}
		
		if(amount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.commission.amount.error") ;
			return SUCCESS ;
		}
		
		if(price == null) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.commission.price.required") ;
			return SUCCESS ;
		}

		KsCommissionRequest commissionRequest = new KsCommissionRequest();
		commissionRequest.setMarketCode("1");
		commissionRequest.setStockCode(stockCode);
		commissionRequest.setStockholder("E000041111");
		commissionRequest.setTrasacationType(TrasactionTypeEnums.SECURITIES_SELL
				.getValue());
		commissionRequest.setAmount(amount);
		commissionRequest.setPrice(price);
		commissionRequest.setCommissionWay(KsConstant.COMMISSION_WAY);
		KsCommissionResponse commissionResp = interAuthz.getClient().execute(
				commissionRequest);
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

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
