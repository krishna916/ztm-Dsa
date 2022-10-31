package com.krishnamurti.ztmDataStructures.HashTable;

import java.util.HashMap;
import java.util.Map;

public class HashTableExercises {

    public static Integer firstRecurringNumber(int[] arr) {
        Map<Integer, Integer> elements = new HashMap<>();
        for (int el : arr) {
            if (elements.get(el) != null) {
                return el;
            }
            elements.put(el, el);
        }
        return null;
    }
}
