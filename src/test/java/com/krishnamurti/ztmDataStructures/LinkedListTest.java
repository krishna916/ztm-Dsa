package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.LinkedList.SimpleDoublyLinkedList;
import com.krishnamurti.ztmDataStructures.LinkedList.SimpleLinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void linkedListTest() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(10);
        list.append(5);
        list.append(12);
        list.prepend(50);

        System.out.println(list.get(2));
        list.add(2, 80);
        System.out.println(list.get(3));

        list.printList();
        System.out.println(list.size());
        System.out.println(list.get(4));
        System.out.println(list.get(0));
        list.prepend(99);
        System.out.println(list.get(5));
        list.printList();
        System.out.println(list.remove(2));
        list.printList();
        list.reverse();

        list.printList();

    }


    @Test
    public void DoublyLinkedListTest() {

        SimpleDoublyLinkedList<Integer> list = new SimpleDoublyLinkedList<>(10);
        list.append(5);
        list.append(12);

        list.prepend(50);

        list.add(2, 80);

        list.printList();
        list.printListReverse();
        System.out.println(list.size());
        list.remove(2);
        list.printList();
        list.printListReverse();

    }
}
