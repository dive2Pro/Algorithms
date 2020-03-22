package com.company.chuan;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(977);
    }

    public SeparateChainingHashST(final int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for(int i =0 ; i < M ; i ++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x07fffffff) % M;
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }
}