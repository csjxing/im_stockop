package com.doucome.stockop.biz.core.ks.response;

public class KsLoginResponse extends KsResponse {

	/**
	 * 姓名
	 */
	private String name ;
	
	/**
	 * 原输入帐号的实际市场代码
	 */
	private String actualMarketCode ;
	
	/**
	 * 完整账号
	 */
	private String account ;
	
	/**
	 * 货币代码
	 */
	private String currencyCode ;
	
	/**
	 * 客户号
	 */
	private String customerCode ;
	
	/**
	 * 市场个数
	 */
	private Integer marketCount ;
	
	/**
	 * 营业部名称
	 */
	private String exchangeName ;
	
	/**
	 * 系统工作时间
	 */
	private String sysDate ;
	
	/**
	 * 系统工作状态
	 */
	private String sysStatus ;
	
	/**
	 * 系统工作状态名称
	 */
	private String sysStatusName ;
	
	/**
	 * 开户营业部代码
	 */
	private String depositExchangeCode ;
	
	/**
	 * 柜台版本号，0或空：V6柜台，1：新柜台，2：大集中，3：新利，4：恒生，5：金证，6：顶点
	 */
	private String deskVersion ;
	
	/**
	 * 各主帐号代码信息（参看说明）
	 * <p>2、	若单结果集，输入参数11为1，各市场的主帐号通过参数16来输出，具体格式如下：各主帐号通过分号分开，帐号间的信息通过逗号分开
	 * 	【如：1,沪A股,A123456789,1,人民币;2,深A股,1234567890,1,人民币;3,沪B股,C123456789,2,美圆;4,深B股,0987654321,3,港币】</p>
	 */
	private String mainAccountDesc ;
	
	/**
	 * 大集中备份历史日期（大集中）
	 */
	private String historyBackupDate ;
	
	/**
	 * 客户报警信息
	 */
	private String customerAlert ;
	
	/**
	 * 客户报警代码
	 */
	private String customerAlertCode ;
	
	/**
	 * 客户融资融券权限
	 */
	private String marginPermissions ;
	
	/**
	 * 上次登入信息
	 */
	private String lastLoginDate ;
	
	/**
	 * 周边登录校验信息
	 */
	private String surroundLoginInfo ;
	
	/**
	 * 开放式基金全线，W-允许开放式基金
	 */
	private String openEndedFundPermissions ;
	
	/**
	 * 客户权限
	 */
	private String customerPermissions ;
	
	/**
	 * 报价回购权限
	 */
	private String priceRepurchasePermissions ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActualMarketCode() {
		return actualMarketCode;
	}

	public void setActualMarketCode(String actualMarketCode) {
		this.actualMarketCode = actualMarketCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Integer getMarketCount() {
		return marketCount;
	}

	public void setMarketCount(Integer marketCount) {
		this.marketCount = marketCount;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getSysDate() {
		return sysDate;
	}

	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}

	public String getSysStatus() {
		return sysStatus;
	}

	public void setSysStatus(String sysStatus) {
		this.sysStatus = sysStatus;
	}

	public String getSysStatusName() {
		return sysStatusName;
	}

	public void setSysStatusName(String sysStatusName) {
		this.sysStatusName = sysStatusName;
	}

	public String getDepositExchangeCode() {
		return depositExchangeCode;
	}

	public void setDepositExchangeCode(String depositExchangeCode) {
		this.depositExchangeCode = depositExchangeCode;
	}

	public String getDeskVersion() {
		return deskVersion;
	}

	public void setDeskVersion(String deskVersion) {
		this.deskVersion = deskVersion;
	}

	public String getMainAccountDesc() {
		return mainAccountDesc;
	}

	public void setMainAccountDesc(String mainAccountDesc) {
		this.mainAccountDesc = mainAccountDesc;
	}

	public String getHistoryBackupDate() {
		return historyBackupDate;
	}

	public void setHistoryBackupDate(String historyBackupDate) {
		this.historyBackupDate = historyBackupDate;
	}

	public String getCustomerAlert() {
		return customerAlert;
	}

	public void setCustomerAlert(String customerAlert) {
		this.customerAlert = customerAlert;
	}

	public String getCustomerAlertCode() {
		return customerAlertCode;
	}

	public void setCustomerAlertCode(String customerAlertCode) {
		this.customerAlertCode = customerAlertCode;
	}

	public String getMarginPermissions() {
		return marginPermissions;
	}

	public void setMarginPermissions(String marginPermissions) {
		this.marginPermissions = marginPermissions;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getSurroundLoginInfo() {
		return surroundLoginInfo;
	}

	public void setSurroundLoginInfo(String surroundLoginInfo) {
		this.surroundLoginInfo = surroundLoginInfo;
	}

	public String getOpenEndedFundPermissions() {
		return openEndedFundPermissions;
	}

	public void setOpenEndedFundPermissions(String openEndedFundPermissions) {
		this.openEndedFundPermissions = openEndedFundPermissions;
	}

	public String getCustomerPermissions() {
		return customerPermissions;
	}

	public void setCustomerPermissions(String customerPermissions) {
		this.customerPermissions = customerPermissions;
	}

	public String getPriceRepurchasePermissions() {
		return priceRepurchasePermissions;
	}

	public void setPriceRepurchasePermissions(String priceRepurchasePermissions) {
		this.priceRepurchasePermissions = priceRepurchasePermissions;
	}
	
}
