package com.company.chuan;


import java.util.ArrayList;

/**
 * 无序链表
 */
public class SequentialSearchST extends SortAbstract<String, Integer> {
    private Node first;

    @Override
    public void put(String key, Integer value) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                x.val = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public Integer get(String key) {
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
    public String min() {
        Node min = null;
        for( Node x = first; x != null ; x = x.next) {
            if(min == null) {
                min = x;
            } else {
                if(min.val > x.val) {
                    min = x;
                }
            }
        }
        return min.key;
    }

    @Override
    public String max() {
        Node max = null;
        for( Node x = first; x != null ; x = x.next) {
            if(max == null) {
                max = x;
            } else {
                if(max.val < x.val) {
                    max = x;
                }
            }
        }
        return max.key;
    }

    @Override
    public String floor(String key) {

        return null;
    }

    @Override
    public String ceiling(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int rank(String key) {
        int max = get(key);
        int count = 0;
        for( Node x = first; x != null ; x = x.next ) {
            if(key.equals(x.key)) {
                continue;
            } else if(x.val <= max) {
                count ++;
            }
        }
        return count;
    }

    @Override
    public String select(int k) {


        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<String> keys(String k1, String k2) {
        String next = "";
        ArrayList<String> keys = new ArrayList<>();
        for( Node x = first; x != null ; x = x.next) {
            if(next != "") {
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


}