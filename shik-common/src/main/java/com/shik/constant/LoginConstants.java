package com.shik.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2016/11/25
 */
public class LoginConstants {

    public static final String CUSTOMER_LOGIN_TOKEN = "login-token";

    public static final String CUSTOMER_LOGIN_REDIS_KEY = "customer-login:";

    public static final String CUSTOMER_LOGIN_REDIS_FIELD_HEAD = "customer:login:";

    public static final Integer CUSTOMER_LOGIN_OVER_TIME = 7 * 24 * 60 * 60;

    public static final String RETURN_URL = "returnUrl";

    public static final String SMS_KEY = "sms-key";

    public static final String SALT = "Shik";

    /**
     * url_pass.properties
     */
    public static Map<String, String> URL_PASS_MAP = new HashMap<String, String>();

    /**
     * 浏览器特殊请求
     */
    public static Map<String, String> URL_SPECIAL_MAP = new HashMap<String, String>();

    /************************ login error code start**************************************/
    public static final String ERROR_CODE_0001 = "0001";
    public static final String ERROR_CODE_0001_MSG = "用户名或密码错误";
    public static final String ERROR_CODE_0002 = "0002";
    public static final String ERROR_CODE_0002_MSG = "用户名或密码为空";
    public static final String ERROR_CODE_0003 = "0003";
    public static final String ERROR_CODE_0003_MSG = "用户未登录";
    public static final String ERROR_CODE_0004 = "0004";
    public static final String ERROR_CODE_0004_MSG = "调用登录接口失败";
    public static final String ERROR_CODE_0005 = "0005";
    public static final String ERROR_CODE_0005_MSG = "短信验证码为空";
    public static final String ERROR_CODE_0006 = "0006";
    public static final String ERROR_CODE_0006_MSG = "短信验证码不匹配";
    public static final String ERROR_CODE_0007 = "0007";
    public static final String ERROR_CODE_0007_MSG = "用户登录名重复";
    public static final String ERROR_CODE_0008 = "0008";
    public static final String ERROR_CODE_0008_MSG = "调用注册接口失败";
    public static final String ERROR_CODE_0009 = "0009";
    public static final String ERROR_CODE_0009_MSG = "发送短信验证码参数错误";
    public static final String ERROR_CODE_0010 = "0010";
    public static final String ERROR_CODE_0010_MSG = "发送短信验证码失败";
    public static final String ERROR_CODE_0011 = "0011";
    public static final String ERROR_CODE_0011_MSG = "调用修改密码接口失败";
    /************************ login error code end**************************************/

}
