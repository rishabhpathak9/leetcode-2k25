package com.zenith.something.dynamicProgramming.dpOnGrids;

/**
 * LeetCode 64: Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right, which minimizes the sum of all numbers along its
 * path.
 * You can only move either down or right at any point in time.
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();

        System.out.println("Test 1: grid = [[1,3,1],[1,5,1],[4,2,1]]");
        int[][] grid1 = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println("Output: " + mps.minPathSum(grid1));
        System.out.println("Expected: 7 (1+3+1+1+1+0)\n");

        System.out.println("Test 2: grid = [[1,2,3],[4,5,6]]");
        int[][] grid2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("Output: " + mps.minPathSum(grid2));
        System.out.println("Expected: 12\n");

        System.out.println("Test 3: grid = [[1]]");
        int[][] grid3 = { { 1 } };
        System.out.println("Output: " + mps.minPathSum(grid3));
        System.out.println("Expected: 1\n");
    }
}
