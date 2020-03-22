package com.company.chuan.graph;

public class Edge implements Comparable<Edge> {

    private double weight;
    private int v;
    private int w;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if( v == vertex) {
            return w;
        } else if( w == vertex) {
            return v;
        }
        throw new RuntimeException(" Inconsistent edge ");
    }

    @Override
    public int compareTo(Edge e) {
        if(weight() > e.weight()) {
            return 1;
        } else if( weight() < e.weight()) {
            return -1 ;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, v, w);
    }
}
