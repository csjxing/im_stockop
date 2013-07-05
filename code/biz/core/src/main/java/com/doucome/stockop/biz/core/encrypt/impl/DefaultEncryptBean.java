package com.doucome.stockop.biz.core.encrypt.impl;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.doucome.stockop.biz.core.constant.Constant;
import com.doucome.stockop.biz.core.encrypt.EncryptBean;

/**
 * DefaultEncryptBean
 * @author langben 2013-7-4
 *
 */
public class DefaultEncryptBean implements EncryptBean, InitializingBean {

	// 注入属性
	/**
	 * 算法名称，如DES
	 */
	private String Algorithm;
	/** 加密的密钥，通过配置文件进行配置 */
	private String secretKey;
	private String encode = Constant.CHARSET_UTF8;

	// 加密解密器
	private Cipher encodeCipher;
	private Cipher decodeCipher;

	/**
	 * 根据密钥生成加密和解密器,spring中配置初始化方法
	 * 
	 * @param map
	 * @param rawKey
	 * @return
	 */
	private void init() {
		Assert.notNull(secretKey);
		try {
			DESKeySpec dks = new DESKeySpec(secretKey.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance(Algorithm);
			SecretKey deskey = keyFactory.generateSecret(dks);
			encodeCipher = Cipher.getInstance(Algorithm);
			encodeCipher.init(Cipher.ENCRYPT_MODE, deskey);
			decodeCipher = Cipher.getInstance(Algorithm);
			decodeCipher.init(Cipher.DECRYPT_MODE, deskey);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		}
	}

	public String decode(String text) {
		try {
			byte[] clearByte;
			if (text == null) {
				return null;
			}
			byte[] buff = (byte[]) Hex.decodeHex(text.toCharArray());
			clearByte = decodeCipher.doFinal(buff);
			return new String(clearByte, encode);
		} catch (IllegalStateException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}

	}

	public String encode(String text) {
		try {
			if (text == null)
				return null;
			byte[] buff = text.getBytes(Constant.CHARSET_UTF8);
			return new String(Hex.encodeHex(encodeCipher.doFinal(buff)));
		} catch (IllegalStateException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public void setAlgorithm(String algorithm) {
		Algorithm = algorithm;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public static void main(String[] args) {
		DefaultEncryptBean bean = new DefaultEncryptBean();
		bean.setAlgorithm("DES");
		bean.setSecretKey("$IHsd*0sz.");
		bean.init();
		String result = bean.encode("faf@faf.com");
		System.out.println(result);
		System.out.println(bean.decode(result));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}
}
