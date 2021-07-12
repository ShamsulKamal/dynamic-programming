package com.skab.tutorial.dp.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef",
                new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard",
                new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot",
                new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        })); // false
    }

    private static boolean canConstruct(String target, String[] words) {
        Boolean[] table = new Boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i]) {
                for (String word : words) {
                    try {
                        // if the word matches the characters starting at position
                        if (target.substring(i, i + word.length()).equals(word)) {
                            table[i + word.length()] = true;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                    }
                }
            }
        }
        return table[target.length()];
    }
}
