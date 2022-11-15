package com.krishnamurti.ztmAlgorithm;

import com.krishnamurti.ztmAlgorithm.Sorting.BubbleSort;
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
        BubbleSort.bubbleSort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void selectionSort() {
        List<Integer> list = generateRandomArray(10000, 10000);
        SelectionSort.selectionSort(list);
        System.out.println(Arrays.toString(list.toArray()));
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
