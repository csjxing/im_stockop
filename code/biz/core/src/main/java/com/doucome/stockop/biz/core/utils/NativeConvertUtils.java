package com.doucome.stockop.biz.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ReflectionUtils;

import com.doucome.stockop.biz.core.annotation.CPlusType;
import com.doucome.stockop.biz.core.model.NativeStruct;

/**
 * 本机对象和C++网络对象转换工具
 * @author langben 2013-6-27
 *
 */
public class NativeConvertUtils {
	
	private static final Log log = LogFactory.getLog(NativeConvertUtils.class) ;

	/**
	 * 从网络字节序的结构体转换成本机对象
	 * @param b
	 * @param byteLen
	 * @param clz
	 * @return
	 */
	public static Object nativeBuff2Object(byte[] natBuff , Class clz) {
		byte[] buff = new byte[1024] ;//临时缓存
		try {
			Object o = clz.newInstance() ;
			Field[] fields = clz.getDeclaredFields() ;
			int pos = 0 ;
			if(ArrayUtils.isNotEmpty(fields)) {
				for(Field field : fields) {
					//查找annotation
					//ByteUtils.setDefault(buff, 0) ;
					CPlusType cplusType = field.getAnnotation(CPlusType.class) ;
					if(cplusType == null) {
						continue ;
					}
					int byteLen = getByteLength(cplusType) ;
					
					System.arraycopy(natBuff, pos , buff, 0, byteLen) ;
					setNativeBuff2FieldVal(field,o,buff,cplusType) ;
					pos += byteLen ;
				}
			}
			return o ;
		} catch (InstantiationException e) {
			throw new IllegalStateException(e.getMessage()) ;
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e.getMessage()) ;
		}
		
	}
	
	/**
	 * 本机对象转换成网络字节序的byte数组
	 * @param natStruct
	 * @return
	 */
	public static byte[] object2NativeBuff(NativeStruct natStruct) {
		Field[] fields = natStruct.getClass().getDeclaredFields() ;
		if(ArrayUtils.isNotEmpty(fields)) {
			int nativeStructLen = getNativeStructLen(natStruct) ;
			byte[] buff = new byte[nativeStructLen] ;
			int pos = 0 ;
			for(Field field : fields) {
				CPlusType cplusType = field.getAnnotation(CPlusType.class) ;
				if(cplusType == null) {
					continue ;
				}
				int fieldLen = getByteLength(cplusType) ;
				try {
					byte[] srcBuff = toNativeBuff(field , natStruct) ;
					int arraylen = srcBuff.length ;
					System.arraycopy(srcBuff, 0, buff, pos, arraylen) ;
				} catch (Exception e) {
					log.error(e.getMessage() , e) ;
				}
				pos += fieldLen ;
			}
			return buff ;
		}
		return null ;
	}
	
	private static void setNativeBuff2FieldVal(Field field, Object o , byte[] buff , CPlusType cplusType) {
		Type type = field.getType() ;
		int byteLen = getByteLength(cplusType) ;
		ReflectionUtils.makeAccessible(field) ;
		if(type == int.class) {
			int val = FormatTransfer.lBytesToInt(buff) ;
			ReflectionUtils.setField(field, o, val) ;
		} else if(type == float.class) {
			float val = FormatTransfer.lBytesToFloat(buff) ;
			ReflectionUtils.setField(field, o, val) ;
		} else if(type == short.class) {
			short val = FormatTransfer.lBytesToShort(buff) ;
			ReflectionUtils.setField(field, o, val) ;
		} else if(type == byte.class) {
			byte val = buff[0] ;
			ReflectionUtils.setField(field, o, val) ;
		} else if(type == String.class) {
			String val = FormatTransfer.lbytesToString(buff) ;
			ReflectionUtils.setField(field, o, val) ;
		} else {
			throw new IllegalStateException("Unknown field type : " + field + " to Object : " + o) ;
		}
	}
	
	private static byte[] toNativeBuff(Field field , NativeStruct natStruct) throws IllegalArgumentException, IllegalAccessException {
		Type type = field.getType() ;
		ReflectionUtils.makeAccessible(field);
		Object o = ReflectionUtils.getField(field, natStruct) ;
		if(type == int.class) {
			int i = (Integer)o ;
			return FormatTransfer.toLH(i) ;
		} else if(type == float.class) {
			float i = (Float)o ;
			return FormatTransfer.toLH(i) ;
		} else if(type == short.class) {
			short i = (Short)o ;
			return FormatTransfer.toLH(i) ;
		} else if(type == byte.class) {
			byte i = (Byte)o ;
			return new byte[]{i} ;
		} else if(type == String.class) {
			String i = (String) o ;
			return FormatTransfer.stringToBytes(i) ;
		}
		throw new IllegalStateException("Unknown field type : " + field + " in class : " + natStruct) ;
	}
	
	private static int getNativeStructLen(NativeStruct natStruct) {
		int len = 0 ;
		Field[] fields = natStruct.getClass().getDeclaredFields() ;
		if(ArrayUtils.isNotEmpty(fields)) {
			for(Field field : fields) {
				//查找annotation
				CPlusType cplusType = field.getAnnotation(CPlusType.class) ;
				if(cplusType != null) {
					int fieldLen = getByteLength(cplusType) ;
					if(fieldLen > 0) {
						len += fieldLen ;
					}
				}
			}
		}
		
		return len ;
	}
	
	private static int getByteLength(CPlusType type) {
		if(type == null) {
			return 0 ;
		}
		int fieldLen = type.value().getByteLen() ;
		if(fieldLen == -1) {
			fieldLen = type.length() ;
		}
		return fieldLen ;
	}
}
