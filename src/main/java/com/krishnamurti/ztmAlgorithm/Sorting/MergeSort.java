package com.krishnamurti.ztmAlgorithm.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        // Split the array in to right and left
        int length = arr.size();
        int middle = length / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, middle));
        List<Integer> right = new ArrayList<>(arr.subList(middle, length));

//        System.out.println("left: " + Arrays.toString(left.toArray()));
//        System.out.println("right: " + Arrays.toString(right.toArray()));

        // sort left and right then merge
        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sorted = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                sorted.add(left.get(leftIndex));
                leftIndex++;
            } else {
                sorted.add(right.get(rightIndex));
                rightIndex++;
            }
        }
//        System.out.println( Arrays.toString(left.toArray()) + ", " +  Arrays.toString(right.toArray()));
        if (leftIndex < left.size()) {
            sorted.addAll(left.subList(leftIndex, left.size()));
        }
        if (rightIndex < right.size()) {
            sorted.addAll(right.subList(rightIndex, right.size()));
        }
//        System.out.println("Sorted subarrays " +  Arrays.toString(sorted.toArray()));
        return sorted;
    }

}
