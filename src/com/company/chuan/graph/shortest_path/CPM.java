package com.company.chuan.graph.shortest_path;

import com.company.chuan.StdIn;

public class CPM {
    public static void main(String[] args) {
        int N = StdIn.readInt(); // 任务数
        StdIn.readLine();
        EdgeWeightDigraph G;
        G = new EdgeWeightDigraph(2 * N + 2); // 为每个任务树设置 一个 起始和结束 节点, 2 为 起点 + 终点
        int s = 2 * N, t = s + 1;

        for( int i = 0 ; i < N ; i ++) {
            String[] a = StdIn.readLine().split("\\s+"); // 以 空白符 分割
            double duration = Double.parseDouble(a[0]);

            G.addEdge(new DirectedEdge(i, i + N, duration)); // 添加 任务树的有向边
            G.addEdge(new DirectedEdge(s, i, 0.0)); // 起点到 任务的起始节点, 权重为 0 的边
            G.addEdge(new DirectedEdge(i + N, t, 0.0)); // 任务的结束节点到 终点, 权重为 0 的边

            // 添加限制条件: 每个任务必须在这些任务之前完成
            for(int j = 1; j < a.length ; j ++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i + N , successor, 0.0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s); // 拓扑五环加权有向图算法
        for(int i = 0 ; i < N ; i ++) {
            double time = lp.distTo(i); //  任务的 开始时间
        }

        double totalTime = lp.distTo(t); // 完成时间

    }
}
