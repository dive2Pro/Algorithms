package com.company.chuan.graph;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import com.company.chuan.In;
import com.company.chuan.StdOut;

public class TestSearch {
    public static void main(String[] args) throws IOException {
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        Graph G = new Graph(in);

        Search search = new Search(G, s);

        for(int v = 0; v < G.V(); v ++) {
            if(search.marked(v)) {
                StdOut.print(v + " ");
            }
        }
         StdOut.println();

         // 当且仅当 搜索能够标记图中所有的 vertex 时, 图才是连通的;
         if(search.count() != G.V()) {
             StdOut.print("NOT ");
         }
         StdOut.println("connected");
         in.close();
    }
}