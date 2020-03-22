package com.company.chuan.graph;

import java.util.Stack;

/**
 *
 * 找到有向图上的环
 *              环可能是指数级别的数量
 *              所以只需要找到一个环证明是有环的图即可
 *
 */
public class DirectedCycle {
    private boolean[] marked;
    private Stack<Integer> cycle;
    private boolean[] onStack;
    private int[] edgeTo;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for(int s = 0 ; s < G.V(); s ++) {
            if(!marked[s]) {
                dfs(G, s);
            }
        }
    }

    /**
     *       0 -> 5 -> 4 -> 3 -> 5
     *
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for(int w: G.adj(v)) {
            if(hasCycle()) return;
            if(!marked[w]) {
                edgeTo[w] = v; // 要记得这是深度优先, 所以 当 edgeTo[5] = 0; 当 v 位 4 时， edgeTo[3] = 4
                               // 当 v 为 3 时, 此时 w 为 5, 转进到 else 分支上
                dfs(G, w);
            } else if(onStack[w]) {
                cycle = new Stack<>();
                for(int i = v ; i != w; i = edgeTo[i]) {
                    cycle.push(i); // [3], [4, 3]
                }
                cycle.push(w); // [5, 4, 3]
                cycle.push(v); // [3, 5, 4, 3]
            }
        }
        onStack[v] = false;
    }

    private boolean hasCycle() {
        return cycle != null;
    }

    public Stack<Integer> cycle() {
        return cycle;
    }
}
