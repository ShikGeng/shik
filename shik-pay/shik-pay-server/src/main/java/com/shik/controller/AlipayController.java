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

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.shik.constant.MapConstants;
import com.shik.support.component.AlipayExecute;
import com.shik.support.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2017/7/6
 */
@Controller
@RequestMapping(value = "alipay")
public class AlipayController {

    private final Logger logger = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private DiscoveryClient client;

    /**
     * 支付成功展示页
     * 同步自动验签
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "return_url")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) {
        Map map = RequestUtil.params2Map(request);
        System.out.println("return:" + map);

        return "index";
    }

    /**
     * 后台异步通知, 需要验签
     * 只有支付宝订单状态改变时, 支付宝才会推送
     *
     * @param request
     * @param response
     * @return "success" 必须返回, 否则在25小时内才会过期
     */
    @RequestMapping(value = "notify_url")
    @ResponseBody
    public String notifyUrl(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = RequestUtil.params2Map(request);
        System.out.println("notify:" + map);

        try {
            // sign
            Boolean result = AlipaySignature.rsaCheckV1(map,
                    MapConstants.ALIPAY_MAP.get("alipay.alipay_public_key"),
                    MapConstants.ALIPAY_MAP.get("alipay.charset"),
                    MapConstants.ALIPAY_MAP.get("alipay.sign_type"));
            System.out.println(result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        // TODO appid
        // TODO out_trade_no
        // TODO trade_no
        // TODO total_amount
        // TODO seller_id

        return "success";
    }

    @RequestMapping(value = "page_pay")
    @ResponseBody
    public String pagePay() throws AlipayApiException {
        ServiceInstance instance = client.getLocalServiceInstance();
        String form = AlipayExecute.pagePay("amamamam2", "iPhone7 Plus", "0.5");
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + form);
        return form;

    }

    @RequestMapping(value = "query")
    @ResponseBody
    public String query() throws AlipayApiException {
        return AlipayExecute.tradeQuery("amamamam2", null);
    }

}
