package com.company.chuan.graph;

import java.util.Stack;

public class DirectedDFS {
    private boolean[] marked; // 检查 marked 中位置的
    private Stack<Integer> vs;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        vs = new Stack<>();
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for(int s : sources) {
            dfs(G, s);
        }
    }

    void dfs(Digraph G, int v) {
        marked[v] = true;

        for(int w : G.adj(v)) {
            if(!marked[w]) {
                vs.push(w);
                dfs(G, w);
            }
        }

    }

    boolean marked(int v) {
        return marked[v];
    }


}
