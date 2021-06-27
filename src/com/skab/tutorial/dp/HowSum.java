package com.skab.tutorial.dp;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {

        System.out.println(howSum(7, Arrays.asList(2, 3), null)); // [3, 2, 2]
        System.out.println(howSum(7, Arrays.asList(5, 3, 4, 7), null)); // [4, 3]
        System.out.println(howSum(7, Arrays.asList(2, 4), null)); // null
        System.out.println(howSum(8, Arrays.asList(2, 3, 5), null));  // [2, 2, 2]
        System.out.println(howSum(300, Arrays.asList(7, 14), null));  // null

    }

    /**
     * m = target
     * n = numbers.length
     *
     * Brute Force
     * time: O(n^m * m)
     * space: O(m)
     *
     * Memoized
     * time: O(n*m^2)
     * space: O(m)
     *
     * @param target
     * @param numbers
     * @param memo
     * @return
     */
    private static List<Integer> howSum(Integer target, List<Integer> numbers, Map<Integer, List<Integer>> memo) {

        if (memo == null) {
            memo = new HashMap<>();
        }

        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<Integer>();
        if (target < 0) return null;

        for (Integer e: numbers) {
            Integer remainder = target - e;
            List<Integer> remainderResult = howSum(remainder, numbers, memo);
            if (remainderResult != null) {
                remainderResult.add(e);
                memo.put(target, remainderResult);
                return remainderResult;
            }
        }
        memo.put(target, null);
        return null;
    }
}
