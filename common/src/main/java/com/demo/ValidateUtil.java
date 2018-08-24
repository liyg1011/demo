package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数校验工具类
 */
public class ValidateUtils {

    /**
     * 判断是否是手机号码
     * @param phone 手机号码
     * @return 结果
     */
    public static boolean isMobile(String phone) {
        if (StringUtil.isNotNull(phone)) {
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m = p.matcher(phone);
            return m.matches();
        } else {
            return false;
        }
    }

    /**
     * 判断是否是邮箱
     * @param email 邮箱
     * @return 结果
     */
    public static boolean isEmail(String email) {
        if (StringUtil.isNotNull(email)) {
            Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
            Matcher m = p.matcher(email);
            return m.matches();
        } else {
            return false;
        }
    }

    /**
     * 判断是否是整数
     * @param str 字符串
     * @return 结果
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
