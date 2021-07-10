package com.skab.tutorial.dp.tabulation;

import java.math.BigDecimal;
import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(fib(6)); // 8
        System.out.println(fib(7)); // 13
        System.out.println(fib(8)); // 21
        System.out.println(fib(50));// 12586269025
    }

    public static BigDecimal fib(int n) {
        BigDecimal[] array = new BigDecimal[n + 1];
        Arrays.fill(array, BigDecimal.ZERO);
        array[1] = BigDecimal.ONE;
        for (int i = 0; i <= n; i++) {
            try {
                array[i + 1] = array[i + 1].add(array[i]);
                array[i + 2] = array[i + 2].add(array[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return array[n];
    }
}
