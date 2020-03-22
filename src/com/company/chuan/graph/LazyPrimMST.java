package com.company.chuan.graph;

import com.company.chuan.IndexMinPQ;

import java.util.LinkedList;

public class LazyPrimMST {
    private boolean marked[];
    private LinkedList<Edge> mst;
    private IndexMinPQ<Edge> pq; // 横切边

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new IndexMinPQ<>(G.V());
        marked = new boolean[G.V()];
        mst = new LinkedList<>();

        visit(G, 0);
        while (!pq.isEmpty()) {

            Edge e = pq.min();
            pq.delMin();
            int v = e.either(), w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);


        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for(Edge e : G.adj(v) ) {
            if(!marked[e.other(v)]) {
                pq.insert(e.other(v), e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }


}
