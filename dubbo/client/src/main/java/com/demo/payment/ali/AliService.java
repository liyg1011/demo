package com.demo.payment.ali;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.google.common.collect.Maps;
import com.rtcatch.common.constant.BaseCodeEnum;
import com.rtcatch.model.Repayment;
import com.rtcatch.service.pay.BasePay;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AliService extends BasePay {

    @Override
    public String getPay(Repayment repayment, String returnUrl, String notifyUrl,String typePage) {
//		SDK已经封装掉了公共参数，这里只需要传入业务参数
//		out_trade_no: 商户订单号，需要保证不重复
//		total_amount: 订单
//		subject: 订单标题
//		seller_id: 实际收款账号，一般填写商户PID即可
//		total_amount: 订单金额
        Map<String, String> map = Maps.newHashMap();
        map.put("out_trade_no", repayment.getUuid());
        map.put("total_amount", (double)(repayment.getMoney())/100 + "");
        map.put("subject", repayment.getRepaymentName());
        map.put("seller_id", AlipayUtils.SELLER_ID);
        
        
        if("MP".equals(typePage)){//手机页面
            map.put("product_code", AlipayUtils.PRODUCT_CODE);
            
            AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
            alipayRequest.setReturnUrl(returnUrl);    // 跳转地址
            alipayRequest.setNotifyUrl(notifyUrl);    // 通知地址
            alipayRequest.setBizContent(JSON.toJSONString(map));
     
//          调用SDK生成表单,返回给用户展示即可
            try {
                String htmlStr = AlipayUtils.getInstance().pageExecute(alipayRequest).getBody();
                return htmlStr;
            } catch (Exception e) {
                throw new NullPointerException("系统错误，请稍后访问！");
            } 
        }else{
            map.put("product_code", AlipayUtils.PRODUCT_CODE_PC);
            AlipayTradePagePayRequest pageRequest = new AlipayTradePagePayRequest();    
            pageRequest.setReturnUrl(returnUrl);    // 跳转地址
            pageRequest.setNotifyUrl(notifyUrl);    // 通知地址
            pageRequest.setBizContent(JSON.toJSONString(map));

            try {
                String htmlStr = AlipayUtils.getInstance().pageExecute(pageRequest).getBody();
                return htmlStr;
            } catch (Exception e) {
                throw new NullPointerException("系统错误，请稍后访问！");
            } 
        }
    }

    @Override
    public String getSelect(String orderId) {
//        设置业务参数
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        Map<String, String> map = Maps.newHashMap();
        map.put("out_trade_no", orderId);
        request.setBizContent(JSON.toJSONString(map));
        try {
//            通过alipayClient调用API，获得对应的response类
            AlipayTradeQueryResponse response = AlipayUtils.getInstance().execute(request);
            if (response.isSuccess()){
                return BaseCodeEnum.PAY_SUCCESS.getCode();
            } else {
                return BaseCodeEnum.PAY_FAIL.getCode();
            }
        } catch (Exception e) {
            throw new NullPointerException("系统错误，请稍后访问！");
        }
    }
}
