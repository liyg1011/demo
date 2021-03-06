package com.demo.speech.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.demo.speech.SpeechService;
import org.json.JSONObject;

import java.io.IOException;

@Service
public class BaiduSpeechServiceImpl implements SpeechService {

    // 设置APPID/AK/SK
    private static final String APP_ID = "9243268";
    private static final String API_KEY = "0qSq8wv4lUgqEGGkroCa70RY";
    private static final String SECRET_KEY = "f569b806a14e9eb5e47b868a885668a3";

    @Override
    public void convert(String str) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        TtsResponse res = client.synthesis(str, "zh", 1, null);
        try {
            Util.writeBytesToFileSystem(res.getData(), "output.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        // client.setConnectionTimeoutInMillis(2000);
        // client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        // client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        TtsResponse res = client.synthesis("你好百度", "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "output.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }

    }
}
