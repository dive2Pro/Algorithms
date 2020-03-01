package com.company.chuan;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SelfControlArray<Item extends Comparable<Item>> {
    Item[] items;
    int N = 0;
    public SelfControlArray(Item[] source) {
        items = source;
    }

    public SelfControlArray(int size) {
       items = (Item[]) new Comparable[size];

    }

    private void resize(int size) {

        Item[] newItems = (Item[]) new Comparable[size];

        for(int i = 0 ; i < items.length; i ++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public void push(Item item) {
        if(N >= items.length) {
            resize(2 * items.length);
        }
        items[N ++] = item;
    }

    public Item pop() {
        Item last = items[--N];
        items[N] = null;
        if( N > 0 && N < items.length / 4) {
            resize(items.length / 2);
        }
        return last;
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N - 1;
    }

    public Item[] getSource() {
        return items;
    }

    public Item peek() {
        return items[N - 1];
    }

    public Item get(int index) {
        return items[index];
    }
}


public class MaxPQ<Key extends Comparable<Key>>{
    SelfControlArray<Key> source;
    private SelectSort sort = new SelectSort();
    public MaxPQ(int max) {
        source = new SelfControlArray<>(max);
    }

    public MaxPQ(Key[] a) {
        source = new SelfControlArray<>(a.length);
        for(Key item : a) {
            source.push(item);
        }
    }

    void insert(Key v) {
        source.push(v);
    }

    Key max() {
        sort.sort(source.getSource());
        return source.peek();
    }

    Key delMax(){
        max();
        return source.pop();
    }

    boolean isEmpty() {
        return source.isEmpty();
    }
    int size() {
        return source.size();
    }

    public static void main(String[] args) {
        MaxPQ maxPQ= new MaxPQ<String>(10);
        String[] ss = "qwertyuioasdzxcghjbmp".split("");
        for(String s: ss) {
            maxPQ.insert(s);
        }
        System.out.println(maxPQ.max());
        maxPQ.delMax();
        System.out.println(maxPQ.max());
    }
}

class OrderedMaxPQ<Key extends Comparable<Key>> extends MaxPQ<Key> {
    private InsertSort sort = new InsertSort();
    public OrderedMaxPQ(int max) {
        super(max);
    }

    void insert(Key v) {
        source.push(v);
        Key[] keys = source.getSource();
        sort.sort(keys);
    }

    Key max() {
        return source.peek();
    }

    Key delMax() {
        return source.pop();
    }

    public static void main(String[] args) {
        MaxPQ maxPQ= new OrderedMaxPQ(10);
        String[] ss = "qwertyuioasdzxcghjbmp".split("");
        for(String s: ss) {
            maxPQ.insert(s);
        }
        System.out.println(maxPQ.max());
        maxPQ.delMax();
        System.out.println(maxPQ.max());
    }
}
