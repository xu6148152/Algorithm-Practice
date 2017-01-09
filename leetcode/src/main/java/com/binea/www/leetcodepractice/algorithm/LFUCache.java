package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 09/01/2017.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache<K, V> {
    private final int DEFAULT_CAPACITY = 8;
    private int mCapacity = DEFAULT_CAPACITY;

    //private LinkedHashMap<K, CacheEntry<V>> mLinkedCache;

    private Node head = null;
    private HashMap<K, V> valueHash = null;
    private HashMap<K, Node> nodeHash = null;

    public LFUCache(int capacity) {
        this.mCapacity = capacity;
        initCache();
    }

    public LFUCache() {
        initCache();
    }

    private void initCache() {
        //mLinkedCache = new LinkedHashMap<>(mCapacity);
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }

    public void put(K key, V value) {
        if (mCapacity == 0) {
            throw new IllegalArgumentException("the capacity is 0");
        }
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if (valueHash.size() < mCapacity) {
                valueHash.put(key, value);
            } else {
                removeOld();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }

    private void addToHead(K key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            node.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }

        nodeHash.put(key, head);
    }

    private void removeOld() {
        if (head == null) {
            return;
        }
        K old = null;
        for (K key : head.keys) {
            old = key;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) {
            remove(head);
        }
        nodeHash.remove(old);
        valueHash.remove(old);
    }

    public V get(K key) {
        //final CacheEntry<V> cacheEntry = mLinkedCache.get(key);
        //if (cacheEntry != null) {
        //    return cacheEntry.getValue();
        //}
        //
        //return null;
        if (valueHash.containsKey(key)) {
            increaseCount(key);
            return valueHash.get(key);
        }
        return null;
    }

    private void increaseCount(K key) {
        final Node node = nodeHash.get(key);
        node.keys.remove(key);

        if (node.next == null) {
            node.next = new Node(++node.count);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(++node.count);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }

        nodeHash.put(key, node.next);
        if (node.keys.size() == 0) {
            remove(node);
        }
    }

    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    private static class CacheEntry<V> {
        private long mTimeStamp; //used timestamp
        private long mCount; //used count
        private V value;

        public long getTimeStamp() {
            return mTimeStamp;
        }

        public void setTimeStamp(long mTimeStamp) {
            this.mTimeStamp = mTimeStamp;
        }

        public long getCount() {
            return mCount;
        }

        public void setCount(long mCount) {
            this.mCount = mCount;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private class Node {
        public int count = 0;
        public LinkedHashSet<K> keys = null;
        public Node prev = null, next = null;

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
            prev = next = null;
        }
    }
}
