package com.krishnamurti.ztmDataStructures.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Simple Array implementation
 */
public class SimpleArray<E> {

    private static final Object[] DEFAULT_CAPACITY_EMPTY_ARRAY = {};

    private int length;
    private Object[] data;
    private int size;

    public SimpleArray() {
        this.length = 0;
        this.data = DEFAULT_CAPACITY_EMPTY_ARRAY;
        this.size = 0;
    }

    public SimpleArray(int initialCapacity) {
        this.length = 0;
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    public SimpleArray(int length, E[] data) {
        this.length = length;
        this.data = data;
        this.size = data.length;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) this.data[index];
    }

    public int size() {
        return this.size;
    }

    public boolean push(E item) {
        try {
            this.data[size] = item;
            size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        E popped = (E) this.data[size - 1];
        this.data[size - 1] = null;
        size--;
        return popped;
    }

    @SuppressWarnings("unchecked")
    public E delete(int index) {
        E deleted = (E) this.data[index];
        shiftItems(index);
        return deleted;
    }

    /**
     * Shift all the items by -1 after the provided index and delete last Element
     *
     * @param index
     */
    private void shiftItems(int index) {
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        pop();
    }

    public int length() {
        return this.data.length;
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
            "data=" + Arrays.toString(data) +
            '}';
    }
}
