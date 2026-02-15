package com.zenith.patterns.dynamicProgramming.stateMachineDP;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 309: Best Time to Buy and Sell Stock with Cooldown
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following constraints:
 * - After you sell your stock, you cannot buy stock on the next day (cooldown one day).
 * - You cannot engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeBuySellCooldown {
    int n ;
    int[] p;
    Map<String, Integer> memo;
    
    public int maxProfit(int[] prices) {
        n = prices.length;
        p = prices;
        memo = new HashMap<>();
        return dp(0, 1);

    }

    private int dp(int i, int buy) {
        if (i>=n) return 0;
        if(memo.containsKey(i+" "+buy)) return memo.get(i+" "+buy);
        int ans;
        if(buy == 0){
            ans = Math.max(dp(i+1, 0), dp(i+2, 1)+p[i]);
        } else{
            ans = Math.max(dp(i+1, 0) - p[i], dp(i+1, 1));
        }
        memo.put(i+" "+buy, ans);
        return ans;
    }

    public static void main(String[] args) {
        BestTimeBuySellCooldown btbsc = new BestTimeBuySellCooldown();

        System.out.println("Test 1: prices = [3,1,4]");
        System.out.println("Output: " + btbsc.maxProfit(new int[]{3,1,4}));
        System.out.println("Expected: 3\n");

        System.out.println("Test 2: prices = [1]");
        System.out.println("Output: " + btbsc.maxProfit(new int[]{1}));
        System.out.println("Expected: 0\n");

        System.out.println("Test 3: prices = [1,2,3,0,2]");
        System.out.println("Output: " + btbsc.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println("Expected: 3\n");
    }
}
