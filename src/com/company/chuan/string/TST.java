package com.company.chuan.string;

import java.util.Stack;

public class TST<Value> extends StringST<Value> {

    char A = ".".charAt(0);

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

        if( d + 1 > key.length() ){
            return x;
        }

        char v = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.C = v;
//            d+=1;
//            put(x, key, val, d);
//            return x;
        }

        if (key.length() == d + 1) {
            x.val = val;
        }


        char current = x.C;
        if (current < v) {
            x.right = put(x.right, key, val, d);
        } else if (current > v) {
            x.left = put(x.left, key, val, d );
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
        return get(key) != null;
    }

    @Override
    boolean isEmpty() {
        return root == null;
    }

    @Override
    String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String key, int d, int length) {
        if(x == null) return length;
        if(x.val != null)  length = d + 1;
        int c = key.charAt(d);
        if(c > x.C) {
            return search(x.right, key, d , length);
        }  else if (c < x.C) {
            return search(x.left, key, d , length);
        } else if(key.length() > d + 1) {
            return search(x.mid, key, d + 1, length);
        }

        return length;
    }

    @Override
    Iterable<String> keysWithPrefix(String s) {
        return keysThatMatch(s);
    }

    @Override
    Stack<String> keysThatMatch(String s) {
        return collect(root, s, 0, new Stack<>());
    }

    @Override
    int size() {
        return keysThatMatch("").size();
    }

    @Override
    Iterable<String> keys() {
        return keysThatMatch("");
    }

    private Stack<String> collect(Node x, String key, int d, Stack<String> stack) {

        if(x == null) return stack;


        if(x.val != null ) {
            stack.add(String.valueOf(x.val));
        }

        if( key.equals("") || d >= key.length() ||  key.charAt(d) == A ) {
            collect(x.right, key, d, stack);
            collect(x.left, key, d, stack);
            collect(x.mid, key, d + 1, stack);
            return stack;
        }

        int c = key.charAt(d);
        if(x.C < c){
            collect(x.right, key, d, stack);
        } else if(x.C > c) {
            collect(x.left, key, d, stack);
        } else {
            collect(x.mid, key, d + 1, stack);
        }

        return stack;
    }

    public static void main(String[] args) {
        TST<String> trieST = new TST<>();
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

//        System.out.println(trieST.size());
//        System.out.println(trieST.keysWithPrefix("..e"));
//        System.out.println(trieST.keysWithPrefix("Dod"));
        System.out.println(trieST.longestPrefixOf("Shel"));
//        System.out.println(trieST.keys());

    }
}
