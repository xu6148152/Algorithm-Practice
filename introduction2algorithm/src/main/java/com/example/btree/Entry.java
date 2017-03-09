package com.example.btree;

/**
 * Created by binea on 2016/10/28.
 */

public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K k, V v)
    {
        this.key = k;
        this.value = v;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key + ":" + value;
    }
}
