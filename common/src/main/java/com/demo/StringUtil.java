package com.demo;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 判断字符串是空
     * @param params 可以一次传递多个值，如:isNull(str1,str2,str3...);
     * @return boolean
     */
    public static boolean isNull(String... params) {
        if (params == null || params.length == 0) {
            return false;
        }
        for (String param : params) {
            if (param == null || "".equals(param.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串不是空
     * @param params 可以一次传递多个值，如:isNotNull(str1,str2,str3...);
     * @return boolean
     */
    public static boolean isNotNull(String... params) {
        return !isNull(params);
    }

    /**
     * 分割字符串，默认是逗号
     * @param str 字符串
     * @return 分割后的
     */
    public static List<String> splitter(String str) {
        return splitter(str, ",");
    }

    /**
     * 按照指定的字符分割字符串
     * @param str 字符串
     * @param separator 字符
     * @return 分割后的
     */
    public static List<String> splitter(String str, String separator) {
        if (str == null || separator == null) {
            return null;
        }
        if ("".equals(str) || "".equals(separator)) {
            return new ArrayList<>();
        }
        return Lists.newArrayList(Splitter.on(separator).trimResults().omitEmptyStrings().split(str));
    }

    /**
     * 生成数字、小写字母、大写字母组合起来的随机数
     * @param length 个数
     * @return 字符串
     */
    public static String random(int length) {
        if (length == 0) {
            return "";
        }
        Random random = new Random();
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            int temp;
            switch (random.nextInt(4)) {
                case 1:
                    temp = random.nextInt(26) + 65;
                    break;
                case 2:
                    temp = random.nextInt(26) + 97;
                    break;
                default:
                    temp = random.nextInt(10) + 48;
                    break;
            }
            result[i] = (char) temp;
        }
        return String.valueOf(result);
    }

    /**
     * 随机生成数字
     * @param length 个数
     * @return 字符串
     */
    public static int randomNumber(int length) {
        if (length == 0) {
            return 0;
        }
        Random random = new Random();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) (random.nextInt(10) + 48);
        }
        return Integer.valueOf(String.valueOf(result));
    }

    public static void main(String[] args) {
        System.out.println(random(5));
    }
}