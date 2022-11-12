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
            if (value.compareTo(current.getValue()) == 0) {
                return current.getValue();
            } else if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            } else if (value.compareTo(current.getValue()) > 0) {
                current = current.getRight();
            }
        }
        return null;
    }

    public V remove(V value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        if (this.root == null) {
            return null;
        }
        BinaryNode<V> current = this.root;
        BinaryNode<V> parentNode = null;
        while (current != null) {
            int comparisonResult = value.compareTo(current.getValue());
            if (comparisonResult < 0) {
                parentNode = current;
                current = current.getLeft();
            } else if (comparisonResult > 0) {
                parentNode = current;
                current = current.getRight();
            } else { // Match!!

                // Option 1: No right child
                if (current.getRight() == null) {
                    if (parentNode == null) {
                        this.root = current.getLeft();
                        return current.getValue();
                    } else {

                        // if parent > current value, make left
                        // child a left child of parent
                        if (current.getValue().compareTo(parentNode.getValue()) < 0) {
                            parentNode.setLeft(current.getLeft());
                            return current.getValue();
                        } // if parent < current value, make left child a right child of parent
                        else if (current.getValue().compareTo(parentNode.getValue()) > 0) {
                            parentNode.setRight(current.getLeft());
                            return current.getValue();
                        }
                    }
                } else if (current.getRight().getLeft() == null) {
                    // Option 2: Right child which does not have left child
                    if (parentNode == null) {
                        this.root = current.getLeft();
                        return current.getValue();
                    } else {
                        current.getRight().setLeft(current.getLeft());

                        if (current.getValue().compareTo(parentNode.getValue()) < 0) {
                            parentNode.setLeft(current.getRight());
                            return current.getValue();
                        } else if (current.getValue().compareTo(parentNode.getValue()) > 0) {
                            parentNode.setRight(current.getRight());
                            return current.getValue();
                        }
                    }
                } else {
                    // Option 3: Right child has left child
                    BinaryNode<V> leftMost = current.getRight().getLeft();
                    BinaryNode<V> leftMostParent = current.getRight();
                    while (leftMost.getLeft() != null) {
                        leftMostParent = leftMost;
                        leftMost = leftMost.getLeft();
                    }

                    // Parent's left subtree is now leftmost's right subtree
                    leftMostParent.setLeft(leftMost.getRight());
                    leftMost.setLeft(current.getLeft());
                    leftMost.setRight(current.getRight());

                    if (parentNode == null) {
                        this.root = leftMost;
                        return current.getValue();
                    } else {
                        if (current.getValue().compareTo(parentNode.getValue()) < 0) {
                            parentNode.setLeft(leftMost);
                            return current.getValue();
                        } else if (current.getValue().compareTo(parentNode.getValue()) > 0) {
                            parentNode.setRight(leftMost);
                            return current.getValue();
                        }
                    }
                }

            }

        }
        return null;
    }

}
