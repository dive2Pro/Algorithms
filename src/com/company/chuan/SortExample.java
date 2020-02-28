package com.company.chuan;

public abstract class SortExample {
    public static void rank(SortExample sortInstance, Comparable[] a) {

        System.out.println("-------------- " + sortInstance.getClass().getName() + " ------------ ");
        Comparable[] sorted = sortInstance.sort(a);
        assert sortInstance.isSorted(sorted);
        sortInstance.show(sorted);
        System.out.println("-------------- " + sortInstance.getClass().getName() + " END ------------ ");
    }

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
}
