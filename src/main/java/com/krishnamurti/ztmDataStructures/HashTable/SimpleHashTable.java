package com.krishnamurti.ztmDataStructures.HashTable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple hashtable implementation where key is restricted to String type.
 *
 * @param <V>
 */
public class SimpleHashTable<V> {

    private final Object[] data;

    public SimpleHashTable(int size) {
        this.data = new Object[size];
    }

    private int hash(String key) {
        return key.length() % data.length;
    }

    @SuppressWarnings("unchecked")
    public void put(String key, V value) {
        V previousValue = null;
        int address = hash(key);
        if (this.data[address] == null) {
            this.data[address] = new ArrayList<>();
        }
        List<List<Object>> values = (List<List<Object>>) this.data[address];
        values.add(List.of(key, value));
    }

    @SuppressWarnings("unchecked")
    public V get(String key) {
        int address = hash(key);
        List<List<Object>> currentBucket = (List<List<Object>>) this.data[address];
        if (currentBucket != null) {
            for (List<Object> objects : currentBucket) {
                if (objects.get(0).equals(key)) {
                    return (V) objects.get(1);
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Set<String> keys() {
        Set<String> keys = new HashSet<>();
        for (Object datum : this.data) {
            if (datum != null) {
                for (List<Object> element : (List<List<Object>>) datum) {
                    keys.add((String) element.get(0));
                }
            }
        }
        return keys;
    }

    @SuppressWarnings("unchecked")
    public Set<V> values() {
        Set<V> values = new HashSet<>();
        for (Object datum : this.data) {
            if (datum != null) {
                for (List<Object> element : (List<List<Object>>) datum) {
                    values.add((V) element.get(1));
                }
            }
        }
        return values;
    }


    @Override
    public String toString() {
        return "SimpleHashTable{" +
            "data=" + Arrays.toString(data) +
            '}';
    }
}
