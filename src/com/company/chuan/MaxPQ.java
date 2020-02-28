package com.company.chuan;


import java.util.LinkedList;
import java.util.Queue;

public class MaxPQ<Key extends Comparable<Key>>{
    Queue<Key> source;
    int maxLimit;
    public MaxPQ(int max) {
        source = new LinkedList<>();
        maxLimit = max;
    }

    public MaxPQ(Key[] a) {
        source = new LinkedList<>();
        for(Key item : a) {
            Insert(item);
        }
    }

    void Insert(Key v) {
        
    }

    Key max() {
        return source.peek();
    }
    Key delMax(){
        return source.poll();
    }
    boolean isEmpty() {
        return source.isEmpty();
    }
    int size() {
        return source.size();
    }
}
