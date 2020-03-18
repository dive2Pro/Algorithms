package com.company.chuan.graph;

import com.company.chuan.In;

import java.util.Stack;

public class Paths {

    private boolean[] marked;
    private int[] paths;
    private int s ;

    Paths(Graph G, int s) {
        this.s = s;
        paths = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        for(int w : G.adj(v)) {
            if(!marked[w]) {
                paths[w] = v;
                dfs(G, w);
            }
        }
    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = v ; i != s; i = paths[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Paths search = new Paths(G, s);
        for (int v = 0; v < G.V(); v++) {

        }

    }
}
