package com.zenith.something.dynamicProgramming.unboundedKnapsack;

public class CoinChange {

    /**
     * LeetCode 322: Coin Change
     *
     * You are given an integer array coins representing coins of different
     * denominations and an integer amount representing a total amount of money.
     *
     * Return the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins,
     * return -1.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * Example 1:
     * Input: coins = [1,2,5], amount = 5
     * Output: 1
     * Explanation: 5 = 5
     *
     * Example 2:
     * Input: coins = [2], amount = 3
     * Output: -1
     *
     * Example 3:
     * Input: coins = [10], amount = 10
     * Output: 1
     */

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        for (int a = 1; a <= amount; a++) {
            dp[a] = amount + 1;
            for (int i = 0; i < n; i++) {
                if (a - coins[i] >= 0 && dp[a - coins[i]] != amount + 1) {
                    dp[a] = Math.min(dp[a], dp[a - coins[i]] + 1);
                }
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        // Case 1: example from problem
        int[] coins1 = { 1, 2, 5 };
        int amount1 = 5;
        System.out.println("Case 1: coins=[1,2,5], amount=5");
        System.out.println("Expected: 1");
        printResult(solver.coinChange(coins1, amount1));

        // Case 2: impossible case
        int[] coins2 = { 2 };
        int amount2 = 3;
        System.out.println("\nCase 2: coins=[2], amount=3");
        System.out.println("Expected: -1");
        printResult(solver.coinChange(coins2, amount2));

        // Case 3: single coin matches amount
        int[] coins3 = { 10 };
        int amount3 = 10;
        System.out.println("\nCase 3: coins=[10], amount=10");
        System.out.println("Expected: 1");
        printResult(solver.coinChange(coins3, amount3));

        // Case 4: amount is 0
        int[] coins4 = { 1, 2, 5 };
        int amount4 = 0;
        System.out.println("\nCase 4: coins=[1,2,5], amount=0");
        System.out.println("Expected: 0");
        printResult(solver.coinChange(coins4, amount4));

        // Case 5: multiple coins needed
        int[] coins5 = { 2, 3, 5 };
        int amount5 = 9;
        System.out.println("\nCase 5: coins=[2,3,5], amount=9");
        System.out.println("Expected: 2 (3+3+3 or 5+2+2)");
        printResult(solver.coinChange(coins5, amount5));

        // Case 6: greedy doesn't work
        int[] coins6 = { 3, 4 };
        int amount6 = 6;
        System.out.println("\nCase 6: coins=[3,4], amount=6");
        System.out.println("Expected: 2 (3+3)");
        printResult(solver.coinChange(coins6, amount6));

        // Case 7: larger amount with many coins
        int[] coins7 = { 1, 3, 4 };
        int amount7 = 6;
        System.out.println("\nCase 7: coins=[1,3,4], amount=6");
        System.out.println("Expected: 2 (3+3)");
        printResult(solver.coinChange(coins7, amount7));

        // Case 8: no coin of value 1, amount unreachable
        int[] coins8 = { 2, 5 };
        int amount8 = 3;
        System.out.println("\nCase 8: coins=[2,5], amount=3");
        System.out.println("Expected: -1");
        printResult(solver.coinChange(coins8, amount8));
    }
}
