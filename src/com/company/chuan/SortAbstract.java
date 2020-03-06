
package com.company.chuan;

public abstract class SortAbstract<Key extends Comparable<Key>, Value> implements SortInterface<Key, Value> {

    class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    
    }
    public void delete(Key key) {
        put(key, null);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key)  != null;
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public int size(Key lo, Key hi) {
        if(hi.compareTo(lo) < 0) {
            return 0;
        } else if(contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    public int size() {
        return size(min(), max());
    }
    
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
}