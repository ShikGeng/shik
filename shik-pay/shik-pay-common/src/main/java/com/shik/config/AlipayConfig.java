/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
package com.shik.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author gengshikun
 * @date 2017/7/6
 */
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {

    @Bean(name = "alipayClient")
    public AlipayClient alipayClient(){
        AlipayClient alipayClient = new DefaultAlipayClient(url, app_id, app_private_key, format, charset, alipay_public_key, sign_type);
        return alipayClient;
    }

    private String url;

    private String app_id;

    private String app_private_key;

    private String format;

    private String charset;

    private String app_public_key;

    private String alipay_public_key;

    private String sign_type;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public void setApp_private_key(String app_private_key) {
        this.app_private_key = app_private_key;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setApp_public_key(String app_public_key) {
        this.app_public_key = app_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }
}
