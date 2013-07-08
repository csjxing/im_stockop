package com.doucome.stockop.biz.core.ks.exception;

import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;

public class KsException extends RuntimeException {

	private ErrorEnums error ;
	
	public KsException(ErrorEnums error) {
		this.error = error ;
	}
	
	public KsException(ErrorEnums error , String message) {
		super(message) ;
		this.error = error ;
	}
	
	public KsException(ErrorEnums error , String message , Throwable e) {
		super(message , e) ;
		this.error = error ;
	}

	public ErrorEnums getError() {
		return error;
	}
	
}
