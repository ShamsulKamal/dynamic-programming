package com.skab.tutorial.dp.tabulation;

import java.util.Arrays;
import java.util.List;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple",
                Arrays.asList("purp", "p", "ur", "le", "purpl"))); // 2
        System.out.println(countConstruct("abcdef",
                Arrays.asList("ab", "abc", "cd", "def", "abcd"))); // 1
        System.out.println(countConstruct("skateboard",
                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"))); // 0
        System.out.println(countConstruct("enterapotentpot",
                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"))); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        ))); // 0
    }

    private static int countConstruct(String target, List<String> wordBank) {
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i <= target.length(); i++) {
            for (String word: wordBank) {
                try {
                    if (target.substring(i, i + word.length()).equals(word)) {
                        table[i + word.length()] += table[i];
                    }
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
        return table[target.length()];
    }
}
