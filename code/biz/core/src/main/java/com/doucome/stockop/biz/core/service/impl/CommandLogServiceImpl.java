package com.doucome.stockop.biz.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.model.CommandLogDTO;
import com.doucome.stockop.biz.core.model.page.Pagination;
import com.doucome.stockop.biz.core.model.page.QueryResult;
import com.doucome.stockop.biz.core.service.CommandLogService;
import com.doucome.stockop.biz.core.utils.ModelConvertUtils;
import com.doucome.stockop.biz.dal.dao.CommandLogDAO;
import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;
import com.doucome.stockop.biz.dal.model.query.CommandLogQuery;

public class CommandLogServiceImpl implements CommandLogService {

	@Autowired
	private CommandLogDAO commandLogDAO ;
	
	@Override
	public Long createCommandLog(CommandLogDO command) {
		return commandLogDAO.insertCommandLog(command) ;
	}

	@Override
	public QueryResult<CommandLogDTO> getCommandLogsWithPagination(CommandLogQuery query, Pagination pagination) {
		int totalRecords = commandLogDAO.countCommandLogsWithPagination(query) ;
        if (totalRecords <= 0) {
            return new QueryResult<CommandLogDTO>(new ArrayList<CommandLogDTO>(), pagination, totalRecords);
        }
        List<CommandLogDO> itemList = commandLogDAO.queryCommandLogsWithPagination(query, pagination.getStart(), pagination.getSize()) ;
        List<CommandLogDTO> dtoList = ModelConvertUtils.convertCommandLog(itemList) ;
        return new QueryResult<CommandLogDTO>(dtoList, pagination, totalRecords);
	}

}
