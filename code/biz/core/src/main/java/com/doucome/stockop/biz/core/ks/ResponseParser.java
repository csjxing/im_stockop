package com.doucome.stockop.biz.core.ks;

import com.doucome.stockop.biz.core.ks.exception.KsException;

public class ResponseParser<T> {

	private Class<T> clazz;
	
	public ResponseParser(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T parse(String rsp) throws KsException {
		return null ;
	}

	public Class<T> getResponseClass() {
		return clazz;
	}
}
