package com.demo.payment.wx;

/**
 * 统一下单请求参数(必填)
 */
public class OrderRequest2 {

    private String appid;               // 公众账号ID
    private String mch_id;              // 商户号
    private String transaction_id;      // 微信的订单号
    private String out_trade_no ;       // 微信的订单号
    private String nonce_str;           // 随机字符串
    private String sign;                // 签名
    private String sign_type;           // 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5

    public String getAppid() {
        return appid;
    }

    public OrderRequest2 setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public OrderRequest2 setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public OrderRequest2 setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public OrderRequest2 setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public OrderRequest2 setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderRequest2 setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public OrderRequest2 setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }
}
