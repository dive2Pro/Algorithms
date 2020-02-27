package com.company.chuan;


public class SortEntry {
    public static void main(String[] args) {
        Comparable[] source = new Integer[] {2, 1, 8, 6, 7, 0, 4, 3, 9, 5};
        SelectSort selectSort = new SelectSort();
        SortExample.rank(selectSort, source);
        InsertSort insertSort = new InsertSort();
        SortExample.rank(insertSort, source);
        ShellSort shellSort = new ShellSort();
        SortExample.rank(shellSort, source);

    }
}
