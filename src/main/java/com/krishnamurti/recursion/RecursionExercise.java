package com.krishnamurti.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionExercise {

    private static int count = 0;

    public static int recursiveFactorial(int input) {
        if (input == 1) {
            return 1;
        }

        return input * recursiveFactorial(input - 1);
    }

    public static int iterativeFactorial(int input) {
        int answer = 1;
        while (input > 1) {
            answer = answer * input--;
        }

        return answer;
    }

    public static long fibonacciRecursive(int index) {
        count++;
        if (index < 2) {
            System.out.println("calculations: " + count);
            return index;
        }
        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    public static Long iterativeFibonacci(int index) {
        List<Long> array = new ArrayList<>(List.of(0L, 1L));
        int c = 0;
        for (int i = 2; i < index + 1; i++) {
            c++;
            array.add(array.get(i - 2) + array.get(i - 1));
        }
        System.out.println("calculations: " + c);
        return array.get(index);
    }

    public static long dpFibonacci(int index) {
        long[] arr = new long[index + 2];
        arr[0] = 0;
        arr[1] = 1;
        int c = 0;
        for (int i = 2; i <= index; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println("calculations: " + c);
        return arr[index];
    }

}
