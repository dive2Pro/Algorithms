package com.company.chuan;


/**
 * 快速排序
 * 利用分而治之的思想
 * 以 partition 这个点为准， 左边是比它小的， 右边是比它大的
 *
 * 假如设 partition 这个点 在 p 的位置上
 * lo   >>>     hi
 *
 * | ---------- |
 *
 * 从右端开始（hi）向 左 检查， 直到找到一个比 partition 数小的数
 * 从左端开始（lo）向 右 检查， 直到找到一个比 partition 数大的数
 *
 * 交换他们两个的位置。
 * 再继续找下一个匹配的， 如此这般， 当两个相向的指针相遇时
 * 交换 p 与 左边子数组最右测的位置 j， 再返回 j 即可
 *
 * | ---------- |
 */
public class QuickSort extends SortExample{

    @Override
    public Comparable[] sort(Comparable[] a) {
        Comparable[] source = a.clone();
        sort(source, 0, source.length - 1);
        return source;
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        Comparable v = a[lo];

        while(true) {
            while(less(a[++i], v)){
                if(i == hi) break;
            }
            while(less(v, a[--j])) {

            }
            if(i >= j ) break;
            exch(a, i, j);
        }

        exch(a, j, lo);
        return j;
    }

}
