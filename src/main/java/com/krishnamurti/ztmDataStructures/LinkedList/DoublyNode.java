package com.krishnamurti.ztmDataStructures.LinkedList;

public class DoublyNode<V> {

    private V value;
    private DoublyNode<V> previous;
    private DoublyNode<V> next;

    public DoublyNode(V value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    public DoublyNode(V element, DoublyNode<V> previous, DoublyNode<V> next) {
        this.value = element;
        this.previous = previous;
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public DoublyNode<V> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode<V> previous) {
        this.previous = previous;
    }

    public DoublyNode<V> getNext() {
        return next;
    }

    public void setNext(DoublyNode<V> next) {
        this.next = next;
    }
}
