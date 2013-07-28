package com.doucome.stockop.web.inter.action.ajax;

import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

public class TestAction extends InterBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	@Override
	public String execute() throws Exception {
		
		json.setData(Boolean.TRUE) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
	
}
