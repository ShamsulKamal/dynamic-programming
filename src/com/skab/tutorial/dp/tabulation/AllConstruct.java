package com.skab.tutorial.dp.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {
        System.out.println(allConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        // [[purp, le], [p, ur, p, le]]

        System.out.println(allConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        // [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]

        System.out.println(allConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        // []

        System.out.println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaz", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa")));
        // []
    }

    private static List<List<String>> allConstruct(String target, List<String> wordBank) {
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i < (target.length() + 1); i++) {
            List<List<String>> list = new ArrayList<>();
            table.add(list);
        }
        table.set(0, Arrays.asList(new ArrayList<String>()));

        for (int i = 0; i <= target.length(); i++) {
            for (String word: wordBank) {
                try {
                    if (target.substring(i, i + word.length()).equals(word)) {
                        List<List<String>> newCombinations = table.get(i).stream().map(e -> {
                            List<String> subArray = new ArrayList<>(e);
                            subArray.add(word);
                            return subArray;
                        }).collect(Collectors.toList());
                        table.get(i + word.length()).addAll(newCombinations);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
        return table.get(target.length());
    }
}
