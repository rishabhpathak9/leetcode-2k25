package com.zenith.something.dynamicProgramming.dpOnGrids;

/**
 * LeetCode 329: Longest Increasing Path in a Matrix
 *
 * Given an m x n integers matrix, return the length of the longest increasing
 * path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or
 * down.
 */
public class LongestIncreasingPathMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp(dp, matrix, m, n, i, j));
            }
        }
        return max;
    }

    private int dp(int[][] dp, int[][] mat, int m, int n, int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int max = 0;
        if (i > 0) {
            if (mat[i - 1][j] > mat[i][j]) {
                max = Math.max(dp(dp, mat, m, n, i - 1, j), max);
            }
        }
        if (j > 0) {
            if (mat[i][j - 1] > mat[i][j]) {
                max = Math.max(dp(dp, mat, m, n, i, j - 1), max);
            }
        }
        if (i + 1 < m) {
            if (mat[i + 1][j] > mat[i][j]) {
                max = Math.max(dp(dp, mat, m, n, i + 1, j), max);
            }
        }
        if (j + 1 < n) {
            if (mat[i][j + 1] > mat[i][j]) {
                max = Math.max(dp(dp, mat, m, n, i, j + 1), max);
            }
        }
        dp[i][j] = max + 1;
        return max + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix lipm = new LongestIncreasingPathMatrix();

        System.out.println("Test 1: matrix = [[9,9,4],[6,6,8],[2,1,1]]");
        int[][] matrix1 = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println("Output: " + lipm.longestIncreasingPath(matrix1));
        System.out.println("Expected: 4\n");

        System.out.println("Test 2: matrix = [[3,4,5],[3,2,6],[2,2,1]]");
        int[][] matrix2 = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
        System.out.println("Output: " + lipm.longestIncreasingPath(matrix2));
        System.out.println("Expected: 4\n");

        System.out.println("Test 3: matrix = [[1]]");
        int[][] matrix3 = { { 1 } };
        System.out.println("Output: " + lipm.longestIncreasingPath(matrix3));
        System.out.println("Expected: 1\n");
    }
}
