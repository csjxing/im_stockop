package com.doucome.stockop.biz.core.encrypt;

/**
 * EncryptBean
 * @author langben 2013-7-4
 *
 */
public interface EncryptBean {

    public String decode(String text);

    public String encode(String text);
}
