package com.krishnamurti.ztmDataStructures.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public List<V> breadthFirstSearch() {
        BinaryNode<V> currentNode = this.root;

        List<V> list = new ArrayList<>();
        Queue<BinaryNode<V>> queue = new ArrayDeque<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.println(currentNode.getValue());
            list.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    public List<V> breadFirstSearchR() {
        Queue<BinaryNode<V>> queue = new ArrayDeque<>();
        queue.add(this.root);
        return breadFirstSearchR(queue, new ArrayList<>());
    }

    private List<V> breadFirstSearchR(Queue<BinaryNode<V>> queue, List<V> list) {
        if (queue.isEmpty()) {
            return list;
        }
        BinaryNode<V> currentNode = queue.poll();
        list.add(currentNode.getValue());
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }
        return breadFirstSearchR(queue, list);
    }

    public List<V> dfsInOrder() {
        return traverseInOrder(this.root, new ArrayList<>());
    }

    public List<V> dfsPreOrder() {
        return traversePreOrder(this.root, new ArrayList<>());
    }

    public List<V> dfsPostOrder() {
        return traversePostOrder(this.root, new ArrayList<>());
    }

    private List<V> traverseInOrder(BinaryNode<V> node, List<V> list) {
        if (node.getLeft() != null) {
            traverseInOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            traverseInOrder(node.getRight(), list);
        }
        return list;
    }

    private List<V> traversePreOrder(BinaryNode<V> node, List<V> list) {
        list.add(node.getValue());
        if (node.getLeft() != null) {
            traversePreOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traversePreOrder(node.getRight(), list);
        }
        return list;
    }

    private List<V> traversePostOrder(BinaryNode<V> node, List<V> list) {
        if (node.getLeft() != null) {
            traversePostOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traversePostOrder(node.getRight(), list);
        }
        list.add(node.getValue());
        return list;
    }


}
