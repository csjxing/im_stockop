package com.doucome.stockop.biz.core.ks;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.springframework.util.ReflectionUtils;

import com.doucome.stockop.biz.core.ks.exception.KsException;

public abstract class AbstractKsParser <T> {

	abstract T parse(String rsp) throws KsException ;
	
	protected void _adapter(Field f , T adptObject , String value) {
		Class<?> c = f.getType() ;
		Object obj = null ;
		if (String.class.isAssignableFrom(c)) {
			obj = value;
		} else if (Long.class.isAssignableFrom(c)) {
			obj = Long.valueOf(value);
		} else if (Integer.class.isAssignableFrom(c)) {
			obj = Integer.valueOf(value);
		} else if (Boolean.class.isAssignableFrom(c)) {
			obj = Boolean.valueOf(value);
		}  else if(BigDecimal.class.isAssignableFrom(c)){
			obj = new BigDecimal(value) ;
		}
		ReflectionUtils.setField(f, adptObject, obj) ;
	}
}
