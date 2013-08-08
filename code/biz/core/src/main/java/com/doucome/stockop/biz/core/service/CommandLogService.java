package com.doucome.stockop.biz.core.service;

import com.doucome.stockop.biz.core.model.CommandLogDTO;
import com.doucome.stockop.biz.core.model.page.Pagination;
import com.doucome.stockop.biz.core.model.page.QueryResult;
import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;
import com.doucome.stockop.biz.dal.model.query.CommandLogQuery;

public interface CommandLogService {

	/**
	 * insert
	 * @param command
	 * @return
	 */
	Long createCommandLog(CommandLogDO command) ;
	
	/**
	 * 
	 * @return
	 */
	QueryResult<CommandLogDTO> getCommandLogsWithPagination(CommandLogQuery query , Pagination pagination) ;
	
}
