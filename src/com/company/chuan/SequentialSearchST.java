package com.company.chuan;


import java.util.ArrayList;

/**
 * 无序链表
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> extends SortAbstract<Key, Value> {
    private Node first;

    @Override
    public void put(Key key, Value value) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                x.val = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public Value get(Key key) {
        for( Node x = first; x != null ; x = x.next) {
            if(key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }


    public int size(String k1, String k2) {
        String next = "";
        int count  = 0;
        for( Node x = first; x != null ; x = x.next) {
            if(next != "") {
                count ++;
                if(next.equals(x.key)) {
                    break;
                }
                continue;
            } 
            if(k1.equals(x.key)) {
                next = k2;
            } else if(k2.equals(x.key)) {
                next = k1;
            }
        }
        return count;
    }

    @Override
    public Key min() {
        Node min = null;
        for( Node x = first; x != null ; x = x.next) {
            if(min == null) {
                min = x;
            } else {
                if(first.key.compareTo(min.key) < 0) {
                    min = x;
                }
            }
        }
        return min.key;
    }

    @Override
    public Key max() {
        Node max = null;
        for( Node x = first; x != null ; x = x.next) {
            if(max == null) {
                max = x;
            } else {
                if(x.key.compareTo(max.key) > 0) {
                    max = x;
                }
            }
        }
        return max.key;
    }

    @Override
    public Key floor(Key key) {

        return null;
    }

    @Override
    public Key ceiling(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int rank(Key key) {
        Value max = get(key);
        int count = 0;
        for( Node x = first; x != null ; x = x.next ) {
            if(key.equals(x.key)) {
                continue;
            } else if(x.key == max) {
                count ++;
            }
        }
        return count;
    }

    @Override
    public Iterable<Key> keys(Key k1, Key k2) {
        Key next = null;
        ArrayList<Key> keys = new ArrayList<>();
        for( Node x = first; x != null ; x = x.next) {
            if(null != next) {
                keys.add(x.key);
                if(next.equals(x.key)) {
                    break;
                }
                continue;
            }
            if(k1.equals(x.key)) {
                next = k2;
            } else if(k2.equals(x.key)) {
                next = k1;
            }
        }
        return keys;
    }

    @Override
    public Key select(int k) {
        // TODO Auto-generated method stub
        return null;
    }


}