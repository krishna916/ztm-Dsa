package com.krishnamurti.ztmDataStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.krishnamurti.ztmDataStructures.Arrays.SimpleArray;

public class ArraysTest {

    @Test
    public void testEmptyArray() {
        SimpleArray<Integer> array = new SimpleArray<>();
        assertEquals(0, array.length());
    }

    @Test
    public void testPushArray() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        assertTrue(array.push(3));
        assertTrue(array.push(6));
        System.out.println(array);
        assertEquals(2, array.size());
    }

    @Test
    public void testPopArray() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        assertTrue(array.push(3));
        assertTrue(array.push(6));
        assertEquals(6, array.pop());
        System.out.println(array);
        assertEquals(1, array.size());
        assertEquals(3, array.get(0));
    }

    @Test
    public void testDelete() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        assertTrue(array.push(3));
        assertTrue(array.push(6));
        assertTrue(array.push(67));
        assertTrue(array.push(633));
        assertEquals(6, array.delete(1));
        System.out.println(array);
        assertEquals(3, array.size());
        assertEquals(67, array.get(1));
    }


}
