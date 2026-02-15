package com.zenith.patterns.dynamicProgramming.probabilityDP;

import java.util.Arrays;

/**
 * LeetCode 688: Knight Probability in Chessboard
 *
 * On an n x n chessboard, a knight starts at the cell (row, column) and
 * attempts
 * to make exactly k moves. The rows and columns are 0-indexed, so the
 * chessboard
 * ranges from [0, n - 1] on both axes.
 * In each move, the knight moves in an "L-shaped" way consisting of two
 * straight moves
 * and a single diagonal submovement, four times in the stated order.
 * Return the probability that the knight remains on the chessboard after
 * exactly k moves.
 */
public class KnightProbability {

    int[][] dirs = {
            { 2, 1 }, { 1, 2 },
            { -2, 1 }, { -1, 2 },
            { 2, -1 }, { 1, -2 },
            { -2, -1 }, { -1, -2 },
    };
    int n, row, column;
    double[][][] mem;

    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        this.row = row;
        this.column = column;
        this.mem = new double[n + 1][n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                Arrays.fill(mem[i][j], -1);
        return solve(row, column, k);
    }

    private double solve(int i, int j, int k) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return 0;
        if (k == 0)
            return 1;
        if (mem[i][j][k] != -1)
            return mem[i][j][k];
        double sum = 0.0;
        for (int[] dir : dirs) {
            sum += solve(i + dir[0], j + dir[1], k - 1);
        }
        mem[i][j][k] = sum / 8;
        return sum / 8;
    }

    public static void main(String[] args) {
        KnightProbability kp = new KnightProbability();

        System.out.println("Test 1: n = 3, k = 2, row = 0, column = 0");
        System.out.println("Output: " + kp.knightProbability(3, 2, 0, 0));
        System.out.println("Expected: 0.0625 (1/16)\n");

        System.out.println("Test 2: n = 1, k = 0, row = 0, column = 0");
        System.out.println("Output: " + kp.knightProbability(1, 0, 0, 0));
        System.out.println("Expected: 1.0\n");

        System.out.println("Test 3: n = 8, k = 30, row = 6, column = 4");
        System.out.println("Output: " + kp.knightProbability(8, 30, 6, 4));
        System.out.println("Expected: 0.5731...\n");
    }
}
