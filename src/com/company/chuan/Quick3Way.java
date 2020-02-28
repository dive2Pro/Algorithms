package com.company.chuan;

/**
 * 快速排序, 三分排序进阶版
 *
 * 如果数组中有大量重复的元素, 普通的快速排序会做大量不必要的排序
 * 三分排序, 会持有三个指标
 * lt 最左
 * i  相等
 * gt 最右
 *
 * 每一轮的目的是将数组分成   小于| 等于| 大于  某个数的三部分
 *
 * 比较方法:
 *         lt = lo, i = lo + 1, gt = hi;
 *         选定 lo 上的值 v
 *         比较  v 和 i 上的值 , 如果:
 *                       相等  i ++
 *                        -1  交换 lt 和 i 位置上的值,  lt++, i ++ ,
 *                        +1  交换 i 和 gt 位置上的值, lt++, gt--
 *
 */
public class Quick3Way  extends SortExample{
    @Override
    public Comparable[] sort(Comparable[] a) {

        Comparable[] source = a.clone();
        int N = source.length;
        sort(source, 0 , N - 1);
        return source;
    }

    public void sort(Comparable[] a, int lo, int hi) {

        if(hi < lo) return;
        int lt = lo;
        int i = lo;
        int gt = hi;

        int dff = (int)( hi - lo ) / 2 + lo;
        Comparable v = a[dff];

        while( i <= gt) {
            int compared = a[i].compareTo(v);
            if(compared < 0) {
                exch(a, i++, lt ++);
            } else if(compared > 0) {
                exch(a, gt--, i);
            } else {
                i ++;
            }
        }

        sort(a, lo, lt -1 );
        sort(a, gt + 1, hi);
    }
}
