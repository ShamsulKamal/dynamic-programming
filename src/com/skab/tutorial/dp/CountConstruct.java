package com.skab.tutorial.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple",
                Arrays.asList("purp", "p", "ur", "le", "purpl"), null)); // 2
        System.out.println(countConstruct("abcdef",
                Arrays.asList("ab", "abc", "cd", "def", "abcd"), null)); // 1
        System.out.println(countConstruct("skateboard",
                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"), null)); // 0
        System.out.println(countConstruct("enterapotentpot",
                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"), null)); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        ), null)); // 0
    }

    private static int countConstruct(String target, List<String> wordBank, Map<String, Integer> memo) {
        if (memo == null) {
            memo = new HashMap<>();
        }
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return 1;
        int totalCount = 0;

        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                int numWaysForRest = countConstruct(target.substring(word.length()), wordBank, memo);
                totalCount += numWaysForRest;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }
}
