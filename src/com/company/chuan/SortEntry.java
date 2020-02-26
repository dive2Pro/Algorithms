package com.company.chuan;

import java.util.ArrayList;

abstract class Sort {
    public abstract Comparable[] sort(Comparable[] a) ;

    protected Boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected Boolean isSorted(Comparable[] a) {
        for(int i = 0 ; i < a.length - 1; i ++) {
            if(!less(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    protected void exch(Comparable[] a, int i , int j ) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(Comparable[] a) {
        for(int i = 0 ; i < a.length ; i ++) {
            System.out.println(a[i]);
        }
    }

    public static void rank(Sort sortInstance, Comparable[] a) {
        Comparable[] sorted = sortInstance.sort(a);
        assert sortInstance.isSorted(sorted);
        sortInstance.show(sorted);
        System.out.println("-------------- " + sortInstance.getClass().getName() + " ------------ ");
    }

}

class SelectSort extends Sort {

    /**
     * 第一轮比较选出最小的放在排头
     * 第二轮比较选出余下最小的放在第二的位置
     * ....
     *
     * @param a
     * @return
     */
    @Override
    public Comparable[] sort(Comparable[] a) {
       Comparable[] source = a.clone();

       for(int i = 0; i < source.length - 1 ; i ++) {
           int min = i;
           for(int j = i + 1; j < source.length; j ++ ) {
               if(less(source[j], source[min])) {
                   min = j;
               }
           }
           exch(source, i, min);
       }
        return source;
    }
}

public class SortEntry {
    public static void main(String[] args) {
        Comparable[] source = new Integer[] {2, 1, 8, 6, 7, 0, 4, 3, 9, 5};
        SelectSort selectSort = new SelectSort();
        Sort.rank(selectSort, source);

    }
}
