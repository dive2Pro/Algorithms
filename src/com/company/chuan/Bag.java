package com.company.chuan;

import java.util.Iterator;

/**
 * 
 * 后进先出
 * 
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N = 0;
    private class Node {
        Item item;
        Node next;

        public Node (Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node(item, oldfirst);
        N ++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            current = current.next;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }


}