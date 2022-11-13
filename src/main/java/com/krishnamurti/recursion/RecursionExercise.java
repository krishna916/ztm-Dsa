package com.krishnamurti.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionExercise {

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
        if (index < 2) {
            return index;
        }
        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    public static Long iterativeFibonacci(int index) {
        List<Long> array = new ArrayList<>(List.of(0L, 1L));
        for (int i = 2; i < index + 1; i++) {
            array.add(array.get(i - 2) + array.get(i - 1));
        }
        return array.get(index);
    }

}
