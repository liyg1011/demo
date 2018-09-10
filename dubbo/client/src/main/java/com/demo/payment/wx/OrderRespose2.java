package com.demo.payment.wx;

/**
 * 统一下单返回参数
 */
public class OrderRespose2 {

    private String return_code;
    private String return_msg;
    private String appid;                   // 公众账号ID
    private String mch_id;                  // 商户号
    private String nonce_str;               // 随机字符串
    private String sign;                    // 签名
    private String result_code;             // 业务结果
    private String err_code;                // 错误代码
    private String err_code_des;            // 错误代码描述

    private String device_info;             // 设备号
    private String openid;                  // 用户在商户appid下的唯一标识
    private String is_subscribe;            // 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
    private String trade_type;              // 交易类型
    private String trade_state;             // SUCCESS—支付成功
    private String trade_state_desc;        // 交易状态描述
    private String bank_type;               // 银行类型，采用字符串类型的银行标识
    private String total_fee;               // 订单总金额，单位为分
    private String fee_type;                //
    private String transaction_id;          // 微信支付订单号
    private String out_trade_no;            // 商户订单号
    private String time_end;                // 支付完成时间
    private String attach;                  //
    private String cash_fee;                //

    public String getReturn_code() {
        return return_code;
    }

    public OrderRespose2 setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public OrderRespose2 setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public OrderRespose2 setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public OrderRespose2 setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public OrderRespose2 setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderRespose2 setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public OrderRespose2 setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public OrderRespose2 setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public OrderRespose2 setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public OrderRespose2 setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public OrderRespose2 setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public OrderRespose2 setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public OrderRespose2 setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public OrderRespose2 setTrade_state(String trade_state) {
        this.trade_state = trade_state;
        return this;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public OrderRespose2 setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public OrderRespose2 setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public OrderRespose2 setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public OrderRespose2 setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public OrderRespose2 setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public OrderRespose2 setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public OrderRespose2 setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public OrderRespose2 setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    public OrderRespose2 setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }
}
