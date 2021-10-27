package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> reference = new SoftReference(value);
        cache.put(key, reference);
    }

    public V get(K key) {
        if (cache.get(key).get() == null) {
            cache.put(key, new SoftReference<>(load(key)));
        }
        return cache.get(key).get();
    }

    protected abstract V load(K key);

}