package com.example.weifeng.datedemo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

public class DateDemo {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.22333);

        double aa = a.doubleValue();
        System.out.println(aa);

        BigDecimal b = new BigDecimal(0.1111);
        BigDecimal c = new BigDecimal(0.3333);

        BigDecimal cc = a.add(b).add(c);
        System.out.println(cc);

        System.out.println(a.add(b).add(c).equals(0));



        HashMap<Object, Object> headermap = new HashMap<>();
        headermap.put("Content-type" ,"application/json");
        headermap.put("charset","UTF-8");
        headermap.put("Connection","keep-alive");
        headermap.put("Host","10.133.47.82:8080");
        headermap.put("origin","Apache-HttpClient/4.5.12 (Java/1.8.0_181)");

        Iterator<Object> iterator = headermap.keySet().iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(headermap.get(next));
        }

    }
}
