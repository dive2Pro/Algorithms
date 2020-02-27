package com.company.chuan;

/**
 *
 * 希尔排序
 *
 * 希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的.
 * 假如 h = 3;
 * index:
 *  0   3 比较
 * |---------------|
 *
 *   1   4 比较
 * |---------------|
 *
 *    2   5 比较
 * |---------------|
 *
 *     ...
 * |---------------|
 *
 * 这样一轮后, 数组已经是部分有序了.
 *
 * 再 缩小 h 为 h / 3 = 1
 *
 * 再进行一轮, 这样整个数组就排好序了.
 *
 * 之所以这样做, 是因为插入排序总是相邻移动, 端到端要经历太多的交换
 *
 */
public class ShellSort extends SortExample {

    @Override
    public Comparable[] sort(Comparable[] a) {
        Comparable[] source = a.clone();

        int N = source.length;
        int h = 1;

        while( h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for(int i = h ; i < N; i ++) {
                /**
                 * 条件如果是:
                 *          j >  0 一次 for 循环 j - h 必大于 -1
                 */
                for( int j = i ; j - h >= 0 && less(source[j], source[j-h]) ; j -= h) {
                    exch(source, j, j - h);
                }
            }

            h = h / 3;
        }

        return source;
    }

}
