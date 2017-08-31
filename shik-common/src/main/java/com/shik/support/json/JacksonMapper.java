package com.shik.support.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * jackson 创建ObjectMapper对象
 * <pre>
 * 创建为饿汉式单例模式 ，Jackson用于转换的核心类ObjectMapper无需每次都new一个object，
 * 官网上的一句话：can reuse, share globally(可以重复使用，全局共享)
 * </pre>
 *
 * @author <a href="mailto:Q12_35@163.com">zhaosy</a><br/>
 * @date 2012-7-25 下午11:36:33
 */
public class JacksonMapper {
    /**
     * 创建 ObjectMapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 默认空的构造方法
     */
    private JacksonMapper() {
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static ObjectMapper getInstance() {
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性   
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        //跳过为空的属性
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper;
    }


}
