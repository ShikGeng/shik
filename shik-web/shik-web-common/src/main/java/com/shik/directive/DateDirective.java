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
package com.shik.directive;

import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2017/3/27
 */
@Component("dateDirective")
public class DateDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map params, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String result = "";
        long date = 0;
        String format = "yyyy-MM-dd HH:mm:ss";
        if (null != params.get("date") && StringUtils.isNotEmpty(params.get("date").toString())) {
            date = Long.valueOf(params.get("date").toString());
            if (null != params.get("format")) {
                format = ((SimpleScalar) params.get("format")).getAsString();
            }
            try {
                SimpleDateFormat df = new SimpleDateFormat(format);
                result = df.format(new Date(date));
            } catch (Exception e) {
            }
        }
        environment.getOut().write(result);
    }
}
