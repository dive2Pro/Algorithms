package com.company.chuan.graph.shortest_path;

import com.company.chuan.Bag;
import com.company.chuan.graph.Digraph;

public class EdgeWeightDigraph extends Digraph {
    private int V;
    private int E;

    private Bag<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V) {
        super(V);
        this.V = V;
        this.E = 0;

        adj = new Bag[V];

        for(int i = 0 ; i < V; i ++) {
            adj[i] = new Bag<>();
        }

    }

    public int V() {
        return V;
    }

    int E() {
        return E;
    }

    void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable adj(int v) {
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
