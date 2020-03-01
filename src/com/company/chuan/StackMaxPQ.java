package com.company.chuan;

/**
 * 堆排序
 *
 * 和二叉树不同的是, 堆不需要维护结点间关系的指针.
 * 利用数组的特性:
 *                      [1]
 *                  [2]     [3]
 *               [4] [5]  [6]  [7]
 *
 * [k] 的子节点: [2k] 和 [2k +1]
 * [k] 的父节点: [k/2]
 *
 * 很容易就知道插入的结点的位置和其他结点的关系. 通过上浮来排序
 *
 * 最大结点就是顶端结点, 删除后,将数组的最后一个元素放到顶端,再进行下沉操作.
 *
 * 这两个操作维持了一个优先队列
 *
 * @param <Key>
 */
public class StackMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0 ;

    public StackMaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public void insert(Key key) {
        if(N >= pq.length - 1) {
            Key[] newPq = (Key[]) new Comparable[pq.length * 2];
            for(int i = 0 ; i < pq.length ; i ++) {
                newPq[i] = pq[i];
            }
            pq = newPq;
        }
        pq[++N] = key;
        swim(N);
    }

    private boolean less(int i, int k) {
        return pq[i].compareTo(pq[k]) < 0 ;
    }


    private void exch(int i, int k) {
        Key[] keys = pq;
        Key t = keys[i];
        keys[i] = keys[k];
        keys[k] = t;
    }

    /**
     * 数据从上往下沉
     *
     * @param k
     */
    private void sink(int k) {
        while(2 * k <= N) {
            int j = 2 * k;
            if(j < N && less(j, j+1)) j ++; // 检查相邻的结点
            if(!less(k, j)) break; // 检查 k 是否小于 j 处
            exch(k, j);
            k = j;
        }
    }

    /**
     * 堆有序化, 上浮操作, 每个父节点肯定比子节点大
     *
     * @param k
     */
    private void swim(int k) {
        while( k > 1 && less(k / 2, k)) {
            exch(k /2, k);
            k = k / 2;
        }
    }

    Key delMax() {
        Key max = pq[1];
        exch(N  , 1);
        pq[--N] = null;
        sink(1);
        return max;
    }

    Key max() {
        return pq[1];
    }

    public static void main(String[] args) {
        StackMaxPQ stackMaxPQ = new StackMaxPQ<>(10);
        String[] ss = "qwertyuioasdzxcghjbmp".split("");
        for(String s: ss) {
            stackMaxPQ.insert(s);
        }
        System.out.println(stackMaxPQ.max());
        stackMaxPQ.delMax();
        stackMaxPQ.insert("z");
        System.out.println(stackMaxPQ.max());
    }
}
