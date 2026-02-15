package com.zenith.patterns.dynamicProgramming.stateMachineDP;

/**
 * LeetCode 123: Best Time to Buy and Sell Stock III
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockIII {

    int p [];
    int n;

    public int maxProfit(int[] prices) {
        p = prices;
        n = p.length;
        return dp(0, 2, 1);
    }

    private int dp(int i, int k, int canBuy) {
        if(k == 0 || i==n) return 0;
        
        int ans;
        if(canBuy== 1){
            ans = Math.max(dp(i+1, k, 0)-p[i], dp(i+1, k, 1));
        } else {
            ans = Math.max(dp(i+1, k-1, 1)+p[i] , dp(i+1, k, 0));
        }
        return ans;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockIII btbsiii = new BestTimeBuySellStockIII();

        System.out.println("Test 1: prices = [3,3,5,0,0,3,1,4]");
        System.out.println("Output: " + btbsiii.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println("Expected: 4\n");

        System.out.println("Test 2: prices = [1,2,3,4,5]");
        System.out.println("Output: " + btbsiii.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println("Expected: 4\n");

        System.out.println("Test 3: prices = [7,6,4,3,1]");
        System.out.println("Output: " + btbsiii.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println("Expected: 0\n");

        System.out.println("Test 4: prices = [1]");
        System.out.println("Output: " + btbsiii.maxProfit(new int[]{1}));
        System.out.println("Expected: 0\n");
    }
}
