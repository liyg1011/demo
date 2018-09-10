package com.demo.payment.wx;

import com.demo.MD5Util;
import com.demo.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.util.*;

public class WxUtils {

    // 公众账号ID
    private final static String appId = "";
    // 商户号
    private final static String mchId = "";
    // key设置路径：微信商户平台(pay.weixin.qq.com) -> 账户设置 -> API安全 -> 密钥设置
    private final static String key = "";

    /**
     * 生成订单
     */
    public static String createOrderInfo1(Map<String, String> params) {
        //生成订单对象
        OrderRequest orderRequest = new OrderRequest()
                .setAppid(appId)
                .setMch_id(mchId)
                .setNonce_str(StringUtil.random(15)) // 随机字符串
                .setBody(params.get("repaymentName")) // 商品描述
                .setOut_trade_no(params.get("uuid")) // 商户订单号
                .setTotal_fee(params.get("money")) // 1代表支付时是0.01
                .setSpbill_create_ip(params.get("ip")) // 终端IP
                .setNotify_url(params.get("notifyUrl")) // 通知地址
                .setTrade_type("NATIVE"); // JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付
        orderRequest.setSign(createSign1(orderRequest)); // 对字段进行签名
        //将订单对象转为xml格式
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xStream.alias("xml", OrderRequest.class);//根元素名需要是xml
        return xStream.toXML(orderRequest);
    }

    /**
     * 生成签名
     */
    private static String createSign1(OrderRequest orderRequest) {
        //根据规则创建可排序的map集合
        SortedMap<String, String> packageParams = new TreeMap<>();
        packageParams.put("appid", orderRequest.getAppid());
        packageParams.put("body", orderRequest.getBody());
        packageParams.put("mch_id", orderRequest.getMch_id());
        packageParams.put("nonce_str", orderRequest.getNonce_str());
        packageParams.put("notify_url", orderRequest.getNotify_url());
        packageParams.put("out_trade_no", orderRequest.getOut_trade_no());
        packageParams.put("spbill_create_ip", orderRequest.getSpbill_create_ip());
        packageParams.put("trade_type", orderRequest.getTrade_type());
        packageParams.put("total_fee", orderRequest.getTotal_fee());

        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();//字典序
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            //为空不参与签名、参数名区分大小写
            if (v != null && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }

        //第二步拼接key，key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
        sb.append("key=" + key);
        return MD5Util.encrypt(sb.toString()).toUpperCase();//MD5加密
    }

    public static String createOrderInfo2(String outTradeNo) {
        OrderRequest2 orderRequest2 = new OrderRequest2()
                .setAppid(appId) // 公众账号ID
                .setMch_id(mchId) // 商户号
                .setOut_trade_no(outTradeNo)
                .setNonce_str(StringUtil.random(15)) // 随机字符串
                .setSign_type("MD5");
        orderRequest2.setSign(createSign2(orderRequest2));
        //将订单对象转为xml格式
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xStream.alias("xml", OrderRequest.class);//根元素名需要是xml
        return xStream.toXML(orderRequest2);
    }

    /**
     * 生成签名
     */
    private static String createSign2(OrderRequest2 orderRequest2) {
        //根据规则创建可排序的map集合
        SortedMap<String, String> packageParams = new TreeMap<>();
        packageParams.put("appid", orderRequest2.getAppid());
        packageParams.put("mch_id", orderRequest2.getMch_id());
        packageParams.put("out_trade_no", orderRequest2.getOut_trade_no());
        packageParams.put("nonce_str", orderRequest2.getNonce_str());
        packageParams.put("sign_type", orderRequest2.getSign_type());

        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();//字典序
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            //为空不参与签名、参数名区分大小写
            if (v != null && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }

        //第二步拼接key
        sb.append("key=" + key);
        return MD5Util.encrypt(sb.toString()).toUpperCase();//MD5加密
    }

}
