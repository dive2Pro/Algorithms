package com.company.chuan.graph;

import com.company.chuan.IndexMinPQ;

public class PrimMST {
    private Edge[] edgeTo; // 距离树最近的边
    private double[] distTo; // distTo[w] = edgeTo[w].weight();
    private boolean[] marked;  // 如果 v 在树中则为 true
    private IndexMinPQ<Double> pq; // 有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];

        for(int v = 0 ; v < G.V(); v ++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;

        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for(Edge e: G.adj(v)) {
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.weight() < distTo[w]) {
                edgeTo[w]= e;

                distTo[w] = e.weight();
                if(pq.contains(w)) pq.change(w, distTo[w]);
                else               pq.insert(w, distTo[w]);
            }
        }
    }


}
