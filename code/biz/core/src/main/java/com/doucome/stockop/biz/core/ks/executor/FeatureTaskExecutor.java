package com.doucome.stockop.biz.core.ks.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;



/**
 * 执行异步任务处理线程
 * @author langben 2013-5-30
 *
 */
public class FeatureTaskExecutor {
	
	protected ExecutorService executor;
		
	public FeatureTaskExecutor() {
		executor = Executors.newFixedThreadPool(5);
	}
	
	public <T> Future<T> executeFuture(Callable<T> call) {
		FutureTask<T> future = new FutureTask<T>(call);
		this.executor.execute(future);
		return future;
	}
}
