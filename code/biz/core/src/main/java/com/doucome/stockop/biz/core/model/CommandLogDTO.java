package com.doucome.stockop.biz.core.model;

import java.math.BigDecimal;
import java.util.Date;

import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;
import com.doucome.stockop.biz.dal.model.AbstractModel;

public class CommandLogDTO extends AbstractModel {

	private CommandLogDO commandLog ;
	
	public CommandLogDTO(CommandLogDO commandLog) {
		if(commandLog == null) {
			commandLog = new CommandLogDO() ;
		}
		this.commandLog = commandLog ;
	}
	
	public Long getId() {
		return commandLog.getId();
	}

	public String getAccountId() {
		return commandLog.getAccountId();
	}

	public String getOperator() {
		return commandLog.getOperator();
	}

	public String getCommand() {
		return commandLog.getCommand();
	}

	public BigDecimal getPrice() {
		return commandLog.getPrice();
	}

	public Integer getAmount() {
		return commandLog.getAmount();
	}

	public String getMemo() {
		return commandLog.getMemo();
	}

	public String getLogDetail() {
		return commandLog.getLogDetail();
	}

	public Date getGmtCreate() {
		return commandLog.getGmtCreate();
	}

	public Date getGmtModified() {
		return commandLog.getGmtModified();
	}

	public String getCommiBatch() {
		return commandLog.getCommiBatch();
	}

	public String getStockCode() {
		return commandLog.getStockCode();
	}
}
