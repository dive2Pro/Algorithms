package com.company.chuan.string;

public class TST<Value> extends StringST<Value> {
    class Node {
        char C;
        Node left;
        Node mid;
        Node right;
        Value val;
    }

    private Node root;

    @Override
    void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {

        char v = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.C = v;
        }

        if (key.length() == d) {
            x.val = val;
        }

        char next = key.charAt(d + 1);
        if (next > v) {
            x.right = put(x.right, key, val, d);
        } else if (next < v) {
            x.left = put(x.left, key, val, d);
        } else if(key.length() > d + 1) {
            x.mid = put(x.mid, key, val, d + 1);
        }

        return x;
    }

    @Override
    Value get(String key) {

        return get(root, key, 0);
    }

    private Value get(Node x, String key, int d) {
        if (x == null) return null;
        char v = key.charAt(d);
        if (x.C == v && key.length() > d + 1) {
            return get(x.mid, key, d + 1);
        } else if (x.C > v) {
            return get(x.right, key, d);
        } else {
            return get(x.left, key, d);
        }
    }

    @Override
    boolean contains(String key) {
        return false;
    }

    @Override
    boolean isEmpty() {
        return false;
    }

    @Override
    String longestPrefixOf(String s) {
        return null;
    }

    @Override
    Iterable<String> keysWithPrefix(String s) {
        return null;
    }

    @Override
    Iterable<String> keysThatMatch(String s) {
        return null;
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    Iterable<String> keys() {
        return null;
    }
}
