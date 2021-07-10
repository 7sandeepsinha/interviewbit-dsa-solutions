package org.sandeep.hashing;

import java.util.HashMap;

public class LRUCache {
    private int c = 0;
    private HashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.c = capacity;
        cache = new HashMap<>(capacity);

    }

    public int get(int key) {
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.size() < c || cache.containsKey(key)){
            cache.put(key,value);
        }

    }
}
