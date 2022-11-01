package com.example.weifeng.postdemo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class PostWtihMapParameter {
    public static void main(String[] args) throws IOException {
    post();
    }

    public static void post() throws IOException {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8000/post");

        HashMap<String, Object> StringHashMap = new HashMap<>();
        StringHashMap.put("name","weifeng");
        StringHashMap.put("age",20);
        Iterator<String> iterator = StringHashMap.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            Object o = StringHashMap.get(next);
//            httpPost.setEntity();
        }

        CloseableHttpResponse execute = aDefault.execute(httpPost);

        System.out.println(EntityUtils.toString(execute.getEntity()));


    }
}
