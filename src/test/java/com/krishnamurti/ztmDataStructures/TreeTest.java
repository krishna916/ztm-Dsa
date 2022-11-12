package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.Trees.SimpleBinarySearchTree;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void simpleTreeTest() {
        SimpleBinarySearchTree<Integer> bst = new SimpleBinarySearchTree<>();
        bst.insert(5);
        bst.insert(54);
        bst.insert(54);
        bst.insert(45);
        bst.insert(34);
        bst.insert(99);
        bst.insert(1);
        bst.insert(50);
        bst.insert(38);
        bst.insert(52);

        bst.printTree();

        System.out.println(bst.search(1));
        System.out.println(bst.remove(38));
        bst.printTree();
    }
}
