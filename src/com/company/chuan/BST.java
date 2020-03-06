package com.company.chuan;

public class BST<Key extends Comparable<Key>, Value> extends SortAbstract<Key, Value> {


    class Node {
        Node left;
        Node right;
        int N;
        private Key key;
        private Value value;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    @Override
    public Key min() {
        return min(root);
    }

    private Key min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.key;
        }
    }

    @Override
    public Key max() {
        return max(root);
    }

    private Key max(Node node) {
        if (node.right != null) {
            return max(node.left);
        } else {
            return node.key;
        }
    }

    @Override
    public Key floor(Key key) {

        return floor(root, key);
    }

    /**
     * 找到第一个小于 key 的节点, 找不到 返回 null
     * 怎么找?
     * <p>
     * key compareTo  node:
     * < 0 : floor(node.left)
     * > 0 :
     * node, 如果 floor(node.rightA) 返回有值, 返回 返回值
     * <p>
     * floor(node.right)
     *
     * @param node
     * @param key
     * @return
     */
    private Key floor(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);
        } else if (cmp > 0) {
            Key returned = floor(node.right, key);
            if (returned == null) {
                return node.key;
            }
            return returned;
        }
        return node.key;
    }


    @Override
    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    /**
     * > 0 : right 找比它大的
     * <p>
     * < 0 : left 是否还有比它大的
     */
    private Key ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return ceiling(node.right, key);
        } else if (cmp < 0) {
            Key returned = ceiling(node.left, key);
            if (returned == null) {
                return node.key;
            }
            return returned;

        }
        return node.key;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public static void main(String[] args) {
        String[] source = "SEARCHEXAMPLE".split("");
        BST<String, Integer> bst = new BST<>();
        for (int i = 0; i < source.length; i++) {
            bst.put(source[i], i);
        }
        concurrent(bst.floor("I"), "H");
        concurrent(bst.floor("G"), "E");
        concurrent(bst.floor("M"), "M");

        System.out.println("-----  -------");

        concurrent(bst.ceiling("M"), "M");
        concurrent(bst.ceiling("A"), "A");
        concurrent(bst.ceiling("Z"), null);
    }

    public static void concurrent(String s1, String s2) {
        if(s1 == null && s2 == null){
            return;
        }
        if (s1.compareTo(s2)!= 0) {
            throw new Error(s1 + " !== " + s2);
        }
    }

}
