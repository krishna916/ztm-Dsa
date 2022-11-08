package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.stacksAndQueues.SimpleQueue;
import com.krishnamurti.ztmDataStructures.stacksAndQueues.SimpleStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackAndQueueTest {

    @Test
    public void simpleStackTest() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(4);
        stack.push(6);
        stack.push(23);
        stack.push(54);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.printStack();
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.printStack();
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.printStack();
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.printStack();
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.printStack();
        System.out.println();

    }


    @Test
    public void queueTest() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.enqueue(5);
        queue.enqueue(78);
        queue.enqueue(93);

        System.out.println(queue.peek());
        System.out.println(queue.size());
        queue.printList();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        Assertions.assertThrows(IndexOutOfBoundsException.class, queue::dequeue);


        queue.printList();
    }
}
