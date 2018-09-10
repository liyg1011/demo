package com.demo.payment;

import java.util.Map;

public interface PayService {

    String pay(Map<String, String> param);

    String select(String uuid);

}
