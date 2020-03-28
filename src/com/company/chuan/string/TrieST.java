package com.company.chuan.string;

import java.util.Stack;

public class TrieST<Value> extends StringST<Value> {
    private static int R = 256;
    private static int OMIT = ".".charAt(0);
    private Node root;
    private Alphabet alphabet;

    static class Node {
        Node[] next;
        Object val;

        public Node() {
            next = new Node[R];
        }
    }

    public TrieST(Alphabet alphabet) {
        this.alphabet = alphabet;
        R = alphabet.R();
        OMIT = alphabet.toIndex('.');

    }

    public void put(String key, Value val) {
        int[] keys = alphabet.toIndices(key);
        root = put(root, keys, val, 0);
    }

    private Node put(Node x, int[] key, Value val, int d) {

        if (x == null) x = new Node();

        if (d == key.length) {
            x.val = val;
            return x;
        }

        int c = key[d];
        x.next[c] = put(x.next[c], key, val, d + 1);

        return x;
    }

    public Value get(String key) {
        int[] keys = alphabet.toIndices(key);
        Node x = get(root, keys, 0);
        if (x == null) return null;
        return (Value) x.val;
    }


    private Node get(Node x, int[] key, int d) {
        if (x == null) return x;

        if (key.length == d) {
            return x;
        }

        int c = key[d];

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
        int[] keys = alphabet.toIndices(s);
        int d = search(root, keys, 0, 0);
        return s.substring(0, d);
    }

    @Override
    Iterable<String> keysWithPrefix(String s) {
        return keysThatMatch(s);
    }

    @Override
    Iterable<String> keysThatMatch(String s) {
        return collect(root, s, 0);
    }

    @Override
    int size() {
        if (isEmpty()) {
            return 0;
        }

        return collect(root, "", 0).size();
    }


    @Override
    Iterable<String> keys() {
        return keysWithPrefix("");
    }

    private Stack<String> collect(Node x, String key, int d) {
        int[] keys = alphabet.toIndices(key);
        return collect(x, keys, d, new Stack<>());
    }

    private Stack<String> collect(Node x, int[] key, int d, Stack<String> stack) {
        for (int i = 0; i < alphabet.R(); i++) {
            int c = alphabet.toChar(i);

            Node n = x.next[i];
            if (n == null) {
                continue;
            }

            if (key.length > 0) {
                if (key.length > d) {
                    int v = key[d];
                    if (v != OMIT && v != i) {
                        continue;
                    }
                }
            }


            if (n.val != null) {
                stack.push((String) n.val);
            }


            collect(n, key, d + 1, stack);
        }
        return stack;
    }

    /**
     * 思路是: length 只在 x.val 有值时被修改
     * search 会逐个根据字符串的位置进行检索,方向是固定的
     */
    private int search(Node x, int[] s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == s.length) return length;
        int c = s[d];
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String s, int d) {

        if (x == null) return null;


        if (x.val != null && d == s.length()) {
            // 完全匹配时删除这个
            x.val = null;
        } else {
            int c = s.charAt(d);
            x.next[c] = delete(x.next[c], s, d + 1);
        }

        for (int i = 0; i < R; i++) {
            if (x.next[i] != null) return x;
        }

        return null;
    }


    public static void main(String[] args) {
        TrieST<String> trieST = new TrieST<>(new Alphabet(Alphabet.BASE64));
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

        System.out.println(trieST.size());
        System.out.println(trieST.keysWithPrefix("..e"));
        System.out.println(trieST.keysWithPrefix("Dod"));
        System.out.println(trieST.longestPrefixOf("Shel"));

    }
}
