package com.krishnamurti.ztmDataStructures;

import com.krishnamurti.recursion.RecursionExercise;
import org.junit.jupiter.api.Test;

public class RecursionTest {

    @Test
    public void recursiveFactorialTest() {
        System.out.println(RecursionExercise.recursiveFactorial(6));
    }

    @Test
    public void iterativeFactorialTest() {
        System.out.println(RecursionExercise.iterativeFactorial(6));
    }

    @Test
    public void recursiveFibonacci() {
        System.out.println(RecursionExercise.fibonacciRecursive(50));
    }

    @Test
    public void IterativeFibonacci() {
        System.out.println(RecursionExercise.iterativeFibonacci(50));
    }

    @Test
    public void dpFibonacci() {
        System.out.println(RecursionExercise.dpFibonacci(50));
    }
}
