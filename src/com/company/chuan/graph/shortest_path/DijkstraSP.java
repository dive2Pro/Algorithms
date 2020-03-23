package com.company.chuan.graph.shortest_path;

import com.company.chuan.IndexMinPQ;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    private double[] distTo;

    public DijkstraSP(EdgeWeightDigraph G, int s) {
        distTo = new double[G.V()];
        pq = new IndexMinPQ(G.V());
        edgeTo = new DirectedEdge[G.V()];

        for(int i = 0 ; i < G.V() ; i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        while(!pq.isEmpty()) {
            relax(G, pq.minIndex());
            pq.delMin();
        }
    }

    private void relax(EdgeWeightDigraph G, int v) {
        for(DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if( distTo[w] > distTo[v] + e.weight() ) {
                distTo[w] = distTo[v] +e.weight();
                edgeTo[w] = e;
                if(pq.contains(w)) {
                    pq.change(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }
        }
    }
}
