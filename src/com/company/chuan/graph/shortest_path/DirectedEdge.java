package com.company.chuan.graph.shortest_path;

public class DirectedEdge implements Comparable<DirectedEdge> {
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

    @Override
    public int compareTo(DirectedEdge directedEdge) {
       if( weight() > directedEdge.weight()) {
           return 1;
       } else if(weight() < directedEdge.weight()){
           return -1;
       }

       return 0;
    }
}
