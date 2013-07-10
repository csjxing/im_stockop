package com.doucome.stockop.biz.core.ks;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import com.doucome.stockop.biz.core.ks.constant.KsConstant;
import com.doucome.stockop.biz.core.ks.enums.ErrorEnums;
import com.doucome.stockop.biz.core.ks.exception.KsException;
import com.doucome.stockop.biz.core.ks.response.KsSubDataResponse;

public class SubDataResponseParser <T extends KsSubDataResponse> extends AbstractKsParser<T> {

	private Class<T> clazz;
	
	public SubDataResponseParser(Class<T> clazz ) {
		this.clazz = clazz;
	}
	
	@Override
	public T parse(String rsp) throws KsException {
		String[] splits = StringUtils.split(rsp , KsConstant.PROTOCOL_SPLIT) ;
		if(ArrayUtils.isEmpty(splits) || splits.length < 5) {
			throw new KsException(ErrorEnums.RESPONSE_FORMAT_ERROR , "resp[" + rsp + "] format error !") ;
		}
		String flag = splits[0] ;
		String ip = splits[1] ;
		String seq = splits[2] ;
		if(!StringUtils.equals(KsConstant.RESPONSE_FLAG, flag)) {
			throw new KsException(ErrorEnums.RESPONSE_FORMAT_ERROR , "resp[" + rsp + "] format error !") ;
		}
		
		//处理header
		try {
			T respObject = clazz.newInstance() ;
			respObject.setFlag(flag) ;
			respObject.setIp(ip) ;
			respObject.setSeq(Long.parseLong(seq)) ;
			
			List<String> order = respObject.getFieldOrder() ;
			int headerSize = CollectionUtils.size(respObject.getHeaderFieldOrder()) ;
			for(int i=headerSize ; i<order.size() ; i ++) {
				String fieldName = order.get(i) ;
				Field f = ReflectionUtils.findField(clazz, fieldName) ;
				if(f == null) {
					continue ;
				}
				if(i >= splits.length) {
					break ;
				}
				ReflectionUtils.makeAccessible(f) ;
				_adapter(f,respObject , splits[i]) ;
				
			}
			
			return respObject ;
			
		} catch (InstantiationException e) {
			throw new KsException(ErrorEnums.INTERNAL_ERROR ,e.getMessage() , e) ;
		} catch (IllegalAccessException e) {
			throw new KsException(ErrorEnums.INTERNAL_ERROR ,e.getMessage() , e) ;
		} catch (Exception e) {
			throw new KsException(ErrorEnums.INTERNAL_ERROR ,e.getMessage() , e) ;
		}
		
	}

	public Class<T> getResponseClass() {
		return clazz;
	}
}
