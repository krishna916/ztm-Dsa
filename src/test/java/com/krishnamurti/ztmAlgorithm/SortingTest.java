package com.krishnamurti.ztmAlgorithm;

import com.krishnamurti.ztmAlgorithm.Sorting.BubbleSort;
import com.krishnamurti.ztmAlgorithm.Sorting.InsertionSort;
import com.krishnamurti.ztmAlgorithm.Sorting.MergeSort;
import com.krishnamurti.ztmAlgorithm.Sorting.SelectionSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingTest {

    @Test
    public void bubbleSortTest() {
        List<Integer> list = generateRandomArray(10000, 10000);
        BubbleSort.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void selectionSortTest() {
        List<Integer> list = generateRandomArray(10000, 10000);
        SelectionSort.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void insertionSortTest() {
        List<Integer> list = generateRandomArray(10000, 10000);

        InsertionSort.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void mergeSortTest() {
        List<Integer> list = generateRandomArray(8, 10);
        System.out.println(Arrays.toString(list.toArray()));
        ;
        List<Integer> sorted = MergeSort.mergeSort(list);
        System.out.println(Arrays.toString(sorted.toArray()));
    }

    public List<Integer> generateRandomArray(int n, int bound) {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(bound));
        }
        return list;
    }
}
