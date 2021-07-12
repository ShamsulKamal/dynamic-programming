package com.skab.tutorial.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

public class BestSum {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] {5, 3, 4, 7})); // [7]
        System.out.println(bestSum(8, new int[] {2, 3, 5}));    // [3, 5]
        System.out.println(bestSum(8, new int[] {1, 4, 5}));    // [4, 4]
        System.out.println(bestSum(100, new int[] {1, 2, 5, 25}));  // [25, 25, 25, 25]
    }

    private static List<Integer> bestSum(int targetSum, int[] numbers) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < (targetSum + 1); i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<Integer>());

        for (int i = 0; i <= targetSum; i++) {
            if (table.get(i) != null) {
                for (int num : numbers) {
                    List<Integer> combination = new ArrayList<>(table.get(i));
                    combination.add(num);
                    try {
                        if (table.get(i + num) == null || (table.get(i + num).size() > combination.size())) {
                            table.set(i + num, combination);
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }
        return table.get(targetSum);
    }
}
