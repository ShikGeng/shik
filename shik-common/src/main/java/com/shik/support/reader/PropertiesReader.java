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
package com.shik.support.reader;

import com.shik.constant.MapConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author gengshikun
 * @date 2017/3/13
 */
public class PropertiesReader {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesReader.class);

    /**
     * 缓存url_pass.properties
     *
     * @throws Exception
     */
    public static void cacheUrlPassProperties() {
        ClassPathResource cp = new ClassPathResource("config/url_pass.properties");
        Properties properties = new Properties();
        try {
            properties.load(cp.getInputStream());
        } catch (IOException e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 【can not load url_pass.properties !】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        MapConstants.URL_PASS_MAP = (Map) properties;
    }

    /**
     * 缓存freemarker.properties
     *
     * @throws Exception
     */
    public static void cacheFreemarkerProperties() {
        ClassPathResource cp = new ClassPathResource("config/freemarker.properties");
        Properties properties = new Properties();
        try {
            properties.load(cp.getInputStream());
        } catch (IOException e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 【can not load url_pass.properties !】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        MapConstants.FREE_MARKER_MAP = (Map) properties;
    }

    /**
     * 缓存jsoup.properties
     *
     * @throws Exception
     */
    public static void cacheJsoupProperties() {
        ClassPathResource cp = new ClassPathResource("config/jsoup.properties");
        Properties properties = new Properties();
        try {
            properties.load(cp.getInputStream());
        } catch (IOException e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 【can not load jsoup.properties !】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        MapConstants.JSOUP_MAP = (Map) properties;
    }

    /**
     * 缓存book.properties
     *
     * @throws Exception
     */
    public static void cacheBookProperties() {
        ClassPathResource cp = new ClassPathResource("config/book.properties");
        Properties properties = new Properties();
        try {
            properties.load(cp.getInputStream());
        } catch (IOException e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 【can not load book.properties !】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        MapConstants.BOOK_MAP = (Map) properties;
    }

    /**
     * 缓存alipay.properties
     *
     * @throws Exception
     */
    public static void cacheAlipayProperties() {
        ClassPathResource cp = new ClassPathResource("config/alipay.properties");
        Properties properties = new Properties();
        try {
            properties.load(cp.getInputStream());
        } catch (IOException e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 【can not load alipay.properties !】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        MapConstants.ALIPAY_MAP = (Map) properties;
    }
}
