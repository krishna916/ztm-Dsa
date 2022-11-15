package com.krishnamurti.ztmAlgorithm.Sorting;

import java.util.List;

public class SelectionSort {

    public static void selectionSort(List<Integer> arr) {
        int length = arr.size();
        for (int i = 0; i < length; i++) {
            int min = i;
            int temp = arr.get(i);
            for (int j = i + 1; j < length; j++) {
                if (arr.get(j) < arr.get(min)) {
                    min = j;
                }
            }
            arr.set(i, arr.get(min));
            arr.set(min, temp);
        }
    }
}
