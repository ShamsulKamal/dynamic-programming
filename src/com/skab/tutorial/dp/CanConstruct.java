package com.skab.tutorial.dp;

import java.util.*;

public class CanConstruct {
    public static void main(String[] args) {

        System.out.println(canConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd"), null)); // true
        System.out.println(canConstruct("skateboard",
                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"), null)); // false
        System.out.println(canConstruct("enterapotentpot",
                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"), null)); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        ), null)); // false

    }

    private static boolean canConstruct(String target, List<String> wordBank, Map<String, Boolean> memo) {

        if (memo == null) {
            memo = new HashMap<>();
        }

        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return true;

        for (String each: wordBank) {
            if (target.indexOf(each) == 0) {
                String suffix = target.substring(each.length());
                if (canConstruct(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }
}
