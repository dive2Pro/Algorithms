package com.company.chuan;

public class SelectSort extends SortExample {

    /**
     * 第一轮比较选出最小的放在排头
     * 第二轮比较选出余下最小的放在第二的位置
     * ....
     *
     * @param a
     * @return
     */
    @Override
    public Comparable[] sort(Comparable[] source) {
//        Comparable[] source = a.clone();

        for(int i = 0; i < source.length - 1  ; i ++) {
            int min = i;
            for(int j = i + 1; j < source.length ; j ++ ) {
                if(source[j] != null && less(source[j], source[min])) {
                    min = j;
                }
            }
            exch(source, i, min);
        }
        return source;
    }
}
