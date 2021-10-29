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
        SoftReference<V> link = cache.get(key);
        V value;
        if (link != null) {
            value = link.get();
        } else {
            value = load(key);
            SoftReference<V> newLink = new SoftReference<>(value);
            cache.put(key, newLink);
        }
        return value;
    }

    protected abstract V load(K key);

}