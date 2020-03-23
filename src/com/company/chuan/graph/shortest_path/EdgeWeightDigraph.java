package com.company.chuan.graph.shortest_path;

import com.company.chuan.Bag;

public class EdgeWeightDigraph {
    private int V;
    private int E;

    private Bag<DirectedEdge>[] adj;

    EdgeWeightDigraph(int V) {
        this.V = V;
        this.E = 0;

        adj = new Bag[V];

        for(int i = 0 ; i < V; i ++) {
            adj[i] = new Bag<>();
        }

    }

    int V() {
        return V;
    }

    int E() {
        return E;
    }

    void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    Iterable<DirectedEdge> adj(int v) {
        return adj[v]       ;
    }

    Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();

        for(int v =0; v < V; v ++) {
            for(DirectedEdge e: adj[v]) {
                bag.add(e);
            }
        }

        return bag;
    }

}
