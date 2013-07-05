//package com.doucome.stockop.biz.core.utils;
//
//import java.lang.reflect.Field;
//
//import org.apache.commons.lang.ArrayUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.util.ReflectionUtils;
//
//import com.doucome.stockop.biz.core.annotation.CppByteLen;
//import com.doucome.stockop.biz.core.model.NativeStruct;
//import com.doucome.stockop.biz.core.model.cpp.CType;
//
///**
// * 本机对象和C++网络对象转换工具
// * @author langben 2013-6-27
// *
// */
//public class NativeConvertUtils {
//	
//	private static final Log log = LogFactory.getLog(NativeConvertUtils.class) ;
//
//	/**
//	 * 从网络字节序的结构体转换成本机对象
//	 * @param b
//	 * @param byteLen
//	 * @param clz
//	 * @return
//	 */
//	public static Object nativeBuff2Object(byte[] natBuff , Class<?> clz) {
//		byte[] buff = new byte[1024] ;//临时缓存
//		try {
//			Object o = clz.newInstance() ;
//			Field[] fields = clz.getDeclaredFields() ;
//			int pos = 0 ;
//			if(ArrayUtils.isNotEmpty(fields)) {
//				for(Field field : fields) {
//					Class<?> c = field.getType() ;
//					boolean isCtype = ReflectionExUtils.isImplInterface(c, CType.class) ;
//					if(!isCtype) {
//						continue ;
//					}
//					
//					int byteLen = getByteLength(field,o) ;
//					ReflectionUtils.makeAccessible(field) ;
//					CType fieldVal = (CType)ReflectionUtils.getField(field, o) ;
//					if(fieldVal == null) {
//						ReflectionUtils.setField(field, o, c.newInstance()) ;
//						fieldVal = (CType)ReflectionUtils.getField(field, o) ;
//					}
//					
//					System.arraycopy(natBuff, pos , buff, 0, byteLen) ;
//					fieldVal.readNativeBuff(buff) ;
//					//reset buff 
//					ByteUtils.setDefault(buff, (byte)0 , byteLen) ;
//					pos += byteLen ;
//				}
//			}
//			return o ;
//		} catch (InstantiationException e) {
//			throw new IllegalStateException(e.getMessage()) ;
//		} catch (IllegalAccessException e) {
//			throw new IllegalStateException(e.getMessage()) ;
//		}
//		
//	}
//	
//	/**
//	 * 本机对象转换成网络字节序的byte数组
//	 * @param natStruct
//	 * @return
//	 */
//	public static byte[] object2NativeBuff(NativeStruct natStruct) {
//		Field[] fields = natStruct.getClass().getDeclaredFields() ;
//		if(ArrayUtils.isNotEmpty(fields)) {
//			int nativeStructLen = getNativeStructLen(natStruct) ;
//			byte[] buff = new byte[nativeStructLen] ;
//			int pos = 0 ;
//			for(Field field : fields) {
//				Class<?> c = field.getType() ;
//				boolean isCtype = ReflectionExUtils.isImplInterface(c, CType.class) ;
//				if(!isCtype) {
//					//是否是NativeStruct结构
//					if(ReflectionExUtils.isSubclassOf(c, NativeStruct.class)){
//						ReflectionUtils.makeAccessible(field) ;
//						NativeStruct struct = (NativeStruct)ReflectionUtils.getField(field, natStruct) ;
//						byte[] natBuff = object2NativeBuff(struct) ;
//						int len = getNativeStructLen(struct) ;
//						System.arraycopy(natBuff, 0, buff, pos, ByteUtils.getLength(natBuff, len) ) ;
//						pos += len ;
//					}
//					continue ;
//				}
//				int len = getByteLength(field, natStruct) ;
//				try {
//					ReflectionUtils.makeAccessible(field) ;
//					CType ctype = (CType)ReflectionUtils.getField(field, natStruct) ;
//					byte[] fieldBuff = toNativeBuff(ctype) ;
//					System.arraycopy(fieldBuff, 0, buff, pos, ByteUtils.getLength(fieldBuff, len) ) ;
//				} catch (Exception e) {
//					log.error(e.getMessage() , e) ;
//				}
//				pos += len ;
//			}
//			return buff ;
//		}
//		return null ;
//	}
//	
//	private static byte[] toNativeBuff(CType ctype){
//		if(ctype == null) {
//			return new byte[0] ;
//		}
//		return ctype.getNativeBuff() ;
//	}
//	
//	public static int getNativeStructLen(NativeStruct natStruct) {
//		int len = 0 ;
//		Field[] fields = natStruct.getClass().getDeclaredFields() ;
//		if(ArrayUtils.isNotEmpty(fields)) {
//			for(Field field : fields) {
//				len += getByteLength(field , natStruct) ;
//			}
//		}
//		
//		return len ;
//	}
//	
//	/**
//	 * 
//	 * @param field
//	 * @param o
//	 * @return
//	 */
//	private static int getByteLength(Field field , Object o) {
//		Class<?> c = field.getType() ;
//		boolean isCtype = ReflectionExUtils.isImplInterface(c, CType.class) ;
//		if(!isCtype) {
//			return 0 ;
//		}
//		CppByteLen cppByteLen = c.getAnnotation(CppByteLen.class) ;
//		if(cppByteLen == null) {
//			throw new IllegalArgumentException("CType must declare Annotation[CppByteLen]") ;
//		}
//		int length = cppByteLen.value() ;
//		if(length < 0) {
//			//从field读取
//			cppByteLen = field.getAnnotation(CppByteLen.class) ;
//			if(cppByteLen == null) {
//				throw new IllegalArgumentException("Class[" + c + "] must declare Annotation[CppByteLen] in field") ;
//			}
//			length = cppByteLen.value() ;
//		}
//		return length ;
//	}
//}
