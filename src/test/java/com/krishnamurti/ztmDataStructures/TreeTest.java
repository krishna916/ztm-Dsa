package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.Trees.SimpleBinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TreeTest {

    @Test
    public void simpleTreeTest() {
        SimpleBinarySearchTree<Integer> bst = new SimpleBinarySearchTree<>();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        bst.printTree();

//        System.out.println(bst.search(1));
//        System.out.println(bst.remove(38));
        bst.printTree();

        System.out.println();
//        bst.breadthFirstSearch();
//        System.out.println(Arrays.toString(bst.breadFirstSearchR().toArray(new Integer[0])));


        System.out.println("In Order: " + Arrays.toString(bst.dfsInOrder().toArray(new Integer[0])));
        System.out.println("Pre Order: " + Arrays.toString(bst.dfsPreOrder().toArray(new Integer[0])));
        System.out.println("Post Order: " + Arrays.toString(bst.dfsPostOrder().toArray(new Integer[0])));
    }
}
