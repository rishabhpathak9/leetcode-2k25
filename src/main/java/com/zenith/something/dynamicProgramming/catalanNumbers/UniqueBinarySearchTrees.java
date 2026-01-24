package com.zenith.something.dynamicProgramming.catalanNumbers;

import java.util.Arrays;

/**
 * LeetCode 96: Unique Binary Search Trees
 *
 * Given an integer n, return the number of structurally unique BSTs
 * which has exactly n nodes of unique values from 1 to n.
 */
public class UniqueBinarySearchTrees {

    int dp[];

    public int numTrees(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);

    }

    private int solve(int n) {
        if (dp[n] != -1)
            return dp[n];
        if (n == 0)
            return 1;
        if (n <= 2)
            return n;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += solve(i - 1) * solve(n - i);
        }
        dp[n] = res;
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();

        System.out.println("Test 1: n = 1");
        System.out.println("Output: " + ubst.numTrees(1));
        System.out.println("Expected: 1\n");

        System.out.println("Test 2: n = 2");
        System.out.println("Output: " + ubst.numTrees(2));
        System.out.println("Expected: 2\n");

        System.out.println("Test 3: n = 3");
        System.out.println("Output: " + ubst.numTrees(3));
        System.out.println("Expected: 5\n");

        System.out.println("Test 4: n = 4");
        System.out.println("Output: " + ubst.numTrees(4));
        System.out.println("Expected: 14\n");
    }
}
