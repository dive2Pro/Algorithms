package com.company.chuan.graph;

import java.io.DataInputStream;
import java.io.IOException;

import com.company.chuan.Bag;

/**
 * 相邻 - 两个顶点通过一条边相连时, 称这两个顶点是相邻的
 * 
 * 顶点的度数 - 依附于它的边的总数
 * 
 * 路径 - u-v-w-x 环 - u-v-w-u
 */
public class Graph {
    private final int V;
    private int E;
    private final Bag<Integer>[] adj;

    public Graph(final int V) {
        this.V = V;
        adj = new Bag[V];
        for(int v = 0; v < V; v ++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(final DataInputStream in) throws IOException {
        this(in.readInt());
        final int E = in.readInt();
        for(int i = 0; i < E ; i ++) {
            addEdge(in.readInt(), in.readInt());
        }

    }

    /**
     * 
     * @return 定点数
     */
    int V() {
        return V;
    }

    /**
     * 
     * @return 边数
     */
    int E() {
        return E;
    }

    /**
     * 向图中添加一条边 v - w
     * 
     * @param v
     * @param w
     */
    void addEdge(final int v, final int w) {
        adj[v].add(w);
        adj[w].add(v);
        E ++;
    }

    /**
     * 
     * @param v
     * @return 和 v 相邻的所有顶点
     */
    Iterable<Integer> adj(final int v) {
        return adj[v];
    }

    /**
     * 对象的字符串表示
     */
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";

        for(int v = 0 ; v < V; v ++ ) {
            s += v + ": ";
            for( final int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * 计算 v 的度数
     * @param G
     * @param v
     * @return
     */
    public static int degree(final Graph G, final int v) {
        int degree = 0;
        for(final int w : G.adj(v)) degree ++;
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     * 
     * @param G
     * @return
     */
    public static int maxDegree(final Graph G) {
        int max = 0;
        for(int v = 0 ; v < G.V(); v ++) {
            if(degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * 
     * 计算所有顶点的平均度数
     * 
     */
    public static double avgDegree(final Graph G) {
        return 2 * G.E() / G.V();
    }

    /**
     * 计算自环的个数
     * 
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(final Graph G) {
        int count = 0;
        for( int v = 0; v < G.V(); v ++) {
            for(final int w : G.adj(v)) {
                if(w == v) count ++;
            }
        }

        return count / 2;
    }
}