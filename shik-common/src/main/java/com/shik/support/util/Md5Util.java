package com.shik.support.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;


/**
 * md5工具类,签名和验签,通过org.apache.commons.codec.digest.DigestUtils实现
 *
 * @author DongLuning
 */
public class Md5Util {
    private static final String CHARSET = "UTF-8";

    public final static String MD5(String content) {
        return MD5(content, CHARSET).toUpperCase();
    }

    public final static String MD5(String content, String charset) {
        return DigestUtils.md5DigestAsHex(getContentBytes(content, charset));
    }

    public final static String MD5(String content, String key, String charset) {
        content += key;
        return MD5(content, charset);
    }

    /**
     * 验证签名
     *
     * @param text    需要签名的字符串
     * @param sign    签名结果
     * @param key     密钥
     * @param charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String charset) {
        text = text + key;
        return verify(text, sign, charset);
    }

    /**
     * 验证签名
     *
     * @param text 需要签名的字符串+密钥
     * @param sign 签名结果
     * @return
     */
    public static boolean verify(String text, String sign) {
        return verify(text, sign, CHARSET);
    }

    /**
     * 验证签名
     *
     * @param text    需要签名的字符串+密钥
     * @param sign    签名结果
     * @param charset 编码格式
     * @return
     */
    public static boolean verify(String text, String sign, String charset) {
        String mysign = Md5Util.MD5(text, charset);
        if (mysign.equals(sign)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (StringUtils.isEmpty(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

}
