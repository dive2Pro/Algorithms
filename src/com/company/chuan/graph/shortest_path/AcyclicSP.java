package com.company.chuan.graph.shortest_path;

import com.company.chuan.graph.Topological;

public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for(int i = 0 ; i < G.V() ; i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        Topological tp = new Topological(G);
        for(int v : tp.sort() ) {
            relax(G, v);
        }
    }
    public void relax(EdgeWeightDigraph G, int v) {
        for(Object obj: G.adj(v)) {
            DirectedEdge e = (DirectedEdge)obj;
            int w = e.to();
            if(distTo[v] +e.weight() < distTo[w]) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
