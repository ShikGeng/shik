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
package com.shik.support.component;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.*;
import com.shik.constant.MapConstants;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gengshikun
 * @date 2017/7/6
 */
public class AlipayExecute {

    private static final Logger logger = LoggerFactory.getLogger(AlipayExecute.class);

    /**
     * 手机支付
     *
     * @param outTradeNo  商户网站唯一订单号
     * @param subject     商品的标题/交易标题/订单标题/订单关键字等。
     * @param totalAmount 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * @return
     * @throws AlipayApiException
     */
    public static String wapPay(String outTradeNo, String subject, String totalAmount) throws AlipayApiException {
        logger.info(">>>>>>>>>>>>>>>>>>>>>> alipay wapPay start >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(">>>>>>>>>>>>>>>>>>>>>> alipay params : {}, {}, {} >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", outTradeNo, subject, totalAmount);
        AlipayClient alipayClient = (AlipayClient) SpringContextUtil.getBean("alipayClient");
        AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", outTradeNo);
        bizContent.put("subject", subject);
        bizContent.put("total_amount", totalAmount);
        bizContent.put("timeout_express", MapConstants.ALIPAY_MAP.get("alipay.timeoutExpress"));
        bizContent.put("product_code", MapConstants.ALIPAY_MAP.get("alipay.page.product_code"));
//        bizContent.put("quit_url", ""); // 用户付款中途退出返回商户网站的地址。

        alipay_request.setBizContent(bizContent.toString());
        // 设置异步通知地址
        alipay_request.setNotifyUrl(MapConstants.ALIPAY_MAP.get("alipay.notify_url"));
        // 设置同步地址
        alipay_request.setReturnUrl(MapConstants.ALIPAY_MAP.get("alipay.return_url"));

        // form表单生产, 调用SDK生成表单
        logger.info(">>>>>>>>>>>>>>>>>>>>>> alipay wapPay end >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return alipayClient.pageExecute(alipay_request).getBody();

    }

    /**
     * 网站页面支付
     *
     * @param outTradeNo  商户网站唯一订单号
     * @param subject     商品的标题/交易标题/订单标题/订单关键字等。
     * @param totalAmount 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * @return
     * @throws AlipayApiException
     */
    public static String pagePay(String outTradeNo, String subject, String totalAmount) throws AlipayApiException {
        logger.info(">>>>>>>>>>>>>>>>>>>>>> alipay pagePay start >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(">>>>>>>>>>>>>>>>>>>>>> alipay params : {}, {}, {} >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", outTradeNo, subject, totalAmount);
        AlipayClient alipayClient = (AlipayClient) SpringContextUtil.getBean("alipayClient");
        AlipayTradePagePayRequest alipay_request = new AlipayTradePagePayRequest();

        // 封装请求支付信息
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", outTradeNo);
        bizContent.put("subject", subject);
        bizContent.put("total_amount", totalAmount);
        bizContent.put("timeout_express", MapConstants.ALIPAY_MAP.get("alipay.timeoutExpress"));
        bizContent.put("product_code", MapConstants.ALIPAY_MAP.get("alipay.page.product_code"));
//        bizContent.put("qr_pay_mode", "4"); // 支付二维码
//        bizContent.put("quit_url", ""); // 用户付款中途退出返回商户网站的地址。

        alipay_request.setBizContent(bizContent.toString());
        // 设置异步通知地址
        alipay_request.setNotifyUrl(MapConstants.ALIPAY_MAP.get("alipay.notify_url"));
        // 设置同步地址
        alipay_request.setReturnUrl(MapConstants.ALIPAY_MAP.get("alipay.return_url"));

        // form表单生产, 调用SDK生成表单
        logger.info(">>>>>>>>>>>>>>>>>>>>>> alipay pagePay end >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return alipayClient.pageExecute(alipay_request).getBody();

    }

    /**
     * 交易查询, 只需提供一个订单号
     *
     * @param outTradeNo 商户网站唯一订单号
     * @param tradeNo    支付宝交易号
     * @return
     * @throws AlipayApiException
     */
    public static String tradeQuery(String outTradeNo, String tradeNo) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = (AlipayClient) SpringContextUtil.getBean("alipayClient");

        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        JSONObject bizContent = new JSONObject();
        if(StringUtils.isNotBlank(outTradeNo))
            bizContent.put("out_trade_no", outTradeNo);
        if(StringUtils.isNotBlank(tradeNo))
            bizContent.put("trade_no", tradeNo);
        alipayRequest.setBizContent(bizContent.toString());

        //请求
        return alipayClient.execute(alipayRequest).getBody();

    }

    /**
     * 交易关闭, 只需提供一个订单号
     *
     * @param outTradeNo 商户网站唯一订单号
     * @param tradeNo    支付宝交易号
     * @return
     * @throws AlipayApiException
     */
    public static String tradeClode(String outTradeNo, String tradeNo) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = (AlipayClient) SpringContextUtil.getBean("alipayClient");

        //设置请求参数
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", outTradeNo);
        bizContent.put("trade_no", tradeNo);
        alipayRequest.setBizContent(bizContent.toString());

        //请求
        return alipayClient.execute(alipayRequest).getBody();
    }

    /**
     * 交易退款
     *
     * @param outTradeNo   商户订单号，商户网站订单系统中唯一订单号
     * @param tradeNo      支付宝交易号
     * @param refundAmount 需要退款的金额，该金额不能大于订单金额，必填
     * @param refundReason 退款的原因说明
     * @param outRequestNo 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     * @return
     * @throws AlipayApiException
     */
    public static String tradeRefund(String outTradeNo, String tradeNo, String refundAmount, String refundReason, String outRequestNo) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = (AlipayClient) SpringContextUtil.getBean("alipayClient");

        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", outTradeNo);
        bizContent.put("trade_no", tradeNo);
        bizContent.put("refund_amount", refundAmount);
        bizContent.put("refund_reason", refundReason);
        bizContent.put("out_request_no", outRequestNo);
        alipayRequest.setBizContent(bizContent.toString());

        //请求
        return alipayClient.execute(alipayRequest).getBody();
    }

    /**
     * 交易退款查询
     *
     * @param outTradeNo 商户订单号，商户网站订单系统中唯一订单号
     * @param tradeNo 支付宝交易号
     * @param outRequestNo 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
     * @return
     */
    public static String tradeRefundQuery(String outTradeNo, String tradeNo, String outRequestNo) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = (AlipayClient) SpringContextUtil.getBean("alipayClient");

        //设置请求参数
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", outTradeNo);
        bizContent.put("trade_no", tradeNo);
        bizContent.put("out_request_no", outRequestNo);
        alipayRequest.setBizContent(bizContent.toString());

        //请求
        return alipayClient.execute(alipayRequest).getBody();
    }

}
