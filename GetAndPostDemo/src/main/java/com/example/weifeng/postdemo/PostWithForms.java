package com.example.weifeng.postdemo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PostWithForms {
    public static void main(String[] args) throws IOException {
        postwithforms1();
    }

    public static void postwithforms1() throws IOException {
        CloseableHttpClient aDefault = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8000/post/from");
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        String s = "name=weifeng&age=20&message=%E5%8A%A0%E6%B2%B9";

        httpPost.setEntity(new StringEntity(s));

        CloseableHttpResponse execute = aDefault.execute(httpPost);

        System.out.println(EntityUtils.toString(execute.getEntity()));

    }
}
