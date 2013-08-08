package com.doucome.stockop.biz.core.model.page;

import java.util.List;

import com.doucome.stockop.biz.dal.model.AbstractModel;

/**
 * 查询结果
 * 
 * @author langben 2012-1-12
 * 
 */
public class QueryResult<T> extends AbstractModel {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private QueryResult() {
	}

	/**
	 * 总记录数
	 */
	private long totalRecords;

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public QueryResult(List<T> items, Pagination pagination, long totalRecords) {
		super();
		this.items = items;
		this.pagination = pagination;
		this.totalRecords = totalRecords ;
		pagination.setTotalPages(Pagination.calcTotalPages(pagination,totalRecords));
	}
	
	public QueryResult(List<T> items, boolean hasNext) {
		super();
		this.items = items;
		this.hasNext = hasNext;
	}
	
	/**
	 * 查询结果
	 */
	private List<T> items;

	private Pagination pagination;
	/**
	 * 与totalRecord相对的另一种分页方式
	 */
	private boolean hasNext;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}
