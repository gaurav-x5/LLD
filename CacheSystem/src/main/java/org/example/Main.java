package org.example;

import org.example.cache.Cache;
import org.example.cache.factories.CacheFactory;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new CacheFactory<Integer, Integer>().defaultCache(3);

        cache.put(1, 1);
        cache.put(2, 2);

        cache.put(3, 3);

        cache.put(4, 4);

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}