package com.company.chuan.graph;

import com.company.chuan.Bag;

import java.util.Stack;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for(int i = 0 ; i < V; i ++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E ++ ;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /**
     *
     * @return 无向图中的所有边
     */
    public Iterable<Edge> edges() {
        Stack<Edge> edges = new Stack<>();

        for(int i = 0 ; i < V; i ++) {
            for(Edge e : adj[i]) {
                if(i < e.other(i)) {
                    edges.push(e);
                }
            }
        }

        return edges;
    }

    public int V() {
        return V;
    }
}
