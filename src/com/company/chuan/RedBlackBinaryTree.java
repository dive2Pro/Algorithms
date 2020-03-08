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

    private class Node {
        Key key;
        Value val;
        boolean color;
        int N;
        Node left;
        Node right;
    }

    private boolean isRed(Node node) {
        if(node == null) return false;
        return node.color = RED;
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
}

