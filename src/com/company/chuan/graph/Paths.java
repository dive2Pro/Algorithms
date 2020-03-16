package com.company.chuan.graph;

import com.company.chuan.In;

public class Paths {
    Paths(Graph G, int s) {
    }

    boolean hasPathTo(int v){
        return false;
    }

    Iterable<Integer> pathTo(int v) {
        return [];
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Paths search = new Paths(G, s);

        for(int v = 0; v < G.V(); v ++) {

        }

    }
}
