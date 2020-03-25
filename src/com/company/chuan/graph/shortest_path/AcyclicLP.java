package com.company.chuan.graph.shortest_path;

import com.company.chuan.graph.Topological;

import java.util.Stack;

public class AcyclicLP {

    private double[] pathTo;
    private DirectedEdge[] edgeTo;

    public AcyclicLP(EdgeWeightDigraph G, int s)  {
        pathTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for(int i = 0 ; i < G.V(); i ++) {
            pathTo[i] = Double.POSITIVE_INFINITY;
        }
        pathTo[s] = 0.0;

        Topological tl = new Topological(G);
        for(int v: tl.sort()) {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightDigraph G, int v) {

        for(Object obj: G.adj(v)){
            DirectedEdge e = (DirectedEdge) obj;
            int w = e.to();

            if(pathTo[w] > pathTo[v] + e.weight()) {
                pathTo[w] = pathTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return pathTo[v];
    }

    public boolean hasPathTo(int v) {
        return pathTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if(!hasPathTo(v)) {
            return null;
        }

        Stack<DirectedEdge> path = new Stack<>();

        for(DirectedEdge s = edgeTo[v] ; s != null ; s =  edgeTo[s.from()]) {
            path.push(s);
        }

        return path;
    }
}
