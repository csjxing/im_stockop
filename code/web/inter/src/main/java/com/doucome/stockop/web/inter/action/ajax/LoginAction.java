package com.doucome.stockop.web.inter.action.ajax;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.ks.KsClient;
import com.doucome.stockop.biz.core.ks.KsClientFactory;
import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;
import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.request.KsLoginRequest;
import com.doucome.stockop.biz.core.model.StockAccountDTO;
import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

/**
 * 登陆
 * @author langben 2013-7-30
 *
 */
public class LoginAction extends InterBasicAction {

	private String accountId ;
	
	private String password ;
	
	private String exchangeCode ;
	
	private JsonModel<StockAccountDTO> json = new JsonModel<StockAccountDTO>() ;
	
	@Autowired
	private KsClientFactory ksClientFactory ;
	
	@Override
	public String execute() throws Exception {
		
		if(StringUtils.isBlank(accountId) || StringUtils.isBlank(password)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.login.accountOrPassword.required") ;
			return SUCCESS ;
		}
		
		if(StringUtils.isBlank(exchangeCode)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("stockop.login.exchangeCode.required") ;
			return SUCCESS ;
		}
		
		KsClient client = interAuthz.getClient() ;
		
		if(client == null) {
			//登陆（创建client）
			KsLoginRequest loginRequest = new KsLoginRequest() ;
			loginRequest.setAccount(accountId) ;
			loginRequest.setPassword(password) ;
			loginRequest.setSourceExchangeCode(exchangeCode) ;
			loginRequest.setCommissionWay(KsConstant.COMMISSION_WAY) ;
			try {
				
				client = ksClientFactory.newClient(loginRequest) ;
				json.setCode(JsonModel.CODE_SUCCESS) ;
				json.setData(client.getAccount()) ;
			} catch (KsException e) {
				json.setCode(JsonModel.CODE_FAIL) ;
				json.setDetail(e.getMessage()) ;
				json.setErrorCode(e.getError().getCode()) ;
			} catch (Exception e) {
				json.setCode(JsonModel.CODE_FAIL) ;
				json.setDetail(e.getMessage()) ;
				json.setErrorCode(ErrorEnums.INTERNAL_ERROR.getCode()) ;
			}
		} 
		
		return SUCCESS ;
	}

	public JsonModel<StockAccountDTO> getJson() {
		return json;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
