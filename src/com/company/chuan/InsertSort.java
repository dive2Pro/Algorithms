package com.company.chuan;

/**
 *  插入排序
 *
 *  | ^^^^^^^^^^^^^^ |
 *  | -^^^^^^^^^^^^^ |
 *  | _-^^^^^^^^^^^^ |
 *  | _--^^^^^^^^^^^ |
 *
 *   浮标会和其之前的并且是已经排好序的元素进行比较
 *   "插入" 该已经排好序的元素中
 *
 */
public class InsertSort extends SortExample {
    @Override
    public Comparable[] sort(Comparable[] a) {
        Comparable[] source = a.clone();

        for(int i = 0 ; i < source.length; i ++) {
            for(int j = i ; j > 0 && less(source[j], source[j - 1]) ; j --) {
                exch(source, j, j - 1);
            }
        }

        return source;
    }
}
