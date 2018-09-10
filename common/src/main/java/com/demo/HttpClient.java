package com.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpClient {
    private org.apache.http.client.HttpClient httpclient = HttpClients.createDefault();
    private static HttpClient instance;

    public static HttpClient getInstance() {
        if (instance == null)
            instance = new HttpClient();
        return instance;
    }

    public String post(String url, String content) {

        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity req_entity = new StringEntity(content.toString(), "UTF-8");
            httpPost.setEntity(req_entity);
            HttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
                    StringBuffer result = new StringBuffer();
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);
                    }
                    return result.toString();
                }
                EntityUtils.consume(entity);
            } finally {
                httpPost.abort();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
                    StringBuffer result = new StringBuffer();
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);
                    }
                    return result.toString();
                }
                EntityUtils.consume(entity);
            } finally {
                httpGet.abort();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
