package com.company.chuan.graph.shortest_path;

import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost; // relax 的调用次数
    private Iterable<DirectedEdge> cycle;

    public BellmanFord(EdgeWeightDigraph G, int s) {
        distTo = new double[G.V()] ;
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new LinkedList<>();
        cost = 0;

        for(int i = 0 ; i < G.V(); i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        queue.add(s);
        onQ[s] = true;

        while(!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.remove();
            onQ[v] = false;
            relax(G, v);
        }

    }

    private boolean hasNegativeCycle() {
        return cycle != null;
    }

    private void relax(EdgeWeightDigraph G, int v) {
        for(Object o: G.adj(v)) {
           DirectedEdge e = (DirectedEdge) o;

           int w = e.to();

           if(distTo[w] > distTo[v] + e.weight()) {
               distTo[w] = distTo[v] + e.weight();
               edgeTo[w] = e;

               if(!onQ[w]) {
                   queue.add(w);
                   onQ[w] = true;
               }
           }

           if(cost ++ % G.V() == 0) {
               findNegativeCycle();
           }
        }
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightDigraph spt;
        spt = new EdgeWeightDigraph(V);

        for(int v = 0 ; v < V; v ++) {
            if(edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }

        EdgeWeightedCycleFinder cf;
        cf = new EdgeWeightedCycleFinder(spt);

        cycle = cf.cycle();
    }
}
