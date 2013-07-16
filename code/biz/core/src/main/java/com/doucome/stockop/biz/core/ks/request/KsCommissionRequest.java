package com.doucome.stockop.biz.core.ks.request;

import java.math.BigDecimal;

import com.doucome.stockop.biz.core.ks.constant.SeqGenrator;
import com.doucome.stockop.biz.core.ks.enums.TrasactionTypeEnums;
import com.doucome.stockop.biz.core.ks.response.KsCommissionResponse;
import com.doucome.stockop.biz.core.utils.NetworkUtils;

/**
 * 委托（挂单）
 * @author langben 2013-7-8
 *
 */
public class KsCommissionRequest extends KsRequest<KsCommissionResponse>{

	public KsCommissionRequest() {
		this.function = 3 ;
		this.ip = NetworkUtils.getCachedLocalIP();
		this.seq = SeqGenrator.nextSeq() ;
	}
	
	/**
	 * 市场代码
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String marketCode ;
	
	/**
	 * 保留
	 */
	private String reserved ;
	
	/**
	 * 股东账号
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String stockholder ;
	
	/**
	 * 证券代码
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String stockCode ;
	
	/**
	 * 买卖类型
	 * <ul style="color:red;"><li>必须</li></ul>
	 * @see {@link TrasactionTypeEnums}
	 */
	private String trasacationType ;
	
	/**
	 * 委托数量
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private Integer amount ;
	
	/**
	 * 委托价格
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private BigDecimal price ;
	
	/**
	 * 委托方式
	 * <ul style="color:red;"><li>必须</li></ul>
	 */
	private String commissionWay ;
	
	/**
	 * 银行代码（未启用）
	 */
	private String bankCode ;
	
	/**
	 * 银行账号
	 */
	private String bankAccount ;
	
	/**
	 * 融资融券模式
	 */
	private String marginMode ;
	
	/**
	 * 委托批号，空则后台生成
	 */
	private Integer commissionBatch ;
	
	/**
	 * 委托风险评测
	 * <p>0未评测、1正常、2超风险、3默认评测、4未支持</p>
	 */
	private String commissionRiskEvaluation ;
	
	/**
	 * 委托子业务
	 */
	private String commissionSubsidiary ;
	
	/**
	 * 约定号，委托子业务为z30、z40时必输
	 */
	private String agreement ;
	
	/**
	 * 对方交易单元，委托子业务为z30、z40时必输
	 */
	private String targetTradeUnit ;
	
	@Override
	public Class<KsCommissionResponse> getResponseClass() {
		return KsCommissionResponse.class ;
	}
	
	/**
	 * ------------------------------------------------------------------
	 */

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getStockholder() {
		return stockholder;
	}

	public void setStockholder(String stockholder) {
		this.stockholder = stockholder;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getTrasacationType() {
		return trasacationType;
	}

	public void setTrasacationType(String trasacationType) {
		this.trasacationType = trasacationType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCommissionWay() {
		return commissionWay;
	}

	public void setCommissionWay(String commissionWay) {
		this.commissionWay = commissionWay;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getMarginMode() {
		return marginMode;
	}

	public void setMarginMode(String marginMode) {
		this.marginMode = marginMode;
	}

	public Integer getCommissionBatch() {
		return commissionBatch;
	}

	public void setCommissionBatch(Integer commissionBatch) {
		this.commissionBatch = commissionBatch;
	}

	public String getCommissionRiskEvaluation() {
		return commissionRiskEvaluation;
	}

	public void setCommissionRiskEvaluation(String commissionRiskEvaluation) {
		this.commissionRiskEvaluation = commissionRiskEvaluation;
	}

	public String getCommissionSubsidiary() {
		return commissionSubsidiary;
	}

	public void setCommissionSubsidiary(String commissionSubsidiary) {
		this.commissionSubsidiary = commissionSubsidiary;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getTargetTradeUnit() {
		return targetTradeUnit;
	}

	public void setTargetTradeUnit(String targetTradeUnit) {
		this.targetTradeUnit = targetTradeUnit;
	}

	
}
