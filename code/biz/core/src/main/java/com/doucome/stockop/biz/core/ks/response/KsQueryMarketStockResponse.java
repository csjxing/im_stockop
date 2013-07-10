package com.doucome.stockop.biz.core.ks.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.doucome.stockop.biz.common.utils.NumberUtils;
import com.doucome.stockop.biz.core.ks.SubDataAware;


/**
 * 查询券商可融券余额 (56号包)返回
 * @author langben 2013-7-10
 *
 */
public class KsQueryMarketStockResponse extends KsResponse implements SubDataAware<KsQueryMarketStockResponse.SubData>{

	/**
	 * 记录个数
	 */
	private Integer recordCount ;
	
	/**
	 * 子记录
	 */
	private List<SubData> subDataList = new ArrayList<SubData>() ;

	@Override
	public int getSubDataCount() {
		return NumberUtils.parseInt(recordCount) ;
	}

	@Override
	public List<SubData> getSubData() {
		return subDataList ;
	}
	
	@Override
	public Class<SubData> getSubDataClass() {
		return KsQueryMarketStockResponse.SubData.class ;
	}
		
	/**
	 * 只考虑返回合计值的情况
	 * @author langben 2013-7-10
	 *
	 */
	public static class SubData extends KsSubDataResponse {
		
		/**
		 * 合计余额
		 */
		private Integer totalBalance ;
		
		/**
		 * 合计可用余额
		 */
		private Integer totalAvailableBalance ;
		
		/**
		 * 合计市值
		 */
		private BigDecimal totalMarketValue ;
		
		/**
		 * 浮动盈亏
		 */
		private BigDecimal floatingProfitAndLoss ;

		public Integer getTotalBalance() {
			return totalBalance;
		}

		public void setTotalBalance(Integer totalBalance) {
			this.totalBalance = totalBalance;
		}

		public Integer getTotalAvailableBalance() {
			return totalAvailableBalance;
		}

		public void setTotalAvailableBalance(Integer totalAvailableBalance) {
			this.totalAvailableBalance = totalAvailableBalance;
		}

		public BigDecimal getTotalMarketValue() {
			return totalMarketValue;
		}

		public void setTotalMarketValue(BigDecimal totalMarketValue) {
			this.totalMarketValue = totalMarketValue;
		}

		public BigDecimal getFloatingProfitAndLoss() {
			return floatingProfitAndLoss;
		}

		public void setFloatingProfitAndLoss(BigDecimal floatingProfitAndLoss) {
			this.floatingProfitAndLoss = floatingProfitAndLoss;
		}
	
	}
	
}
