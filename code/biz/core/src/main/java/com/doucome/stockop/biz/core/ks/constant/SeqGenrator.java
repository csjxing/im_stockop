package com.doucome.stockop.biz.core.ks.constant;

public class SeqGenrator {

	public static int seq = 1 ;
	
	public static int nextSeq() {
		return ++ seq ;
	}
}
