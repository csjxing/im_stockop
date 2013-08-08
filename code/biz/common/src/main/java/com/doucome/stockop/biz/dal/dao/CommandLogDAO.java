package com.doucome.stockop.biz.dal.dao;

import java.util.List;

import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;
import com.doucome.stockop.biz.dal.model.query.CommandLogQuery;

/**
 * 操作历史
 * @author langben 2013-8-8
 *
 */
public interface CommandLogDAO {

	/**
	 * insert
	 * @param command
	 * @return
	 */
	Long insertCommandLog(CommandLogDO command) ;
	
	/**
	 * 
	 * @return
	 */
	List<CommandLogDO> queryCommandLogsWithPagination(CommandLogQuery query , int start , int size) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	int countCommandLogsWithPagination(CommandLogQuery query) ;
	
}
