package com.zenith.something.dynamicProgramming.dpOnGrids;

/**
 * LeetCode 62: Unique Paths
 *
 * There is a robot on an m x n grid. The robot is initially at the top-left
 * corner.
 * The robot tries to move to the bottom-right corner. The robot can only move
 * either
 * down or right at any point in time. How many possible unique paths are there?
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();

        System.out.println("Test 1: m = 3, n = 7");
        System.out.println("Output: " + up.uniquePaths(3, 7));
        System.out.println("Expected: 28\n");

        System.out.println("Test 2: m = 3, n = 2");
        System.out.println("Output: " + up.uniquePaths(3, 2));
        System.out.println("Expected: 3\n");

        System.out.println("Test 3: m = 1, n = 1");
        System.out.println("Output: " + up.uniquePaths(1, 1));
        System.out.println("Expected: 1\n");

        System.out.println("Test 4: m = 2, n = 2");
        System.out.println("Output: " + up.uniquePaths(2, 2));
        System.out.println("Expected: 2\n");
    }
}
