package com.skab.tutorial.dp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] {2, 3}, null)); // true
        System.out.println(canSum(7, new int[] {5, 3, 4, 7}, null)); // true
        System.out.println(canSum(7, new int[] {2, 4}, null)); // false
        System.out.println(canSum(8, new int[] {2, 3, 5}, null)); // true
        System.out.println(canSum(300, new int[] {7, 14}, null)); // false
    }

    public static boolean canSum(int target, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo == null) {
            memo = new HashMap<>();
        }

        if (memo.containsKey(target)) return memo.get(target);

        if (target == 0) return true;
        if (target < 0) return false;

        for (int i: numbers) {
            int remainder = target - i;
            if (canSum(remainder, numbers, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
}
