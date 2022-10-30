package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.ztmDataStructures.HashTable.SimpleHashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
