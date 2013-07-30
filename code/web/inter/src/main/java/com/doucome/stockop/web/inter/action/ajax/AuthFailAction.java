package com.doucome.stockop.web.inter.action.ajax;

import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

public class AuthFailAction extends InterBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	@Override
	public String execute() throws Exception {
		json.setCode(JsonModel.CODE_AUTH_FAIL) ;
		json.setDetail("stockop.inter.login.fail") ;
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
	
	
}
