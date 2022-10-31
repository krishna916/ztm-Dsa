package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.HashTable.HashTableExercises;
import com.krishnamurti.ztmDataStructures.HashTable.SimpleHashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTest {

    @Test
    public void testPut() {
        SimpleHashTable<String> test = new SimpleHashTable<>(10);
        test.put("1", "one");
        test.put("22", "two");
        test.put("3", "three");
        test.put("4", "four");
        System.out.println(test);

        assertEquals("three", test.get("3"));
        assertEquals("two", test.get("22"));

        System.out.println(test.keys());
        System.out.println(test.values());
    }

    //  Exercises

    @Test
    public void testFirstRecurrentEl() {
        int[] a = new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4};
        assertEquals(2, HashTableExercises.firstRecurringNumber(a));

        int[] b = new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4};
        assertEquals(1, HashTableExercises.firstRecurringNumber(b));

        int[] c = new int[]{2, 3, 4, 5};
        assertNull(HashTableExercises.firstRecurringNumber(c));
    }
}
