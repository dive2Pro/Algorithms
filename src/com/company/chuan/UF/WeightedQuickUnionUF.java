package com.company.chuan.UF;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;

        id = new int[N];
        sz = new int[N];

        for(int i = 0; i < N; i ++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int q) {
        if(q != id[q]) q = id[q];
        return q;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        if(sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        }
        count --;
    }
}
