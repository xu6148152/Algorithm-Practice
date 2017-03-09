package com.example.btree;

/**
 * Created by binea on 2016/10/28.
 */

public class SearchResult<V> {
    private boolean exist;
    private int index;
    private V value;

    public SearchResult(boolean exist, int index)
    {
        this.exist = exist;
        this.index = index;
    }

    public SearchResult(boolean exist, int index, V value)
    {
        this(exist, index);
        this.value = value;
    }

    public boolean isExist()
    {
        return exist;
    }

    public int getIndex()
    {
        return index;
    }

    public V getValue()
    {
        return value;
    }
}
