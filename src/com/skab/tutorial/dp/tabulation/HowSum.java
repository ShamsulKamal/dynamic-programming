package com.skab.tutorial.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSum {
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[] {2, 3}));    // [3, 2, 2]
        System.out.println(howSum(7, new int[] {5, 3, 4, 7}));  // [4, 3]
        System.out.println(howSum(7, new int[] {2, 4}));    // null
        System.out.println(howSum(8, new int[] {2, 3, 5})); // [2, 2, 2, 2]
        System.out.println(howSum(300, new int[] {7, 14})); // null
    }

    private static List<Integer> howSum(int targetSum, int[] numbers) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < (targetSum + 1); i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<>());

        for (int i = 0; i <= targetSum; i++) {
            if (table.get(i) != null) {
                for (int num : numbers) {
                    try {
                        List<Integer> temp = new ArrayList<>(table.get(i));
                        temp.add(num);
                        table.set(i + num, temp);
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }
        return table.get(targetSum);
    }
}
