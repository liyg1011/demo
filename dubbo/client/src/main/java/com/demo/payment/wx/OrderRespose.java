package com.demo.payment.wx;

/**
 * 统一下单返回参数
 */
public class OrderRespose {

    private String return_code;             // 返回状态码
    private String return_msg;              // 返回信息
    private String appid;                   // 公众账号ID
    private String mch_id;                  // 商户号
    private String device_info;             // 设备号
    private String nonce_str;               // 随机字符串
    private String sign;                    // 签名
    private String result_code;             // 业务结果
    private String err_code;                // 错误代码
    private String err_code_des;            // 错误代码描述
    private String trade_type;              // 交易类型
    private String prepay_id;               // 预支付交易会话标识
    private String code_url;                // 二维码链接

    public String getReturn_code() {
        return return_code;
    }

    public OrderRespose setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public OrderRespose setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public OrderRespose setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public OrderRespose setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public OrderRespose setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public OrderRespose setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderRespose setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public OrderRespose setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public OrderRespose setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public OrderRespose setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public OrderRespose setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public OrderRespose setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
        return this;
    }

    public String getCode_url() {
        return code_url;
    }

    public OrderRespose setCode_url(String code_url) {
        this.code_url = code_url;
        return this;
    }
}
