package com.company.chuan.graph;

public class KosarajuSCC {
    private int[] id;
    private int count;
    private boolean[] marked;
    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DeepFirstOrder dfo = new DeepFirstOrder(G)    ;
        for( int w : dfo.reversePost()) {
            if(!marked[w]) {
                dfs(G, w);
                count ++;
            }
        }
    }

    public void dfs(Digraph G, int v) {
        id[v] = count;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    int count() {
        return count;
    }

    int id(int v) {
        return id[v];
    }
}
