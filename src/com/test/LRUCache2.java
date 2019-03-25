package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {

    int capacity;
    LinkedHashMap <Integer, Integer> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap <Integer, Integer>(capacity);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if(value ==null){
            return -1;
        }
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if(map.size()==capacity){
            Map.Entry entry = map.entrySet().iterator().next();
            map.remove(entry.getKey());
        }
        if(map.containsKey(key)){
            map.remove(key);
        }
        map.put(key, value);
    }


    public static void main(String [] args){
        LRUCache2 cache2 = new LRUCache2(2);
        cache2.get(2);
        cache2.put(2,6);
        cache2.get(1);
        cache2.put(1,5);
        cache2.put(1,2);
        cache2.get(1);
        cache2.get(2);

    }

}
