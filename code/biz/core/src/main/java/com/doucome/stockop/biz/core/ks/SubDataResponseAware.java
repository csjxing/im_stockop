package com.doucome.stockop.biz.core.ks;

import java.util.List;

import com.doucome.stockop.biz.core.ks.response.KsSubDataResponse;

/**
 * 表示有子数据包
 * @author langben 2013-7-10
 *
 * @param <T>
 */
public interface SubDataResponseAware<T extends KsSubDataResponse> {

	/**
	 * 子数据包数
	 * @return
	 */
	int getSubDataCount() ;
	
	/**
	 * 获取子数据
	 * @return
	 */
	List<T> getSubData() ;
	
	/**
	 * 子数据Class
	 * @return
	 */
	Class<T> getSubDataClass() ;

}
