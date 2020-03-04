package com.company.chuan;

public class StackSort extends SortExample {

    void sink(Comparable[] a, int k , int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if(j + 1 <= N && less(a[j], a[j+1])) j ++;
            if(!less(a[k], a[j]) ) break;
            exch(a, j, k);
            k = j;
        }
    }


    @Override
    public Comparable[] sort(Comparable[] a) {

        int N = a.length - 1;

        for(int k = N / 2; k > 0 ; k --) {
            sink(a, k, N );
        }

        while(N > 0) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }

        return a;
    }
}
