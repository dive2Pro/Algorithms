package com.company.chuan.graph.shortest_path;

import com.company.chuan.StdIn;

public class Arbitrage {

    public static void main(String[] args) {
        int V = StdIn.readInt();
        String[] name = new String[V];

        EdgeWeightDigraph G = new EdgeWeightDigraph(V);

        for(int v = 0 ; v < V ; v ++)  {
            name[v] = StdIn.readString();
            for(int w = 0 ; w < V ; w ++) {
                double rate = StdIn.readDouble();
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate)); // 自然对数, 取反
                G.addEdge(e);
            }
        }

        BellmanFord bf = new BellmanFord(G, 0);

        // 求得 负权重环
        if(bf.hasNegativeCycle()) {
            double stake = 1000.0;
            for(DirectedEdge e: bf.negativeCycle()) {
                // 汇兑
                System.out.println(name[e.from()]);
                stake *= Math.exp(-e.weight());
                System.out.println(name[e.to()]);
            }
        } else {
            System.out.println("No arbitrage opportunity");
        }

    }
}
