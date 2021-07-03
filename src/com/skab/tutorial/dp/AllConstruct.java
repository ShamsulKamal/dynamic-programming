package com.skab.tutorial.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a function `allConstruct(target, wordBank)` that accept a
 * target string and an array of strings
 */
public class AllConstruct {
    public static void main(String[] args) {

        System.out.println(allConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl"), null));
        // [[purp, le], [p, ur, p, le]]

        System.out.println(allConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c"), null));
        // [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]

        System.out.println(allConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"), null));
        // []

        System.out.println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaz", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa"), null));
        // []
    }

    /**
     *
     * @param target
     * @param wordBank
     * @return  2D array containing all the ways that the `target` can be constructed
     *          by concatenating elements of the 'wordBank' array. Each element
     *          of the 2D array should represent one combination that construct
     *          the 'target'.
     */
    private static List<List<String>> allConstruct(String target, List<String> wordBank, Map<String, List<List<String>>> memo) {
        if (memo == null) {
            memo = new HashMap<>();
        }
        if (memo.containsKey(target)) return memo.get(target);
        if ("".equals(target)) return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        List<List<String>> result = new ArrayList<>();

        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);
                List<List<String>> targetWays = suffixWays.stream().map(e -> {
                    List<String> temp = new ArrayList<>(e);
                    temp.add(0, word);
                    return temp;
                }).collect(Collectors.toList());
                result.addAll(targetWays);
            }
        }
        memo.put(target, result);
        return result;
    }
}
