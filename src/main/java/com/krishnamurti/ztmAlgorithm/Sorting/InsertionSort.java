package com.krishnamurti.ztmAlgorithm.Sorting;

import java.util.List;

public class InsertionSort {

    public static void sort(List<Integer> arr) {

        int length = arr.size();
        for (int i = 0; i < length; i++) {
            if (arr.get(i) <= arr.get(0)) {
                // move number to first position
                int temp = arr.get(i);
                arr.add(0, temp);
                arr.remove(i + 1);
            } else {
                // find where the number should go
                for (int j = 1; j < i; j++) {
                    if (arr.get(i) >= arr.get(j - 1) && arr.get(i) < arr.get(j)) {
                        //move number to the correct spot
                        arr.add(j, arr.get(i));
                        arr.remove(i + 1);
                    }
                }
            }
        }
    }
}
