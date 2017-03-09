package com.example.design;

import java.util.LinkedList;

/**
 * Created by binea on 2016/11/22.
 */

public class Hash<K, V> {
    private class Cell<K, V> {
        private K key;
        private V value;

        public Cell(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public boolean equivalent(Cell<K, V> c) {
            return equivalent(getKey());
        }

        public boolean equivalent(K k) {
            return this.equals(k);
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }

    private final int MAX_SIZE = 10;
    LinkedList<Cell<K, V>>[] items;

    public Hash() {
        items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
    }

    public int hashCodeOfKey(K key) {
        return key.toString().length() % items.length;
    }

    public void put(K key, V value) {
        int x = hashCodeOfKey(key);
        if (items[x] == null) {
            items[x] = new LinkedList<>();
        }

        LinkedList<Cell<K, V>> collided = items[x];

        for (Cell<K, V> cell : collided) {
            if (cell.equivalent(key)) {
                collided.remove(cell);
                break;
            }
        }

        Cell<K, V> cell = new Cell<>(key, value);
        collided.add(cell);
    }

    public V get(K key) {
        int x = hashCodeOfKey(key);
        if (items[x] == null) {
            return null;
        }

        LinkedList<Cell<K, V>> collided = items[x];
        for(Cell<K, V>)
    }
}
