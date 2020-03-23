package com.company.chuan.graph;

public class Topological {
    private Iterable<Integer> sort;
    public Topological(Digraph G) {
        DirectedCycle dc = new DirectedCycle(G);
        if(!dc.hasCycle()) {
            DeepFirstOrder dfo = new DeepFirstOrder(G);
            sort = dfo.reversePost();
        }
    }
    public boolean isDAG() {
        return sort != null;
    }

    public Iterable<Integer> sort() {
        return sort;
    }
}
