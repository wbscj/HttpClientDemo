package com.example.weifeng.picture;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class GetPicture {

    public static void main(String[] args) throws IOException {
        String url = "https://img1.baidu.com/it/u=2178800524,692502547&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=324";
//        String url = "https://img1.baidu.com/it/u=4050690376,728180688&fm=253&fmt=auto&app=138&f=JPEG?w=894&h=500";
        getpicture(url);
    }
    public static void getpicture(String url) throws IOException {
        CloseableHttpClient aDefault = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse execute = aDefault.execute(httpGet);


        byte[] bytes = EntityUtils.toByteArray(execute.getEntity());
        FileOutputStream fileOutputStream= new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.png");
        fileOutputStream.write(bytes);

        fileOutputStream.close();

        aDefault.close();

    }
}
