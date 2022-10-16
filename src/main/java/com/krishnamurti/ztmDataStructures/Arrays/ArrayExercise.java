package com.krishnamurti.ztmDataStructures.Arrays;

import java.util.Arrays;

public class ArrayExercise {


    public static String reverse(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Null not allowed");
        }
        char[] c = new char[s.length()];
        char[] sArray = s.toCharArray();
        int length = sArray.length;
        for (int i = length - 1, j = 0; 0 <= i; i--, j++) {
            c[i] = sArray[j];
        }
        return new String(c);
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException("Provided arrays should not be null");
        }
        if (arr1.length == 0) {
            return arr2;
        }
        if (arr2.length == 0) {
            return arr1;
        }
        int[] mergedArray = new int[arr1.length + arr2.length];
        int arr1Index = 0;
        int arr2Index = 0;

        for (int index = 0; index < mergedArray.length; index++) {
            if (arr1Index != arr1.length && (arr2Index == arr2.length || arr1[arr1Index] < arr2[arr2Index])) {
                mergedArray[index] = arr1[arr1Index++];
            } else {
                mergedArray[index] = arr2[arr2Index++];
            }
        }
        return mergedArray;
    }

}
