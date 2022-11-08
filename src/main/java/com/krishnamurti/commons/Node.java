package com.krishnamurti.commons;

public class Node<V> {

    private V value;
    private Node<V> next;


    public Node(V value) {
        this.value = value;
        this.next = null;
    }

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> next) {
        this.next = next;
    }
}
