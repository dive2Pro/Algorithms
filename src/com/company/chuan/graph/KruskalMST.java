package com.company.chuan.graph;

import com.company.chuan.IndexMinPQ;
import com.company.chuan.UF.QuickUnion;
import com.company.chuan.UF.UF;

import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst;
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        IndexMinPQ<Edge> pq = new IndexMinPQ<>(G.V());

        UF uf = new QuickUnion(G.V());

        while(!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge min = pq.min();
            pq.delMin();

            int v = min.either(), w = min.other(v);

            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.add(min);
        }

    }

    public Iterable<Edge> edges() {
        return mst;
    }

}
