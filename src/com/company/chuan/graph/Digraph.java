package com.company.chuan.graph;

import com.company.chuan.Bag;

public class Digraph {

    private final int V;

    private Bag<Integer>[] adj; // 顶点 是

    public Digraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for(int i = 0 ; i < V ; i ++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge( int v1, int v2) {
        adj[v1].add(v2);
    }

    public Iterable<Integer> adj(int v1 ) {
        return adj[v1];
    }

    public Digraph reserve() {
        Digraph digraph = new Digraph(V);

        for(int i = 0 ; i < adj.length; i ++) {
            Bag<Integer> W = adj[i];
            for(int w : W) {
                digraph.addEdge(w, i);
            }
        }

        return digraph;
    }

    public int V() {
        return V;
    }

}
