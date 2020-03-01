package com.company.chuan;

// TODO: 索引优先队列
public class IndexMinPQ<Item extends Comparable<Item>> {
    private Item[] pq;

    IndexMinPQ(int size) {
        pq = (Item[]) new Comparable[size];
    }

    public void insert(int k , Item item ) {
        pq[k]   = item;
        swim(k);
    }

    public void change(int k, Item item) {
        pq[k] = item;
    }

    public boolean contains(int k) {
        return false;
    }

    public void delete(int k) {

    }
    public Item min() {
        return pq[0];
    }

    public int minIndex() {
        return 0;
    }
    public Item delMin() {
        Item min = pq[1];
        return min;
    }

    public int size() {
        return pq.length - 1;
    }

    public boolean isEmpty() {
        return pq[1] == null;
    }

    private void swim(int k) {

    }

    private void sink(int k) {

    }


}
