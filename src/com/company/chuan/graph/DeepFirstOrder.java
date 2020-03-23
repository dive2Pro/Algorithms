package com.company.chuan.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeepFirstOrder {
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    private boolean[] marked;
    public DeepFirstOrder(Digraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for(int i = 0 ; i < G.V(); i ++ ) {
            if(!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.add(v);

        for(int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
