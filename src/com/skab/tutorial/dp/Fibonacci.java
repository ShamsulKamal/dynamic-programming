package com.skab.tutorial.dp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Hello Dynamic Programming");

        // memoization
        // key: arg of n
        // value: return value

        Map<BigDecimal, BigDecimal> map = new HashMap<>();

        System.out.println(fib(new BigDecimal(6), map)); // 1 1 2 3 5 8
        System.out.println(fib(new BigDecimal(7), map)); // 1 1 2 3 5 8 13
        System.out.println(fib(new BigDecimal(8), map)); // 1 1 2 3 5 8 13 21
        System.out.println(fib(new BigDecimal(50), map));// 12586269025
    }

    public static BigDecimal fib(BigDecimal n, Map<BigDecimal, BigDecimal> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n.compareTo(new BigDecimal(2)) <= 0) return new BigDecimal(1);
        BigDecimal i = fib(n.subtract(BigDecimal.ONE), map).add(fib(n.subtract(new BigDecimal(2)), map));
        map.put(n, fib(n.subtract(BigDecimal.ONE), map).add(fib(n.subtract(new BigDecimal(2)), map)));
        return map.get(n);
    }

//   classic fibonacci
//    public static int fib(int n) {
//        if (n <= 2) return 1;
//        return fib(n - 1) + fib(n - 2);
//    }
}
