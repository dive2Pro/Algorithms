package com.company.chuan;


public class SortEntry {
    public static void main(String[] args) {
        Comparable[] source = new Integer[] {2, 1,1,2, 8, 6, 7, 0, 0, 4, 3, 9, 5};
        SelectSort selectSort = new SelectSort();
        SortExample.rank(selectSort, source);
        InsertSort insertSort = new InsertSort();
        SortExample.rank(insertSort, source);
        ShellSort shellSort = new ShellSort();
        SortExample.rank(shellSort, source);
        Merge mergeSort = new Merge();
        SortExample.rank(mergeSort, source);
        MergeBU mergeBU = new MergeBU();
        SortExample.rank(mergeBU, source);
//
        QuickSort quickSort = new QuickSort();
        SortExample.rank(quickSort, source);

        Quick3Way quick3Way = new Quick3Way();
        SortExample.rank(quick3Way, source);
    }
}
