package com.skab.tutorial.dp.tabulation;

import java.util.Arrays;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] {2, 3}));    // true
        System.out.println(canSum(7, new int[] {5, 3, 4, 7}));  // true
        System.out.println(canSum(7, new int[] {2, 4}));    // false
        System.out.println(canSum(8, new int[] {2, 3, 5})); // true
        System.out.println(canSum(300, new int[] {7, 14})); // false
    }

    private static boolean canSum(int targetSum, int[] numbers) {
        boolean[] table = new boolean[targetSum + 1];
        Arrays.fill(table, false);
        table[0] = true;
        for (int i = 0; i <= targetSum; i++) {
            if (table[i]) {
                for (int num : numbers) {
                    try {
                        table[i + num] = true;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
        return table[targetSum];
    }
}
