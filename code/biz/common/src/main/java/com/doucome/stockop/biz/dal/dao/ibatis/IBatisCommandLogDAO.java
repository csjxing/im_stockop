package com.doucome.stockop.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.stockop.biz.common.utils.NumberUtils;
import com.doucome.stockop.biz.dal.dao.CommandLogDAO;
import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;
import com.doucome.stockop.biz.dal.model.query.CommandLogQuery;

public class IBatisCommandLogDAO extends SqlMapClientDaoSupport implements CommandLogDAO {

	@Override
	public Long insertCommandLog(CommandLogDO command) {
		return (Long)getSqlMapClientTemplate().insert("CommandLog.insertCommandLog" , command) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommandLogDO> queryCommandLogsWithPagination(CommandLogQuery query, int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("CommandLog.queryCommandLogsWithPagination" , map) ;
	}

	@Override
	public int countCommandLogsWithPagination(CommandLogQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("CommandLog.countCommandLogsWithPagination", map)) ;
	}

}
