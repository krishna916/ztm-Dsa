package com.krishnamurti.ztmDataStructures.stacksAndQueues;

import com.krishnamurti.commons.Node;

public class SimpleQueue<V> {

    private Node<V> first;
    private Node<V> last;
    private int length;

    public SimpleQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public V peek() {
        if (!isEmpty()) {
            return this.first.getValue();
        }
        return null;
    }

    public void enqueue(V element) {
        Node<V> newNode = new Node<>(element);
        if (!isEmpty()) {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        if (isEmpty()) {
            this.first = newNode;
        }
        length++;
    }

    public V dequeue() {
        if (!isEmpty()) {
            Node<V> dequeued = this.first;
            this.first = dequeued.getNext();
            dequeued.setNext(null);
            length--;
            return dequeued.getValue();
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return this.length;
    }

    public void printList() {
        Node<V> current = this.first;
        System.out.print("FIRST -> ");
        while (current != null) {
            System.out.print(current.getValue());
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("LAST");
    }

    public boolean isEmpty() {
        return this.length <= 0;
    }
}
