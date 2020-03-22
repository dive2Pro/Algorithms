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
 * 4. Index[k] = N++;
 * swip(N);
 *
 * []  值
 *
 * 2.    Item[k] = item;
 *
 *
 *
 * 思路 -》
 * 1 ->
 * | | | | | | |                       |k| | | | | |                                                  |k| | | | | |
 * 0->                                       k          sort[1]=k        k                                  k
 * | | | | | | |   = insert(k, item) > | | | | | | |      ->       | | |1| | | -- insert(n, p) ->     | | |1| | | |
 * 0->                                       k
 * | | | | | | |                       | | |t| | | |
 */
public class IndexMinPQ<Item extends Comparable<Item>> {
    private int[] sort;
    private int[] indexs;
    int N = 0;
    private Item[] items;

    public IndexMinPQ(int size) {
        sort = new int[size];
        indexs = new int[size];
        items = (Item[]) new Comparable[size];
    }

    public void insert(int k, Item item) {
        sort[++N] = k;
        items[k] = item;
        indexs[k] = N;
        swim(N);
        sortIndex();
    }

    private void sortIndex() {
        for (int i = 1; i < N; i++) {
            int indexInSort = sort[i];
            indexs[indexInSort] = i;
        }
    }

    /**
     *
     * @param k Index
     * @return 二叉堆下最小的
     */
    private int findSmallestFrom(int k) {
        int sortK = k;

        while( sortK  * 2 <= N) {
            int j = sortK * 2;
//            if(j + 10 <= N && !less(j, j + 1)) j ++;
            sortK *= 2;
        }

        return sortK;
    }

    /**
     * 找到该节点下最小的， 与其交换
     *
     * @param k Index
     * @return 删除的索引指向的值
     *
     */
    public void delete(int k) {
        int pqIndex = indexs[k];
        Item deleted = items[k];
        // 和最小的交换 再 sink
//        int smallest = findSmallestFrom(pqIndex);
        int smallest = N;
        exch(pqIndex, smallest);
        items[k] = null;
        indexs[k] = 0;
        sort[N--] = 0;
        sink(pqIndex);
        sortIndex();
    }

    public void change(int k, Item item) {
        // 改变后
        items[k] = item;
        int sortIndex = indexs[k];
        exch(sortIndex, N);
        sink(sortIndex);
        swim(N);
        sortIndex();
        // 1. swim
        // 2. sink
        // 3. sortIndex
    }

    public boolean contains(int k) {
        return indexs[k] != 0;
    }

    public int delMin() {
        int min = sort[1];
        delete(1);
        return min;
    }


    public Item min() {
        return items[sort[1]];
    }

    public int minIndex() {
        return sort[1];
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     *  交换 两个位置的值
     * @param i sort 中的位置
     * @param k sort 中的位置
     */
    public void exch(int i, int k) {
        int temp = sort[i];
        sort[i] = sort[k];
        sort[k] = temp;
    }

    /**
     *
     * @param k sort 中的位置
     */
    private void swim(int k) {
        while (k / 2 >= 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if ( less(j, j + 1)) j++; // 找出两个子节点中较大的一个
            if (!less(k, j)) break; // 不可下沉
            exch(j, k);
            k = j;
        }
    }

    /**
     *
     * @param i sort 中的位置
     * @param k sort 中的位置
     * @return 该位置在索引中的大小比较
     */
    private boolean less(int i, int k) {

        int pqIndex1 = sort[i];
        int pqIndex2 = sort[k];

        Item i1 = items[pqIndex1];
        Item i2 = items[pqIndex2];

        return i1.compareTo(i2) < 0;
    }

    public static void main(String[] args){
        IndexMinPQ indexMinPQ = new IndexMinPQ<>(20);

        indexMinPQ.insert(3, "J" );
        indexMinPQ.insert(10, "D" );
        indexMinPQ.insert(13, "X" );
        indexMinPQ.insert(6, "Z" );
        indexMinPQ.insert(8, "A" );
        indexMinPQ.insert(18, "K" );

        assert indexMinPQ.minIndex() == 6;
        System.out.println(indexMinPQ.minIndex());
        assert indexMinPQ.delMin() == 6;
        indexMinPQ.delete(6);
        assert indexMinPQ.minIndex() == 13;

        indexMinPQ.change(8, "Y");
        assert indexMinPQ.minIndex() == 8;
    }

}
