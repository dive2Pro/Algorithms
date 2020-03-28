package com.company.chuan.string;

public class LSD {
    /**
     * @param a
     * @param w
     */
    public static void sort(String[] a, int w) {
        String[] aux = new String[a.length];

        int R = 256;
        int N = a.length;


        for (int i = w - 1; i >= 0; i--) {

            int[] count = new int[R + 1];
            for (int j = 0; j < N; j++) {
                count[a[j].charAt(i) + 1]++;
            }

            for (int j = 0; j < R; j++) {
                count[j + 1] += count[j];
            }

            for (int j = 0; j < N; j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            for(int k = 0 ; k < N ; k ++) {
                a[k] = aux[k];
            }
        }

    }

    public static void main(String[] args) {
        String[] strings = new String[]{"wqe","all", "bad", "bed", "bug", "dad", "yes", "yet", "zoo"};
        sort(strings, 3);
        System.out.println(strings);
    }
}
