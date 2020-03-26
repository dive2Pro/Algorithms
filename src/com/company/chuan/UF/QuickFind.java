package com.company.chuan.UF;

public class QuickFind extends UF{

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {

        int vp = find(p);
        int vq = find(q);

        if(vp == vq) return;

        // 将 p 的分量重命名为 q 的名称
        for(int i = 0; i < id.length; i ++) {
            if(id[i] == vp) id[i] = vq;
        }

        count --;
    }

    @Override
    public int find(int p) {
        return id[p];
    }
}
