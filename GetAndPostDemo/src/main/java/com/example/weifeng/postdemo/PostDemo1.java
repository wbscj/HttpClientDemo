package com.example.weifeng.postdemo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class PostDemo1 {
    public static void main(String[] args) throws IOException {
    postwithJson();

    }

    public static void postwithJson() throws IOException {
        int timeout = 600;
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout * 1000)
                .setConnectTimeout(timeout * 1000)
                .setConnectionRequestTimeout(timeout * 1000)
                .build();

        CloseableHttpClient aDefault = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

        HttpPost httpPost = new HttpPost("http://localhost:8000/post");

        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Connection","keep-alive");
        httpPost.setHeader("Accept-Encoding","gzip, deflate, br");
        httpPost.setHeader("Accept","*/*");
        httpPost.setHeader("charset","UTF-8");
        httpPost.setHeader("Host","127.0.0.1:8000");
        httpPost.setHeader("origin","Apache-HttpClient/4.5.12 (Java/1.8.0_181)");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","weifeng");
        jsonObject.put("age",20);

        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse execute = aDefault.execute(httpPost);



//        输出响应内容
        String string = EntityUtils.toString(execute.getEntity());
        System.out.println(string);


        aDefault.close();
    }
}
