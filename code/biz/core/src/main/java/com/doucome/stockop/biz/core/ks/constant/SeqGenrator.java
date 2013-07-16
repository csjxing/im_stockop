package com.doucome.stockop.biz.core.ks.constant;

public class SeqGenrator {

	public static long seq = 1L ;
	
	static {
		seq = System.currentTimeMillis() ;
	}
	
	public static long nextSeq() {
		return ++ seq ;
	}
}
