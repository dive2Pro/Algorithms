package com.company.chuan;

import java.util.Arrays;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends SortAbstract<Key, Value> {
    private int N;
    private Key[] keys;
    private Value[] values;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public Value get(Key key) {
        if( isEmpty()) {
            return null;
        }
        int i = rank(key);

        if( i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }

        return null;
    }

    public void put(Key key, Value val) {
        int i = rank(key);

        if( i < N && keys[i].compareTo(key) == 0) {
            values[i] = val;
            return;
        }

        for( int j = N ; j > i ; j --) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = val;
        N ++;
    }

    public Key floor(Key key) {
        int i = rank(key);

        if( i  > 0 ) {
            return keys[i - 1];
        } else {
            return keys[i];
        }
    }

    public void delete(Key key) {
        int i = rank(key);
        for( int j = i + 1 ; j < N - 1 ; j++) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        N --;
    }


    public int rank(Key key) {

        // 有序二分查找

        int lo = 0;
        int hi = N;

        while( lo < hi) {
            int mid = lo + ( hi - lo) / 2;
            if(keys[mid].compareTo(key) > 0) {
                hi = mid - 1;
            } else if(keys[mid].compareTo(key) < 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }


        return -1;
    }

    public Key min() {
        return keys[0];
    }

    public Key max( ) {
        return keys[N - 1];
    }

    public Key select(int i) {
        return keys[i];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        int i  = rank(lo);
        int j  = rank(hi);

        Key[] it = (Key[]) new Comparable[ j - i + 1];

        for( int k = 0 ; i < j ; i ++) {
            it[k++] = keys[i];
        }

        return Arrays.asList(it);
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public boolean isEmpty() {

        return false;
    }
}
