package com.doucome.stockop.biz.core.ks.response;

/**
 * 委托resp
 * @author langben 2013-7-8
 *
 */
public class KsCommissionResponse extends KsResponse {

	/**
	 * 委托序号
	 */
	private Integer commissionSeq ;
	
	/**
	 * 委托批号
	 */
	private Integer commissionBatch ;
	
	/**
	 * 成功数量
	 */
	private Integer successCount ;

	public Integer getCommissionSeq() {
		return commissionSeq;
	}

	public void setCommissionSeq(Integer commissionSeq) {
		this.commissionSeq = commissionSeq;
	}

	public Integer getCommissionBatch() {
		return commissionBatch;
	}

	public void setCommissionBatch(Integer commissionBatch) {
		this.commissionBatch = commissionBatch;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}
	
}
