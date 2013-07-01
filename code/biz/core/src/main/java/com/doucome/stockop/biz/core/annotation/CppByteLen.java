package com.doucome.stockop.biz.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * C++ BYTES LEN
 * @author langben 2013-6-28
 *
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CppByteLen {
	
	int value() default -1 ;

}
