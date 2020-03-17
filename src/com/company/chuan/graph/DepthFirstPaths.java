package com.company.chuan.graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] paths;
    private int count; // 可连接子图的数量
    private int s ; // 起点
    private Graph G;

    public DepthFirstPaths(Graph G, int v) {
        this.G = G;
        this.s = v;
        this.marked = new boolean[G.V()];
        this.paths = new int[G.V()];
        this.count = 0;
        dfs(G, v);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count ++;

        for(int w : G.adj(v)) {
            if(!marked[w]) {
                paths[w] = v; //  记录 w 的 父节点 , 串构成一个 path
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v] == true;
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();

        for(int i = v; i != s; i = paths[i]) {
            path.push(i);
        }

        path.push(s);

        return path;
    }
}
