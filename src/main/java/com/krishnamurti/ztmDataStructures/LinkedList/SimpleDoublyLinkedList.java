package com.krishnamurti.ztmDataStructures.LinkedList;

import com.krishnamurti.commons.DoublyNode;

public class SimpleDoublyLinkedList<V> {

    private DoublyNode<V> head;
    private DoublyNode<V> tail;
    private int length;

    public SimpleDoublyLinkedList() {
    }


    public SimpleDoublyLinkedList(V firstElement) {
        this.head = new DoublyNode<>(firstElement);
        this.tail = this.head;
        this.length = 1;
    }

    public boolean append(V element) {
        this.tail = new DoublyNode<>(element, this.tail, null);
        this.tail.getPrevious().setNext(this.tail);
        this.length++;
        return true;
    }

    public boolean prepend(V element) {
        this.head = new DoublyNode<>(element, null, this.head);
        this.head.getNext().setPrevious(this.head);
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

        DoublyNode<V> newNode = new DoublyNode<>(element);

        DoublyNode<V> leader = getNode(index - 1);
        newNode.setNext(leader.getNext());
        newNode.setPrevious(leader);

        leader.getNext().setPrevious(newNode);

        leader.setNext(newNode);
        this.length++;
    }

    public V get(int index) {
        return getNode(index).getValue();
    }

    private DoublyNode<V> getNode(int index) {
        checkIndex(index);
        if (index == 0) {
            return this.head;
        }

        if (index == (this.length - 1)) {
            return this.tail;
        }

        int i = 0;
        DoublyNode<V> currentNode = this.head;
        while (i != index) {
            currentNode = currentNode.getNext();
            i++;
        }
        return currentNode;
    }

    public V remove(int index) {
        DoublyNode<V> removed = getNode(index);
        removed.getPrevious().setNext(removed.getNext());
        removed.getNext().setPrevious(removed.getPrevious());
        removed.setPrevious(null);
        removed.setNext(null);
        return removed.getValue();
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
        DoublyNode<V> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.getValue());
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void printListReverse() {
        DoublyNode<V> current = this.tail;
        System.out.print("Tail -> ");
        while (current != null) {
            System.out.print(current.getValue());
            System.out.print(" -> ");
            current = current.getPrevious();
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

