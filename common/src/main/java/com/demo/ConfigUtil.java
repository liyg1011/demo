package com.demo;

import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件的工具类
 */
public class ConfigUtil {

    private ConfigUtil() {

    }

    private static String reportUrl;                    // 需要读取配置

    // 静态初始化方法，可以使该代码只加载一次
    static {
        // 要加载的配置文件，此处根据实际情况填写
        InputStream in = ConfigUtil.class.getResourceAsStream("/config.properties");
        try {
            Properties prop = new Properties();
            prop.load(in);
            reportUrl = prop.getProperty("report.url").trim();    // 从配置文件中读取配置
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getReportUrl() {
        return reportUrl;
    }

    public static void setReportUrl(String reportUrl) {
        ConfigUtil.reportUrl = reportUrl;
    }
}
