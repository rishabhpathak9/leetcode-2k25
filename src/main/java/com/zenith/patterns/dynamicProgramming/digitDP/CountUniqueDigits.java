package com.zenith.patterns.dynamicProgramming.digitDP;

/**
 * LeetCode 357: Count Numbers with Unique Digits
 *
 * Given an integer n, return the count of all numbers with unique digits, x,
 * where 0 <= x < 10^n.
 */
public class CountUniqueDigits {
    int[] comb = new int[10];

    public int countNumbersWithUniqueDigits(int n) {
        nCr();
        return solve(n);
    }

    private int solve(int n) {
        if (n == 0) {
            return 1;
        }
        return countNumbersWithUniqueDigits(n - 1) + 9 * comb[n - 1];
    }

    private void nCr() {
        comb[0] = 1;

        for (int i = 1; i <= 9; i++) {
            comb[i] = comb[i - 1] * (10 - i);
        }
    }

    public static void main(String[] args) {
        CountUniqueDigits cud = new CountUniqueDigits();

        System.out.println("Test 1: n = 0");
        System.out.println("Output: " + cud.countNumbersWithUniqueDigits(0));
        System.out.println("Expected: 1\n");

        System.out.println("Test 2: n = 1");
        System.out.println("Output: " + cud.countNumbersWithUniqueDigits(1));
        System.out.println("Expected: 10\n");

        System.out.println("Test 3: n = 2");
        System.out.println("Output: " + cud.countNumbersWithUniqueDigits(2));
        System.out.println("Expected: 91\n");

        System.out.println("Test 4: n = 3");
        System.out.println("Output: " + cud.countNumbersWithUniqueDigits(3));
        System.out.println("Expected: 739\n");
    }
}
