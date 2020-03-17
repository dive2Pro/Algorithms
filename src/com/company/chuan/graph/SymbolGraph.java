package com.company.chuan.graph;

import com.company.chuan.In;

import java.util.HashMap;

/**
 *
 * 建立 符号名 和 索引 的互相转换
 *
 */
public class SymbolGraph {
    private HashMap<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {

        st = new HashMap<>();
        In in = new In(stream);
        while(in.hasNextChar()) {
            String[] a = in.readLine().split(sp);

            for(int i = 0; i < a.length; i ++) {
                if(!st.containsKey(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }


        keys = new String[st.size()];

        for(String name : st.keySet()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());

        in = new In(stream);

        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for(int i = 0 ; i < a.length  ; i = i + 1) {
                G.addEdge(v, st.get(a[i]));
            }
        }

    }
}
