package com.company.chuan.string;

public class Quick3string {
    public static int charAt(String s , int d) {
        if(s.length() < d) {
            return s.charAt(d);
        }

        return -1;
    }

    public static void sort(String[] strings) {
        sort(strings, 0 , strings.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if(hi <= lo) return;

        int lt = lo, gt = hi;

        /*  快排开始 */
        int v = charAt(a[lo], d); // 最高位在表(ASCII)中的值 , pivot 的值

        int i = lo + 1; //
        while( i <= gt ) { // 在 (lo, hi] 这个区间中
            int t = charAt(a[i], d);

            if(t < v) {
                exch(a, lt ++, i ++);
            } else if (t > v) {
                exch(a, i, gt --);
            } else {
                i ++;
            }
        }

        sort(a, lo, lt - 1, d);
        if( v >= 0 ) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);

    }

    private static void exch(String[] a, int i , int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
