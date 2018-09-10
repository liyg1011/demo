package com.demo.payment.wx;

/**
 * 统一下单请求参数(必填)
 */
public class OrderRequest {

    private String appid;               // 公众账号ID
    private String mch_id;              // 商户号
    private String nonce_str;           // 随机字符串
    private String body;                // 商品描述
    private String out_trade_no;        // 商户订单号
    private String total_fee;           // 总金额
    private String spbill_create_ip;    // 终端IP
    private String notify_url;          // 通知地址
    private String trade_type;          // 交易类型
    private String transaction_id;      // 微信的订单号
    private String sign;                // 签名
    private String sign_type;           // 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5

    public String getAppid() {
        return appid;
    }

    public OrderRequest setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public OrderRequest setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public OrderRequest setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getBody() {
        return body;
    }

    public OrderRequest setBody(String body) {
        this.body = body;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public OrderRequest setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public OrderRequest setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public OrderRequest setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public OrderRequest setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public OrderRequest setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public OrderRequest setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public OrderRequest setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }
}
