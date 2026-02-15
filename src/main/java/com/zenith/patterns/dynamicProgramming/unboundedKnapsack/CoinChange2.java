package com.zenith.patterns.dynamicProgramming.unboundedKnapsack;

public class CoinChange2 {

    /**
     * LeetCode 518: Coin Change 2
     *
     * You are given an integer array coins representing coins of different
     * denominations and an integer amount representing a total amount of money.
     *
     * Return the number of combinations that make up that amount. If that
     * amount of money cannot be made up by any combination of the coins,
     * return 0.
     *
     * You may assume that you have an infinite number of each kind of coin.
     * The answer is guaranteed to fit into a 32-bit signed integer.
     *
     * Example 1:
     * Input: amount = 5, coins = [1,2,5]
     * Output: 5
     * Explanation: There are five ways:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * Example 2:
     * Input: amount = 3, coins = [9]
     * Output: 0
     *
     * Example 3:
     * Input: amount = 10, coins = [10]
     * Output: 1
     */

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int a = 1; a <= amount; a++) {
            for (int i = 1; i <= n; i++) {
                dp[i][a] = dp[i - 1][a];
                if (a >= coins[i - 1]) {
                    dp[i][a] += dp[i][a - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        CoinChange2 solver = new CoinChange2();

        // Case 1: example from problem
        int[] coins1 = { 1, 2, 5 };
        int amount1 = 5;
        System.out.println("Case 1: amount=5, coins=[1,2,5]");
        System.out.println("Expected: 4");
        printResult(solver.change(amount1, coins1));

        // Case 2: impossible case
        int[] coins2 = { 9 };
        int amount2 = 3;
        System.out.println("\nCase 2: amount=3, coins=[9]");
        System.out.println("Expected: 0");
        printResult(solver.change(amount2, coins2));

        // Case 3: single coin matches amount
        int[] coins3 = { 10 };
        int amount3 = 10;
        System.out.println("\nCase 3: amount=10, coins=[10]");
        System.out.println("Expected: 1");
        printResult(solver.change(amount3, coins3));

        // Case 4: amount is 0
        int[] coins4 = { 1, 2, 5 };
        int amount4 = 0;
        System.out.println("\nCase 4: amount=0, coins=[1,2,5]");
        System.out.println("Expected: 1");
        printResult(solver.change(amount4, coins4));

        // Case 5: single coin with larger amount
        int[] coins5 = { 2 };
        int amount5 = 5;
        System.out.println("\nCase 5: amount=5, coins=[2]");
        System.out.println("Expected: 0");
        printResult(solver.change(amount5, coins5));

        // Case 6: two coins to make specific amount
        int[] coins6 = { 2, 3, 5 };
        int amount6 = 5;
        System.out.println("\nCase 6: amount=5, coins=[2,3,5]");
        System.out.println("Expected: 2 (5, 2+3, 3+2 - but combinations not permutations)");
        printResult(solver.change(amount6, coins6));

        // Case 7: classic unbounded knapsack scenario
        int[] coins7 = { 1, 2, 3 };
        int amount7 = 4;
        System.out.println("\nCase 7: amount=4, coins=[1,2,3]");
        System.out.println("Expected: 4 (4, 3+1, 2+2, 2+1+1, 1+1+1+1)");
        printResult(solver.change(amount7, coins7));

        // Case 8: larger example
        int[] coins8 = { 10 };
        int amount8 = 5;
        System.out.println("\nCase 8: amount=5, coins=[10]");
        System.out.println("Expected: 0");
        printResult(solver.change(amount8, coins8));
    }
}
