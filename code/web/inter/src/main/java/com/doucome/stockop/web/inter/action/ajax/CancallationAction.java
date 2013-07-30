package com.doucome.stockop.web.inter.action.ajax;

import com.doucome.stockop.biz.common.utils.IDUtils;
import com.doucome.stockop.biz.core.ks.request.KsBatchCancellationRequest;
import com.doucome.stockop.biz.core.ks.response.KsBatchCancellationResponse;
import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

/**
 * 
 * @author wei
 * 
 */
public class CancallationAction extends InterBasicAction {

	private static final long serialVersionUID = 3108678216078082574L;

	private JsonModel<KsBatchCancellationResponse> json = new JsonModel<KsBatchCancellationResponse>();

	private Integer batchNumber;
	/**
	 * @param batchNumber the batchNumber to set
	 */
	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}

	@Override
	public String execute() throws Exception {

		if(IDUtils.isNotCorrect(batchNumber)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.cancallation.batchNumber.required") ;
			return SUCCESS ;
		}
		
		KsBatchCancellationRequest cancelRequest = new KsBatchCancellationRequest() ;
		cancelRequest.setMarketCode("1") ;
		cancelRequest.setCustomerCode(interAuthz.getAccount().getCustomerCode()) ;
		cancelRequest.setCommissionBatch(batchNumber) ;
		cancelRequest.setCommissionWay("WSWT") ;
		cancelRequest.setSourceExchangeCode(interAuthz.getAccount().getDepositExchangeCode()) ;
		KsBatchCancellationResponse cancelResponse = interAuthz.getClient().execute(cancelRequest) ;
		System.out.println(cancelResponse);
	if (cancelResponse.isSuccess()) {
			json.setData(cancelResponse);
			json.setCode(JsonModel.CODE_SUCCESS);
		}else{
			json.setDetail(cancelResponse.getMsg());
			json.setCode(JsonModel.CODE_FAIL);
		}
		return SUCCESS;
	}

	public JsonModel<KsBatchCancellationResponse> getJson() {
		return json;
	}

}
