package com.doucome.stockop.web.inter.action.ajax;

import com.doucome.stockop.web.common.model.JsonModel;
import com.doucome.stockop.web.inter.InterBasicAction;

public class TestAction extends InterBasicAction {

	private JsonModel<String> json = new JsonModel<String>() ;
	
	private String name ;
	
	private Integer age ;
	
	@Override
	public String execute() throws Exception {
		
		json.setData("name is " + name + " and age is " + age) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public JsonModel<String> getJson() {
		return json;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
