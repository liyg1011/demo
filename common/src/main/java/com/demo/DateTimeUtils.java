package com.demo;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * dateTime工具类，实际使用中应该使用dateTime替换date类
 */
public class DateTimeUtils {

    private final static DateTimeFormatter dateTimeFmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter dateFmt = DateTimeFormat.forPattern("yyyy-MM-dd");
    private final static DateTimeFormatter timeFmt = DateTimeFormat.forPattern("HH:mm:ss");

    /**
     * 将字符串解析为时间类型
     * 实际使用中会安装三种类型进行解析，如果无法解析则返回空
     * @param str 要解析的字符串
     * @return 时间类
     */
    public static DateTime parse(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return DateTime.parse(str, dateTimeFmt);
        } catch (Exception e) {
            try {
                return DateTime.parse(str, dateFmt);
            } catch (Exception e1) {
                try {
                    return DateTime.parse(str, timeFmt);
                } catch (Exception e2) {
                    return null;
                }
            }
        }
    }

    /**
     * 根据制定的日期格式解析时间字符串
     * @param str 要解析的字符串
     * @param fmt 时间格式
     * @return 时间类
     */
    public static DateTime parse(String str, String fmt) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (fmt == null || fmt.isEmpty()) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(fmt);
            return DateTime.parse(str, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据指定的日期格式解析时间字符串
     * @param str 要解析的字符串
     * @param fmt 时间格式
     * @return 时间类
     */
    public static DateTime parse(String str, DateTimeFormatter fmt) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (fmt == null) {
            return null;
        }
        try {
            return DateTime.parse(str, fmt);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串解析为日期类型
     * @param str 字符串
     * @return 日期类型
     */
    public static DateTime parseDate(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return DateTime.parse(str, dateFmt);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串解析为时间类型
     * @param str 字符串
     * @return 日期类型
     */
    public static DateTime parseTime(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return DateTime.parse(str, timeFmt);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将传入的日期时间转换为“几秒前”“几分钟前”“几小时”等形式，类似于微信聊天的时间
     * @param str 传入的时间，格式为：yyyy-MM-dd HH:mm:ss
     * @return 转换后的结果
     * TODO: 如果传入的日期大于当前日期，做成“几秒后”“几分钟后”等的形式
     */
    public static String replace(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        DateTime dateTime = parse(str);
        DateTime now = new DateTime();
        if (dateTime.isBefore(now)){
            Interval interval = new Interval(dateTime, now);
            Period period = interval.toPeriod();
            if (now.getYear() - dateTime.getYear() > 0) {
                return dateTime.toString(dateFmt);
            } else if (period.getWeeks() > 0) {
                return dateTime.toString(dateFmt);
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

    public static void main(String[] args) {
        System.out.println(replace("2018-04-04 15:38:58"));
    }
}
