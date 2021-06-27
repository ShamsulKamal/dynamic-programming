package com.skab.tutorial.dp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final BigDecimal ONE = BigDecimal.ONE;
    private static final BigDecimal TWO = new BigDecimal(2);

    public static void main(String[] args) {

        // memoization
        // key: arg of n
        // value: return value

        Map<BigDecimal, BigDecimal> memo = new HashMap<>();

        // 1 1 2 3 5 8 13 21 ...
        System.out.println(fib(new BigDecimal(6), memo)); // 8
        System.out.println(fib(new BigDecimal(7), memo)); // 13
        System.out.println(fib(new BigDecimal(8), memo)); // 21
        System.out.println(fib(new BigDecimal(50), memo));// 12586269025
    }

    public static BigDecimal fib(BigDecimal n, Map<BigDecimal, BigDecimal> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        if (n.compareTo(TWO) <= 0) return ONE;
        else memo.put(n, fib(n.subtract(ONE), memo).add(fib(n.subtract(TWO), memo)));

        return memo.get(n);
    }

//  classic fibonacci
//    public static int fib(int n) {
//        if (n <= 2) return 1;
//        return fib(n - 1) + fib(n - 2);
//    }
}
