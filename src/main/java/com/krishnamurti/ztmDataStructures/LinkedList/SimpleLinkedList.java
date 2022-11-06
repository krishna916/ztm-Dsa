package com.krishnamurti.ztmDataStructures.LinkedList;

public class SimpleLinkedList<V> {

    private Node<V> head;
    private Node<V> tail;
    private int length;

    public SimpleLinkedList() {
    }


    public SimpleLinkedList(V firstElement) {
        this.head = new Node<>(firstElement);
        this.tail = this.head;
        this.length = 1;
    }

    public boolean append(V element) {
        Node<V> newTail = new Node<>(element);
        this.tail.setNext(newTail);
        this.tail = newTail;
        this.length++;
        return true;
    }

    public boolean prepend(V element) {
        this.head = new Node<>(element, this.head);
        this.length++;
        return true;
    }

    public void add(int index, V element) {
        checkIndex(index);

        if (index == 0) {
            prepend(element);
            return;
        }

        if (index == this.length) {
            append(element);
            return;
        }

        Node<V> newNode = new Node<>(element);

        Node<V> leader = getNode(index - 1);
        newNode.setNext(leader.getNext());
        leader.setNext(newNode);
        this.length++;
    }

    public V get(int index) {
        return getNode(index).getValue();
    }

    private Node<V> getNode(int index) {
        checkIndex(index);
        if (index == 0) {
            return this.head;
        }

        if (index == (this.length - 1)) {
            return this.tail;
        }

        int i = 0;
        Node<V> currentNode = this.head;
        while (i != index) {
            currentNode = currentNode.getNext();
            i++;
        }
        return currentNode;
    }

    public V remove(int index) {
        Node<V> parentOfRemoved = getNode(index - 1);
        Node<V> removed = parentOfRemoved.getNext();
        parentOfRemoved.setNext(removed.getNext());
        removed.setNext(null);
        return removed.getValue();
    }

    public SimpleLinkedList<V> reverse() {

        if (this.length == 1) {
            return this;
        }

        Node<V> first = this.head;
        this.tail = first;
        Node<V> second = this.head.getNext();

        while (second != null) {
            // reverse pointer
            var temp = second.getNext();
            second.setNext(first);

            // set up for next iteration
            first = second;
            second = temp;
        }
        this.head.setNext(null);
        this.head = first;
        return this;
    }

    public int size() {
        return this.length;
    }

    private void checkIndex(int index) {
        if (index > this.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void printList() {
        Node<V> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.getValue());
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    @Override
    public String toString() {
        return "SimpleLinkedList{" +
            "head=" + head +
            ", tail=" + tail +
            ", length=" + length +
            '}';
    }
}
