package com.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 参数校验工具类
 */
public class ValidateUtil {

    /**
     * 判断是否是手机号码
     * @param mobile 手机号码
     * @return 结果
     */
    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Pattern p = Pattern.compile("^1[0-9]{10}$");
        return p.matcher(mobile).matches();
    }

    /**
     * 判断是否是邮箱
     * @param email 邮箱
     * @return 结果
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        Pattern p = Pattern
                .compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        return p.matcher(email).matches();
    }

    /**
     * 判断是否是整数
     * @param str 字符串
     * @return 结果
     */
    public static boolean isInteger(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
