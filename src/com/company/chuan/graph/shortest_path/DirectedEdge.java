package com.company.chuan.graph.shortest_path;

public class DirectedEdge {
    private double weight;
    private int v;
    private int w;

    DirectedEdge(int v, int w, double weight) {

        this.v = v;
        this.w = w;
        this.weight = weight;

    }

    double weight() {
        return weight;
    }

    int from() {
        return v;
    }

    int to() {
        return w;
    }

}
