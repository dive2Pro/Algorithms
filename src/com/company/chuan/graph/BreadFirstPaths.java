package com.company.chuan.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 广度优先算法
 *
 */
public class BreadFirstPaths {

    private boolean[] marked;
    private int[] paths;
    private int count; // 可连接子图的数量
    private int s ; // 起点
    private Graph G;
    private int[] es;

    public BreadFirstPaths(Graph G, int v) {
        this.G = G;
        this.s = v;
        this.marked = new boolean[G.V()];
        this.paths = new int[G.V()];
        this.count = 0;
        this.es = new int[G.V()];
        bfs(G, v);
    }

    private void bfs(Graph G, int v) {
        LinkedList<Integer> queue  = new LinkedList<>();
        queue.add(v);
        marked[v] = true;
        count ++ ;
        while (!queue.isEmpty()) {
            int last = queue.removeLast();
            Iterable<Integer> integers = G.adj(last);
            for(int i : integers) {
                if(!marked[i]) {
                    paths[i] = last;
                    queue.add(i);
                    marked[i] = true;
                    count ++ ;
                }
            }
        }

    }

    public boolean hasPathTo(int v) {
        return marked[v];
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
