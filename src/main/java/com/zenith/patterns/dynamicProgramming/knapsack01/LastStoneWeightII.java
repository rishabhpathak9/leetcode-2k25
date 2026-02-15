package com.zenith.patterns.dynamicProgramming.knapsack01;

public class LastStoneWeightII {

    /**
     * LeetCode 1049: Last Stone Weight II
     *
     * You are given an stonesay of integers stones where stones[i] is the weight of
     * the ith stone.
     *
     * We are playing a game with the stones. On each turn, we choose any two
     * stones and smash them together. Suppose the stones have weights x and y
     * with x <= y. The result of this smash is:
     * - If x == y, both stones are destroyed, and
     * - If x != y, the stone of weight y is destroyed and the stone of weight
     * x - y is added back to the pile.
     *
     * At the end, there is at most 1 stone left. Return the smallest possible
     * weight of the left stone. If there are no stones left, return 0.
     *
     * Example 1:
     * Input: stones = [2,7,4,1,8,1]
     * Output: 1
     * Explanation:
     * We can combine 2 and 4 to get 2, so we have [2,7,1,8,1]
     * We can combine 7 and 8 to get 1, so we have [2,1,1,1]
     * We can combine 2 and 1 to get 1, so we have [1,1,1]
     * We can combine 1 and 1 to get 0, so we have [1]
     * The last stone's weight is 1.
     *
     * Example 2:
     * Input: stones = [31,26,33,21,40]
     * Output: 5
     *
     * Example 3:
     * Input: stones = [1]
     * Output: 1
     */

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for (int el : stones) {
            sum += el;
        }
        int sumn = sum / 2;
        int[][] dp = new int[n + 1][sumn + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sumn; j++) {
                int take = 0;
                if (j - stones[i - 1] >= 0) {
                    take = dp[i - 1] [j - stones[i - 1]] + stones[i - 1];
                }
                dp[i][j] = Math.max(dp[i - 1][j], take);
            }
        }
        int partitionS = dp[n][sumn];
        return sum - 2 * partitionS;
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        LastStoneWeightII solver = new LastStoneWeightII();

        // Case 1: example from problem
        int[] stones1 = { 2, 7, 4, 1, 8, 1 };
        System.out.println("Case 1: stones=[2,7,4,1,8,1]");
        System.out.println("Expected: 1");
        printResult(solver.lastStoneWeightII(stones1));

        // Case 2: example from problem
        int[] stones2 = { 31, 26, 33, 21, 40 };
        System.out.println("\nCase 2: stones=[31,26,33,21,40]");
        System.out.println("Expected: 5");
        printResult(solver.lastStoneWeightII(stones2));

        // Case 3: single stone
        int[] stones3 = { 1 };
        System.out.println("\nCase 3: stones=[1]");
        System.out.println("Expected: 1");
        printResult(solver.lastStoneWeightII(stones3));

        // Case 4: two stones with same weight
        int[] stones4 = { 5, 5 };
        System.out.println("\nCase 4: stones=[5,5]");
        System.out.println("Expected: 0");
        printResult(solver.lastStoneWeightII(stones4));

        // Case 5: two stones with different weights
        int[] stones5 = { 3, 7 };
        System.out.println("\nCase 5: stones=[3,7]");
        System.out.println("Expected: 4");
        printResult(solver.lastStoneWeightII(stones5));

        // Case 6: all same weight stones
        int[] stones6 = { 2, 2, 2, 2 };
        System.out.println("\nCase 6: stones=[2,2,2,2]");
        System.out.println("Expected: 0");
        printResult(solver.lastStoneWeightII(stones6));

        // Case 7: larger example
        int[] stones7 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("\nCase 7: stones=[1,2,3,4,5,6]");
        System.out.println("Expected: 1");
        printResult(solver.lastStoneWeightII(stones7));
    }
}
