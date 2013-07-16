package com.doucome.stockop.biz.core.ks.response;

public class KsBatchCancellationResponse extends KsResponse {

	/**
	 * 撤单笔数
	 */
	private Integer cancellationCount ;
	
	/**
	 * 撤单数量
	 */
	private Integer cancellationAmount ;

	public Integer getCancellationCount() {
		return cancellationCount;
	}

	public void setCancellationCount(Integer cancellationCount) {
		this.cancellationCount = cancellationCount;
	}

	public Integer getCancellationAmount() {
		return cancellationAmount;
	}

	public void setCancellationAmount(Integer cancellationAmount) {
		this.cancellationAmount = cancellationAmount;
	}
	
}
