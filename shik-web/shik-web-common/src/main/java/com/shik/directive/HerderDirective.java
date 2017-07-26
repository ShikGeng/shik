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

import com.shik.dao.model.User;
import com.shik.support.component.LoginSession;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2017/3/27
 */
@Component("herderDirective")
public class HerderDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map params, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        User user = LoginSession.getUser();

        StringBuffer headerHtml = new StringBuffer("");
        if (null != user) {
            headerHtml.append("<div class=\"log\"><img src=\"\"/></div>");
            headerHtml.append("<div class=\"user\">");
            headerHtml.append("<div class=\"common msg\">");
            headerHtml.append("<span>通知</span>");
            headerHtml.append("<i class=\"layui-icon\" style=\"font-size: 12px;\">&#xe625;</i>");
            headerHtml.append("<div class=\"msg-info hide\">");
            headerHtml.append("<a><div class=\"msg-list\">123</div></a>");
            headerHtml.append("<a><div class=\"msg-list gray\">123</div></a>");
            headerHtml.append("<a><div class=\"msg-list msg-more gray\">查看更多</div></a>");
            headerHtml.append("</div>");
            headerHtml.append("</div>");
            headerHtml.append("<div class=\"common info\">");
            headerHtml.append("<span>" + user.getName() + "</span>");
            headerHtml.append("<div class=\"user-operation hide\">");
            headerHtml.append("<a><div class=\"user-list\">个人中心</div></a>");
            headerHtml.append("<a href=\"/auth/logout\"><div class=\"user-list\">退出</div></a>");
            headerHtml.append("</div>");
            headerHtml.append("</div>");
            headerHtml.append("</div>");
        } else {
            headerHtml.append("<div class=\"log\"><img src=\"\"/></div>");
            headerHtml.append("<div class=\"user\">");
            headerHtml.append("<div class=\"common msg\">");
            headerHtml.append("<a href=\"/auth/n/login\">登录</a>");
            headerHtml.append("</div>");
            headerHtml.append("<div class=\"common info\">");
            headerHtml.append("<a href=\"/auth/n/regin\">注册</a>");
            headerHtml.append("</div>");
            headerHtml.append("</div>");
        }
        environment.getOut().write(headerHtml.toString());
    }
}
