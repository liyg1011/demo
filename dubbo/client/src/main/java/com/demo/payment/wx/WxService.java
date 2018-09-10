package com.demo.payment.wx;

import com.demo.HttpClient;
import com.demo.payment.PayService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WxService implements PayService {

    @Override
    public String pay(Map<String, String> params) {
        // 封装请求参数
        String orderInfo = WxUtils.createOrderInfo1(params);

        // 发送下单请求
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        HttpClient httpClient = HttpClient.getInstance();
        String sb = httpClient.post(url, orderInfo);

        // 将请求返回的内容通过xStream转换为对象
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));//说明3(见文末)
        xStream.alias("xml", OrderRespose.class);
        OrderRespose orderRespose = (OrderRespose) xStream.fromXML(sb);

        // 根据微信文档return_code 和result_code都为SUCCESS的时候才会返回code_url
        if (orderRespose != null) {
            if ("SUCCESS".equals(orderRespose.getReturn_code()) && "SUCCESS".equals(orderRespose.getResult_code())) {
                return orderRespose.getCode_url();
            } else if ("ORDERPAID".equals(orderRespose.getErr_code())) {
                return "200";
            }
        }
        throw new NullPointerException("系统错误，请稍后访问！");
    }

    @Override
    public String select(String orderId) {
        // 封装请求参数
        String orderInfo = WxUtils.createOrderInfo2(orderId);

        // 发送下单请求
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";
        HttpClient httpClient = HttpClient.getInstance();
        String sb = httpClient.post(url, orderInfo);

        // 将请求返回的内容通过xStream转换为UnifiedOrderRespose对象
        XStream xStream = new XStream();//说明3(见文末)
        xStream.alias("xml", OrderRespose2.class);
        OrderRespose2 orderRespose = (OrderRespose2) xStream.fromXML(sb);

        // 根据微信文档return_code和result_code和trade_state都为SUCCESS的时候才会返回code_url
        if (orderRespose == null) {
            return null;
        }

        if ("SUCCESS".equals(orderRespose.getReturn_code()) && "SUCCESS".equals(orderRespose.getResult_code())
                && "SUCCESS".equals(orderRespose.getTrade_state())) {
            return "success";
        } else {
            return "fail";
        }
    }

}
