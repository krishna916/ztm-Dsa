package com.krishnamurti.ztmDataStructures.Trees;

public class SimpleBinarySearchTree<V extends Comparable<V>> {

    private BinaryNode<V> root;

    private int count = 0;

    public SimpleBinarySearchTree() {
        this.root = null;
    }

    public void printTree() {
        count = 0;
        printTree(this.root);
    }

    public void insert(V value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        BinaryNode<V> newNode = new BinaryNode<>(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            BinaryNode<V> current = this.root;
            while (current != null) {
                int comparisonResult = value.compareTo(current.getValue());
                if (comparisonResult < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        break;
                    }
                    current = current.getLeft();
                } else if (comparisonResult > 0) {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        break;
                    }
                    current = current.getRight();
                } else {
                    break;
                }
            }
        }
    }

    private void printTree(BinaryNode<V> node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if (node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if (node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    public V search(V value) {
        BinaryNode<V> current = this.root;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current.getValue();
            }
            if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            } else if (value.compareTo(current.getValue()) > 0) {
                current = current.getRight();
            }
        }
        return null;
    }

}
