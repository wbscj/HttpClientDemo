package com.example.weifeng.getdemo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetDemo1 {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient aDefault = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://localhost:8000/get");

        CloseableHttpResponse execute = aDefault.execute(httpGet);


        System.out.println(execute.getEntity());
//输出具体内容
        System.out.println(EntityUtils.toString(execute.getEntity(), "UTF-8"));


    }


}
