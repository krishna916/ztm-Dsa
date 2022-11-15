package com.krishnamurti.ztmAlgorithm.Sorting;

import java.util.List;

public class BubbleSort {

    public static void sort(List<Integer> arr) {
        int length = arr.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // swap number
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

}
