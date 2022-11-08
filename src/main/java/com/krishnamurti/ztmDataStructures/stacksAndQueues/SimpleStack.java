package com.krishnamurti.ztmDataStructures.stacksAndQueues;

import com.krishnamurti.commons.Node;

public class SimpleStack<V> {

    private Node<V> top;
    private Node<V> bottom;
    private int length;

    public SimpleStack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public V peek() {
        if (this.length > 0)
            return this.top.getValue();
        return null;
    }

    public void push(V element) {
        Node<V> newNode = new Node<>(element, this.top);
        if (this.bottom == null)
            this.bottom = newNode;
        this.top = newNode;
        this.length++;
    }

    public V pop() {
        if (this.top != null) {
            Node<V> popped = this.top;
            this.top = popped.getNext();
            popped.setNext(null);
            if (this.length == 1) {
                this.bottom = null;
            }
            this.length--;
            return popped.getValue();
        }
        return null;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void printStack() {
        Node<V> current = this.top;
        System.out.print("TOP -> ");
        while (current != null) {
            System.out.print(current.getValue());
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("BOTTOM");
    }

}
