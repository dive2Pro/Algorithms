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
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node;
        }
    }

    @Override
    public Key max() {
        return max(root);
    }

    private Key max(Node node) {
        if (node.right != null) {
            return max(node.right);
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

    /**
     * 返回给定键的排名
     * @param key
     * @return
     */
    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if(node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if( cmp > 0) {
            return rank(node.right, key) + size(node.left) + 1;
        } else if( cmp < 0) {
            return rank(node.left, key);
        }
        return size(node.left);
    }

    private Node findBy(Node node, Key key) {
        if(node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if( cmp > 0) {
            return findBy(node.right, key);
        } else if( cmp < 0) {
            return findBy(node.left, key);
        }
        return node;
    }


    /**
     * 在树中正好有 k 个小于它的键
     *
     * @param k
     * @return
     */
    @Override
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if(node == null) {
            return node;
        }

        int n = size(node.left);

        if (n > k) {
            return select(node.left, k);
        } else if ( n < k) {
            return select(node.right, k - n - 1);
        }

        return node;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node.right != null) {
            if(node.right.right == null) {
                node.right = node.right.left;
            } else {
                deleteMin(node.right);
            }

        } else {
            node = node.left;
        }

        node.N = size(node.left)  + size(node.right) + 1;

        return node;

    }


    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {

        if(node.left != null) {
            if(node.left.left == null) {
                node.left = node.left.right;
            } else {
                deleteMin(node.left);
            }

        } else {
            node = node.right;
        }

        node.N = size(node.left)  + size(node.right) + 1;

        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete2(Node node, Key key) {
        // 1. 找到 child [left, right] 为node
        // 2. t = key;
        // 3. 找到右边最小的结点 x = min(t.right);
        // 4. 删除 t.right 结点上最小的点, 这个点就是 第三步的点 x; r = deleteMin(t.right)
        // 5. x.left = t.left
        // 6. x.right = r;
        // 7. node[left, right] = x;



        int cmp = key.compareTo(node.key);

        if( cmp > 0) {
            // 检查 parent.right 是否等于 key
            if(key.compareTo(node.right.key) == 0) {
                // 如果等于 就在这一层处理
                // 如果等于 就在这一层处理
                Node t = node.right;
                Node x = min(t.right);
                if(x == null) {
                    x = t.left;
                } else {
                    Node r = deleteMin(t.right);
                    x.left = t.left;
                    x.right = r;
                    x.N = size(x.left) + size(x.right) + 1;
                }
                node.left = x;
            } else {
                // 如果不等于 就在下一层处理
                delete(node.right, key);
            }

        } else if (cmp < 0) {
            if(key.compareTo(node.left.key) == 0) {
                // 如果等于 就在这一层处理
                Node t = node.left;
                Node x = min(t.right);
                if(x == null) {
                    x = t.left;
                } else {
                    Node r = deleteMin(t.right);
                    x.left = t.left;
                    x.right = r;
                    x.N = size(x.left) + size(x.right) + 1;
                }
                node.left = x;
            } else {
                // 如果不等于 就在下一层处理
                delete(node.left, key);
            }
        } else {
            node = node.right;
        }


        node.N = size(node.left)  + size(node.right) + 1;
        return node;
    }

    private Node delete(Node node, Key key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if(cmp > 0) {
            node.right = delete(node.right, key);
        } else if(cmp < 0) {
            node.left = delete(node.left, key);
        } else {
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.N = size(node.left) + size(node.right) + 1;

        // 这个返回要注意, 这一点让  node.left = delete(node.left, key) ; 是正确的
        return node;
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

        System.out.println("----- select -----");
        concurrent(bst.select(8), "S");
        concurrent(bst.select(3), "H");
        System.out.println("----- rank -----");

        concurrent(bst.rank("S"), 8);
        concurrent(bst.rank("H"), 3);

        System.out.println("----- deleteMin -----");
        bst.deleteMin();
        concurrent(bst.min(), "C");

        bst.deleteMin();
        concurrent(bst.min(), "E");
        bst.put("C", 3);
        bst.put("A", 9);

        System.out.println("----- deleteMax -----");
        concurrent(bst.max(), "X");

        System.out.println("----- delete(key) -----");
        bst.delete("E");

        concurrent(bst.max(), "X");
    }

    public static void concurrent(Comparable s1, Comparable s2) {
        if(s1 == null && s2 == null){
            return;
        }
        if (s1.compareTo(s2)!= 0) {
            throw new Error(s1 + " !== " + s2);
        }
    }

}
