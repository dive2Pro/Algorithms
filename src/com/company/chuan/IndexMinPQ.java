package com.company.chuan;

/**
 * 索引优先队列
 *
 * []  排序
 *
 * 3. Sort[N] = k;
 *
 * insert(int k, Item item)
 *
 * []  索引
 *
 * 1.    Index[k] = - 1;
 *    4. Index[k] = N++;
 *    swip(N);
 *
 * []  值
 *
 * 2.    Item[k] = item;
 *
 */
public class IndexMinPQ<Item extends Comparable<Item>> {
    private int[] pq;
    private int[] indexs;
    int N = 0;
    private Item[] items;

    IndexMinPQ(int size) {
        pq = new int[size];
        indexs = new int[size];
        items = (Item[]) new Comparable[size];
    }

    public void insert(int k , Item item ) {
        pq[k]   = ++N;
        items[k] = item;
        indexs[N] = k;
        swim(N);
    }

    public Item delete(int k) {
        int pqIndex = pq[k];
        Item deleted = items[k];
        // 和最小的交换 再 sink
        exch(pqIndex, N);

        items[k] = null;
        indexs[k] = 0;
        pq[N--] = 0;
        sink(pqIndex);

        return deleted;
    }

    public void change(int k, Item item) {

    }

    public boolean contains(int k) {
        return indexs[k] != 0;
    }

    public Item delMin() {
        return delete(1);
    }


    public Item min() {
        return items[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void exch(int i, int k) {

    }

    private void swim(int k) {
        while( k / 2 >= 1 && less( k / 2, k) ) {
            exch(k/ 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while( k * 2<= N) {
            int j = k * 2;
            if(less(j, j + 1)) j ++; // 找出两个子节点中较大的一个
            if(!less(k, j)) break; // 不可下沉
            exch(j, k);
            k = j;
        }
    }

    private boolean less(int i, int k) {
        int pqIndex1 = indexs[i];
        int pqIndex2 = indexs[k];

        Item i1 = items[pqIndex1];
        Item i2 = items[pqIndex2];

        return i1.compareTo(i2) < 0;
    }

}
