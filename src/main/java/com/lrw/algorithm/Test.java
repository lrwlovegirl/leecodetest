package com.lrw.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//-1234
// - 4321
public class Test {
    public static void main(String[] args) {
        Map<String,Integer> map   = new ConcurrentHashMap();
        map.put(null,null);
        System.out.println(map.get(null));
    }

}
