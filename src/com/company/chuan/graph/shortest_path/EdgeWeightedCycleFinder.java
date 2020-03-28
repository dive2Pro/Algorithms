package com.company.chuan.graph.shortest_path;

import java.util.Stack;

/**
 * 检查加权有向图中是否存在 **负权重环**
 *
 * 从 负权重的边开始 -> dfs 深度搜索 -> 回到 负权重的边
 *   如果总权重 < 0 , 则返回
 *                  否则进入下一轮
 *
 */
public class EdgeWeightedCycleFinder {

    private double weight;
    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<DirectedEdge> cycle;
    private DirectedEdge[] pathTo;

    public EdgeWeightedCycleFinder(EdgeWeightDigraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        pathTo = new DirectedEdge[G.V()];

        for(DirectedEdge e : G.edges()) {
            int v = e.from();
            if(e.weight() < 0 && !marked[v]) {
                weight = e.weight();
                dfs(G, v);
            }
        }
    }

    private void dfs(EdgeWeightDigraph G, int v) {
        marked[v] = true;
        for(Object obj : G.adj(v)) {
            DirectedEdge e = (DirectedEdge) obj;
            int w = e.to();
            if(!marked[w]) {
                pathTo[w] = e;
                edgeTo[w] = v;
                dfs(G, w);
            } else if(onStack[w]) {
                cycle = new Stack<>();
                double totalWeight = 0 ;
                for(int i = v ; i != w; i = edgeTo[i]) {
                    cycle.push(pathTo[i]);
                    totalWeight += pathTo[i].weight();
                }
                if(totalWeight >= 0) {
                    cycle = null;
                }
            }

        }
    }

    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }
}
