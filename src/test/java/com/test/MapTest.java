package com.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhengTianLiang
 * @date: 2020/11/3  15:50
 * @desc: 测试map的几种遍历方法
 */
public class MapTest {

    @Test
    public void test01() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "郑天良1");
        map.put("2", "郑天良2");
        map.put("3", "郑天良3");

        // 方式1  map.values()  拿到全部的value值
        for (String s : map.values()) {
            System.out.println("====" + s);
        }

        System.out.println("-----------------------------");

        // 方式2，map.keySet()拿到全部的key值，通过key拿到value
        for (String s : map.keySet()) {
            System.out.print(s);
            System.out.println(":" + map.get(s));
        }

        System.out.println("-----------------------------");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        }
        System.out.println("-----------------------------");
    }
}
