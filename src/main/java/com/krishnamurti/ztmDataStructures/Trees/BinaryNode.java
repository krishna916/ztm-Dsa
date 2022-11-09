package com.krishnamurti.ztmDataStructures.Trees;

public class BinaryNode<V> {

    private V value;
    private BinaryNode<V> left;
    private BinaryNode<V> right;

    public BinaryNode(V value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BinaryNode<V> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<V> left) {
        this.left = left;
    }

    public BinaryNode<V> getRight() {
        return right;
    }

    public void setRight(BinaryNode<V> right) {
        this.right = right;
    }
}
