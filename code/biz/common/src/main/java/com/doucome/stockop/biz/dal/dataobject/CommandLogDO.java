package com.doucome.stockop.biz.dal.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import com.doucome.stockop.biz.dal.model.AbstractModel;

/**
 * 
 * @author langben 2013-8-8
 *
 */
public class CommandLogDO extends AbstractModel {

	private Long id ;
	
	/**
	 * 账号
	 */
	private String accountId ;
	
	/**
	 * 操作员
	 */
	private String operator ;
	
	/**
	 * 挂单、撤单 
	 * @see {@link CommandEnums}
	 */
	private String command ;
	
	/**
	 * 挂单批次号
	 */
	private String commiBatch ;
	
	/**
	 * 股票代码
	 */
	private String stockCode ;
	
	/**
	 * 初始挂单价格
	 */
	private BigDecimal price ;
	
	/**
	 * 初始挂单数量
	 */
	private Integer amount ;
	
	private String memo ;
	
	/**
	 * JSON ，智能挂单、撤单拆分结果详情
	 */
	private String logDetail ;
	
	private Date gmtCreate ;
	
	private Date gmtModified ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getLogDetail() {
		return logDetail;
	}

	public void setLogDetail(String logDetail) {
		this.logDetail = logDetail;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getCommiBatch() {
		return commiBatch;
	}

	public void setCommiBatch(String commiBatch) {
		this.commiBatch = commiBatch;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}	
	
}
