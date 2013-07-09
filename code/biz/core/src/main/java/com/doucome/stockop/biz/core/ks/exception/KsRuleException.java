package com.doucome.stockop.biz.core.ks.exception;


public class KsRuleException extends RuntimeException {
	
	public KsRuleException(String message) {
		super(message) ;
	}
	
	public KsRuleException(String message , Throwable e) {
		super(message , e) ;
	}

}
