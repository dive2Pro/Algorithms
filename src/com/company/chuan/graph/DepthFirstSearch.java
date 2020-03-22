package com.company.chuan.graph;

/**
 *
 * 深度优先查询
 *
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    /**
     * 查询以 v 为出发点的串联的顶点
     *
     * @param G 图
     * @param v 顶点
     */
    public DepthFirstSearch(Graph G, int v) {
        marked = new boolean[v];
        count = 0;
        dfs(G, v);
    }

    private void dfs(Graph G, int v) {
        count ++ ;
        marked[v] = true;

        for(int w : G.adj(v)) {
            if(!marked[w]) dfs(G, w);
        }
    }

    private int count() {
        return count;
    }

    private boolean marked(int w) {
        return marked[w];
    }

}
