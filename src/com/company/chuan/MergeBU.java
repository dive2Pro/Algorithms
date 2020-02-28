package com.company.chuan;

/**
 * 自底向上进行排序
 *
 * 将数组分成等分的数组， 大小从 1， 2， 4， 8 逐步增大
 *
 * 对每个小的数组进行排序
 *
 * 在最后一次归并时完成排序操作
 *
 */
public class MergeBU extends SortExample {
    private Comparable[] aux;
    @Override
    public Comparable[] sort(Comparable[] a) {
        Comparable[] source = a.clone();

        int N = source.length;

        aux = new Comparable[N];


        // 注意 size + size ， 这一步决定第二个数组不会抢到第一个数组的值
        for(int sz = 1; sz < N; sz += sz) {
            for(int lo = 0; lo < N - sz ; lo += sz + sz) {
                merge(source, lo, lo + sz - 1, Math.min(lo + sz + sz -1 , N -1));
            }
        }

        return source;
    }

    public void merge(Comparable[] a, int lo, int mid, int hi) {
        if(lo >= hi) return;
        int i = lo, j = mid + 1;

        for(int k = lo; k <= hi ; k ++) {
            aux[k] = a [k];
        }

        for(int k = lo; k <= hi ; k ++) {
            if(i > mid) {
                a[k] = aux[j ++];
            } else if( j > hi) {
                a[k] = aux[i ++];
            } else if(less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }

    }

}
