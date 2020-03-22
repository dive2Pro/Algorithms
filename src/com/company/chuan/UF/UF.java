package com.company.chuan.UF;


public abstract class UF {
    protected int[] id;
    protected int count;
    public UF(int N) {
        count = N;

        id = new int[N];

        for(int i = 0 ; i < N ; i ++) {
            id[i] = i;
        }
    }

    abstract void union(int p, int q) ;

    abstract int find(int p);

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }

}

