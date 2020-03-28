package com.company.chuan;

/**
 *  插入排序
 *
 *  | ^^^^^^^^^^^^^^ |
 *  | -^^^^^^^^^^^^^ |
 *  | _-^^^^^^^^^^^^ |
 *  | __-^^^^^^^^^^^ |
 *
 *   浮标会和其之前的并且是已经排好序的元素进行比较
 *   "插入" 该已经排好序的元素中
 *
 */
public class InsertSort extends SortExample {
    @Override
    public Comparable[] sort(Comparable[] source) {

        for(int i = 0 ; i < source.length; i ++) {
            for(int j = i ; j > 0 && source[j] != null && less(source[j], source[j - 1]) ; j --) {
                exch(source, j, j - 1);
            }
        }

        return source;
    }

    public Comparable[] sort(Comparable[] source, int lo, int hi, int d) {

        for(int i = lo ; i <= hi; i ++) {
            for(int j = i ; j > 0 && source[j] != null && less(source[j], source[j - 1]) ; j --) {
                exch(source, j, j - 1);
            }
        }

        return source;

    }
}
