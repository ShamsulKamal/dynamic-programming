package com.skab.tutorial.dp.tabulation;

import java.math.BigDecimal;
import java.util.Arrays;

public class GridTraveler {
    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1)); // 1
        System.out.println(gridTraveler(2, 3)); // 3
        System.out.println(gridTraveler(3, 2)); // 3
        System.out.println(gridTraveler(3, 3)); // 6
        System.out.println(gridTraveler(18, 18)); // 2333606220
    }

    private static BigDecimal gridTraveler(int m, int n) {
        BigDecimal[][] table = new BigDecimal[m + 1][n + 1];
        Arrays.stream(table).forEach(e -> Arrays.fill(e, BigDecimal.ZERO));

        table[1][1] = BigDecimal.ONE;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                BigDecimal current = table[i][j];
                if (j + 1 <= n) {
                    table[i][j + 1] = table[i][j + 1].add(current);
                }
                if (i + 1 <= m) {
                    table[i + 1][j] = table[i + 1][j].add(current);
                }
            }
        }

        return table[m][n];
    }
}
