package com.company.chuan.string;

import java.util.Stack;

public class TrieST<Value> extends StringST<Value> {
    private static int R = 256;
    private static int OMIT = ".".charAt(0);
    private Node root;

    static class Node {
        Node[] next;
        Object val;

        public Node() {
            next = new Node[R];

        }
    }

    public TrieST() {

    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {

        if (x == null) x = new Node();

        if (d == key.length()) {
            x.val = val;
            return x;
        }

        int c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);

        return x;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;

        return (Value) x.val;
    }


    private Node get(Node x, String key, int d) {
        if (x == null) return x;

        if (key.length() == d) {
            return x;
        }

        char c = key.charAt(d);

        x = get(x.next[c], key, d + 1);


        return x;
    }

    @Override
    boolean contains(String key) {
        return false;
    }

    @Override
    boolean isEmpty() {
        return root == null;
    }

    @Override
    String longestPrefixOf(String s) {
        return collect(root, s, 0, s.length() - 1).pop();
    }

    @Override
    Iterable<String> keysWithPrefix(String s) {
        return keysThatMatch(s);
    }

    @Override
    Iterable<String> keysThatMatch(String s) {
        return keysThatMatch(s, s.length());
    }

    private Stack<String> keysThatMatch(String s, int size) {
        return collect(root, s, 0, Integer.MAX_VALUE);
    }

    @Override
    int size() {
        if (isEmpty()) {
            return 0;
        }

        return collect(root, "", 0, Integer.MAX_VALUE).size();
    }


    @Override
    Iterable<String> keys() {
        return keysWithPrefix("");
    }

    private Stack<String> collect(Node x, String key, int d, int max) {
        return collect(x, key, d, new Stack<>(), max);
    }

    private Stack<String> collect(Node x, String key, int d, Stack<String> stack, int max) {
        if(d > max) {
            return stack;
        }
        for (int i = 0; i < x.next.length; i++) {
            Node n = x.next[i];
            if (n == null) {
                continue;
            }

            if (!key.equals("")) {
                if (key.length() > d) {
                    int v = key.charAt(d);
                    if (v != OMIT && v != i) {
                        continue;
                    }
                }
            }

            if (n.val != null) {
                stack.push((String) n.val);
            }


            collect(n, key, d + 1, stack, max);
        }
        return stack;
    }


    public static void main(String[] args) {
        TrieST<String> trieST = new TrieST<>();
        String[] strings = new String[]{
                "She",
                "Shell",
                "Sea",
                "Dota",
                "Doddle",
                "Axe"
        };

        for (String s : strings) {
            trieST.put(s, s);
        }

//       System.out.println(trieST.size());
//        System.out.println(trieST.keysWithPrefix("..e"));
//        System.out.println(trieST.keysWithPrefix("Dod"));
        System.out.println(trieST.longestPrefixOf("Shel"));

    }
}
