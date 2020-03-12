package com.company.chuan;


/**
 * 红黑二叉树
 *  1. 红键由两个 2- 节点组成
 *  2. 任意键只能和一个红键相连
 *  3. 任意空节点到根节点的距离上的黑键数量相等
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBinaryTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        boolean color;
        int N;
        Node left;
        Node right;

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = 0;
        }
    }

    private boolean isRed(Node node) {
        if(node == null) return false;
        return node.color == RED;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if(node == null) {
            return new Node(key, value, RED);
        }

        int cmp = key.compareTo(node.key);
        if(cmp > 0) {
            node.right = put(node.right, key , value);
        } else if(cmp < 0) {
            node.left = put(node.left, key , value);
        } else {
            node.val = value;
        }

        if(isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        } 
        if(isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }  
        if(isRed(node.left) && isRed(node.right)){
            node = colorFlip(node);
        }
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    Node colorFlip(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
        return h;
    }


    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);

        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public static void main(String[] main) {
        RedBlackBinaryTree<String, String> blackBinaryTree = new RedBlackBinaryTree<>();
        String[] source = "SEARCHEXAMPLE".split("");

        for(int i = 0 ; i < source.length; i ++) {
            blackBinaryTree.put(source[i], source[i]);
        }

        if(!blackBinaryTree.root.key.equals("M")) {
            System.out.println("ahahah");
        }
    }
}

