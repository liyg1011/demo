package com.demo;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * dateTime工具类
 * 注意：使用joda时某几个日期会产生异常，比如：1990-4-15 00:00:00等，
 * 原因可能跟夏令时有关，加上时区即可
 */
public class DateTimeUtil {

    private final static DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter dateDtf = DateTimeFormat.forPattern("yyyy-MM-dd");
    private final static DateTimeFormatter dateDtf2 = DateTimeFormat.forPattern("yyyy年MM月dd日");
    private final static DateTimeFormatter dateDtf3 = DateTimeFormat.forPattern("MM月dd日");
    private final static DateTimeFormatter timeDtf = DateTimeFormat.forPattern("HH:mm:ss");

    /**
     * 将字符串转为 DateTime，默认会进行三个规则：日期+时间、日期、时间
     * @param str 需要转换的时间或者日期
     * @return 转换后的结果
     */
    public static DateTime parse(String str) {
        // 校验参数
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        // 1.日期+时间 的转换
        try {
            return parse(str, dtf);
        } catch (Exception e) {
            // 2.日期的转换
            try {
                return parse(str, dateDtf);
            } catch (Exception e1) {
                // 3.时间的转换
                try {
                    return parse(str, timeDtf);
                } catch (Exception e2) {
                    return null;
                }
            }
        }
    }

    /**
     * 将字符串解析为日期
     * @param str 字符串
     * @return 转换后的结果
     */
    public static DateTime parseDate(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parse(str, dateDtf);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串解析为时间
     * @param str 字符串
     * @return 转换后的结果
     */
    public static DateTime parseTime(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parse(str, timeDtf);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据传入的日期格式进行转换
     * @param str 时间
     * @param dtf 日期格式
     * @return 转换后的结果
     * @throws Exception 该方法产生的异常需要自行处理，因时区产生的异常除外
     */
    public static DateTime parse(String str, DateTimeFormatter dtf) throws Exception {
        if (StringUtils.isEmpty(str) || dtf == null) {
            throw new NullPointerException();
        }
        try {
            return dtf.parseDateTime(str);
        } catch (IllegalInstantException e) {
            return dtf.withZone(DateTimeZone.forOffsetHours(9)).parseDateTime(str);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 将一个日期转换为：几天前、几分钟前等
     * @param time 日期
     * @return 转换后的结果
     */
    public static String computeNow2(String time) {
        // 1.校验数据
        if (StringUtils.isEmpty(time)) {
            return time;
        }
        DateTime dateTime = DateTimeUtil.parse(time);
        if (dateTime == null) {
            return "";
        }

        DateTime now = new DateTime();
        if (dateTime.isBefore(now)) {
            Interval interval = new Interval(dateTime, now);
            Period period = interval.toPeriod();
            if (now.getYear() - dateTime.getYear() > 0) {
                return dateTime.toString(dateDtf2);
            } else if (period.getWeeks() > 0) {
                return dateTime.toString(dateDtf3);
            } else if (period.getDays() > 0) {
                return period.getDays() + "天前";
            } else if (period.getHours() > 0) {
                return period.getHours() + "小时前";
            } else if (period.getMinutes() > 0) {
                return period.getMinutes() + "分钟前";
            } else {
                return period.getSeconds() + "秒前";
            }
        } else {
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("---------------------------------");
        System.out.println(parse("1990-04-15 00:00:00"));
        System.out.println(parse("1990-04-15"));
        System.out.println(parse("00:00:00"));
        System.out.println("---------------------------------");
        System.out.println(parse("1990-05-15 00:00:00"));
        System.out.println(parse("1990-05-15"));
        System.out.println(parse("00:00:00"));
        System.out.println("---------------------------------");
        System.out.println(parse("1990-04-15", dateDtf));
        System.out.println("---------------------------------");
        System.out.println(parseDate("1990-04-15"));
        System.out.println(parseDate("00:00:00"));            // 测试错误情况
        System.out.println("---------------------------------");
        System.out.println(parseTime("00:00:00"));
        System.out.println(parseTime("1990-04-15"));          // 测试错误情况
    }
}
