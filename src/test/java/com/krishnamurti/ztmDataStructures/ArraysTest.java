package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.Arrays.ArrayExercise;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import com.krishnamurti.ztmDataStructures.Arrays.SimpleArray;

import static org.junit.jupiter.api.Assertions.*;

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

    // Exercises

    @Test
    public void testReverse() {
        String t = "hello";
        assertEquals(StringUtils.reverse(t), ArrayExercise.reverse(t));
        assertThrows(IllegalArgumentException.class, () -> ArrayExercise.reverse(null));
    }

    @Test
    public void testMergeSortedArray() {
        int[] arr1 = {0, 3, 4, 555};
        int[] arr2 = {4, 6, 30};
        int[] result = ArrayExercise.mergeSortedArrays(arr1, arr2);
        int[] expectedResult = {0, 3, 4, 4, 6, 30, 555};
        assertArrayEquals(expectedResult, result);
    }


}
