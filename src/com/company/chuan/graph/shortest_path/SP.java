package com.company.chuan.graph.shortest_path;

import java.util.Stack;

public class SP {
    DirectedEdge[] edgeTo;
    double distTo[];
    SP(EdgeWeightDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for(int i = 0 ; i < G.V(); i ++) {
            edgeTo[i] = null;
            distTo[i] = Double.POSITIVE_INFINITY;
        }
    }

    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();

        for(DirectedEdge e = edgeTo[v]; e != null ; e = edgeTo[e.from()]) {
            path.add(e);
        }

        return path;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if(distTo[v] + e.weight() < distTo[w]) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    private void relax(EdgeWeightDigraph G, int v) {
        for( Object obj : G.adj(v)) {
            DirectedEdge e = (DirectedEdge) obj;
            int w = e.to();
            if(distTo[v] + e.weight() < distTo[w]) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }

        }
    }
}
