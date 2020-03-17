package com.company.chuan.graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i, i);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;

        for (int x : G.adj(v)) {
            if (!marked[x]) {
                dfs(G, x, v);
            } else if (x != u) hasCycle = true;
        }
    }
}
