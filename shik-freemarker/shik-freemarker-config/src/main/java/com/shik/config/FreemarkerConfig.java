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

import com.shik.constant.MapConstants;
import com.shik.support.component.SpringContextUtil;
import com.shik.support.reader.PropertiesReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author gengshikun
 * @date 2017/3/27
 */
@Configuration
public class FreemarkerConfig {

    @Bean(name = "freemarkerXml")
    public FreeMarkerConfigurer freemarkerXml() {
        // 模板路径
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/templates/freemarker/");
        configurer.setDefaultEncoding("UTF-8");

        // 自定义标签
        Map<String, Object> map = new HashMap<String, Object>();
        PropertiesReader.cacheFreemarkerProperties();  // 缓存freemarker
        for (Map.Entry<String, String> entry : MapConstants.FREE_MARKER_MAP.entrySet()) {
            map.put(entry.getKey(), SpringContextUtil.getBean(entry.getValue()));
        }
        configurer.setFreemarkerVariables(map);

        // 配置
        Properties settings = new Properties();
        settings.setProperty("template_update_delay", "0");
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }

}
