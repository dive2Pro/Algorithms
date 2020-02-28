package com.company.chuan;

/**
 * 归并排序
 *
 */
public class Merge extends SortExample {

    Comparable[] aux;
    protected void merge(Comparable[] a, int lo, int mid, int hi) {

        int l = lo;
        int m = mid + 1;

        for(int k = lo; k <= hi ; k ++) {
            aux[k] = a[k];
        }



        for(int k = lo; k <= hi; k++ ) {
            if( l > mid) {
                a[k] = aux[m++];
            } else if(m > hi) {
                a[k] = aux[l++];
            } else if(less(aux[l],aux[m])) {
                a[k] = aux[l++];
            } else {
                a[k] = aux[m++];
            }
        }
    }


    @Override
    public Comparable[] sort(Comparable[] a) {

        Comparable[] source = a.clone();
        aux = new Comparable[source.length];
        int lo = 0;
        int hi = source.length - 1;

        sort(source, lo, hi);
        return source;
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + ( hi - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
}
