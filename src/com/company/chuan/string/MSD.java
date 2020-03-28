package com.company.chuan.string;


import com.company.chuan.InsertSort;

public class MSD {
    private static int M = 2; // 小数组的切换阈值
    private static int R = 256;
    private static String[] aux;
    private static InsertSort insertSort;

    public static int charAt(String a, int d) {
        if(d >= a.length()) {
            return -1;
        }

        return a.charAt(d);
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N]       ;
        insertSort = new InsertSort();
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {

        /**
         * 这个 M 必须是要
         */
        if( hi <= lo + M){
            insertSort.sort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];

        for(int i = 0 ; i < a.length; i ++) {
            count[ charAt(a[i], d) + 2 ] ++; // 这个 + 2 是为了处理 charAt 返回 -1, 就是字符串长度不相等会出现的情况
        }

        for(int i = 0 ; i < R + 1; i ++) {
            count[i + 1] +=  count[i];  // 索引
        }

        for(int i = lo ; i <= hi; i ++) {
            int x = count[charAt(a[i], d) + 1]++;
            aux[x]  = a[i];  // +1 是为了处理会出现的 -1
        }

        for(int i = lo ; i <= hi ; i ++) {
            a[i] = aux[i - lo]; // 注意, 从高位排序时, [0  lo] 这个区间已经排好了的
        }

        for(int r = 0 ; r < R; r ++) {
            sort(a, lo + count[r], lo + count[r+ 1] - 1, d + 1);
        }


    }

    public static void main(String[] args) {

        String[] strings = new String[]{"wqe","all", "bad", "bed", "bug", "dad", "yes", "yet", "zoo"};
        sort(strings);
        System.out.println(strings);
    }
}
