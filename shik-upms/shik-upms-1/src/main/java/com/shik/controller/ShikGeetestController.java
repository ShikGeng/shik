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
package com.shik.controller;

import com.google.common.collect.Maps;
import com.shik.support.component.GeetestLib;
import com.shik.support.json.Jacksons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2017/8/31
 */
@Controller
@RequestMapping(value = "geetest")
public class ShikGeetestController {

    private static final Logger logger = LoggerFactory.getLogger(ShikGeetestController.class);

    @Value("${shik.geetest_id}")
    private String geetest_id;

    @Value("${shik.geetest_key}")
    private String geetest_key;

    /**
     * 注册极验
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    @ResponseBody
    public String gtRegister(HttpServletRequest request) {
        GeetestLib gtSdk = new GeetestLib(this.geetest_id, this.geetest_key, Boolean.TRUE);
        String resStr = "{}";
        //自定义userid
        String userid = "gtRegister";
        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(userid);
        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("zkgengkun_id", userid);
        resStr = gtSdk.getResponseStr();
        return resStr;
    }

    /**
     * 验证极验
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "verify", method = RequestMethod.POST)
    @ResponseBody
    public String gtVerify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        GeetestLib gtSdk = new GeetestLib(this.geetest_id, this.geetest_key, Boolean.TRUE);

        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);

        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

        //从session中获取userid
        String userid = (String) request.getSession().getAttribute("zkgengkun_id");

        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证
            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, userid);
            logger.info("gt-server正常，向gt-server进行二次验证");
        } else {
            // gt-server非正常情况下，进行failback模式验证
            logger.info("failback:use your own server captcha validate");
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
            logger.info("gt-server非正常情况下，进行failback模式验证");
        }

        Map<String, Object> result = Maps.newHashMap();
        if (gtResult == 1) {
            // 验证成功
            logger.info("验证成功跳转页面");
            result.put("status", Boolean.TRUE);
            return Jacksons.json().fromObjectToJson(result);
        } else {
            // 验证失败
            logger.info("验证失败返回结果");
            result.put("status", Boolean.FALSE);
            return Jacksons.json().fromObjectToJson(result);
        }

    }

}
