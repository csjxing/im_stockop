package com.doucome.stockop.biz.core.ao;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.ks.executor.FeatureTaskExecutor;
import com.doucome.stockop.biz.core.service.CommandLogService;
import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;

public class CommandLogAO {

	@Autowired
	private CommandLogService commandLogService ;
	
	@Autowired
	private FeatureTaskExecutor featureTaskExecutor ;
	
	public Future<Long> asyncLog(final CommandLogDO commandLog) {
		Future<Long> result = featureTaskExecutor.executeFuture(new Callable<Long>() {

			@Override
			public Long call() throws Exception {
				return commandLogService.createCommandLog(commandLog) ;
			}
		}) ;
		
		return result ;
	}
	
}
