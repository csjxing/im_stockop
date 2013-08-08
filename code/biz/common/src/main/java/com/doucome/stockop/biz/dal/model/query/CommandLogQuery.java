package com.doucome.stockop.biz.dal.model.query;

import java.util.HashMap;
import java.util.Map;

import com.doucome.stockop.biz.dal.model.AbstractModel;

public class CommandLogQuery extends AbstractModel {

	private String stockCode ;
	
	private String accountId ;
	
	private String operator ;
	
	private String command ;
	
	private String commiBatch ;
	
	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("stockCode", stockCode) ;
		map.put("accountId", accountId) ;
		map.put("operator", operator) ;
		map.put("command", command) ;
		map.put("commiBatch", commiBatch) ;
		return map ;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getCommiBatch() {
		return commiBatch;
	}

	public void setCommiBatch(String commiBatch) {
		this.commiBatch = commiBatch;
	}
	
}
