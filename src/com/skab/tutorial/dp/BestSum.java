package com.skab.tutorial.dp;

import java.util.*;

public class BestSum {
    public static void main(String[] args) {
        System.out.println(bestSum(7, Arrays.asList(5, 3, 4, 7), null));    // [7]
        System.out.println(bestSum(8, Arrays.asList(2, 3, 5), null));       // [3, 5]
        System.out.println(bestSum(8, Arrays.asList(1, 4, 5), null));       // [4, 4]
        System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 25), null)); // [25, 25, 25, 25]
    }

    /**
     * m = target
     * n = numbers.size
     *
     * Brute Force
     * time: O(n^m * m)
     * space: O(m^2)
     *
     * Memoized
     * time: O(m^2 * m)
     * space: O(m^2)
     *
     * @param target
     * @param numbers
     * @param memo
     * @return
     */
    public static List<Integer> bestSum(Integer target, List<Integer> numbers, Map<Integer, List<Integer>> memo) {

        if (memo == null) {
            memo = new HashMap<>();
        }

        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        List<Integer> shortestCombination = null;

        for (Integer num: numbers) {
            Integer remainder = target - num;
            List<Integer> remainderCombination = bestSum(remainder, numbers, memo);

            if (remainderCombination != null) {
                List<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(num);

                if ((shortestCombination == null) || (combination.size() < shortestCombination.size())) {
                    shortestCombination = combination;
                }
            }
        }
        memo.put(target, shortestCombination);
        return shortestCombination;
    }
}
