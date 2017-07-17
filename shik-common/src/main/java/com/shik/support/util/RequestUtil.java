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
package com.shik.support.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2017/7/6
 */
public class RequestUtil {

    /**
     * 处理参数列表为Map<String, Object>
     *
     * @param request
     * @return
     */
    public static Map<String, Object> paramsToMap(HttpServletRequest request) {
        Map<String, Object> param = Maps.newHashMap();

        Enumeration keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (StringUtils.isNotBlank(key)) {
                param.put(key, request.getParameter(key));
            }
        }
        return param;
    }

    /**
     * 处理参数列表为Map<String, String>
     *
     * @param request
     * @return
     */
    public static Map<String, String> params2Map(HttpServletRequest request) {
        Map<String, String> param = Maps.newHashMap();

        Enumeration keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (StringUtils.isNotBlank(key)) {
                param.put(key, request.getParameter(key));
            }
        }
        return param;
    }

}
