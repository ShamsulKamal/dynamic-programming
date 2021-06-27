package com.skab.tutorial.dp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
    private static final BigDecimal ONE = BigDecimal.ONE;
    private static final BigDecimal ZERO = BigDecimal.ZERO;

    public static void main(String[] args) {

        Map<String, BigDecimal> memo = new HashMap<>();

        System.out.println(gridTraveler(new BigDecimal(1), new BigDecimal(1), memo)); // 1
        System.out.println(gridTraveler(new BigDecimal(2), new BigDecimal(3), memo)); // 3
        System.out.println(gridTraveler(new BigDecimal(3), new BigDecimal(2), memo)); // 3
        System.out.println(gridTraveler(new BigDecimal(3), new BigDecimal(3), memo)); // 6
        System.out.println(gridTraveler(new BigDecimal(18), new BigDecimal(18), memo));   // 2333606220
    }

    private static BigDecimal gridTraveler(BigDecimal m, BigDecimal n, Map<String, BigDecimal> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if ((m.compareTo(ONE) == 0) && (n.compareTo(ONE) == 0)) return ONE;
        if ((m.compareTo(ZERO) == 0) || (n.compareTo(ZERO) == 0)) return ZERO;
        memo.put(key, gridTraveler(m.subtract(ONE), n, memo).add(gridTraveler(m, n.subtract(ONE), memo)));
        return memo.get(key);
    }
}
