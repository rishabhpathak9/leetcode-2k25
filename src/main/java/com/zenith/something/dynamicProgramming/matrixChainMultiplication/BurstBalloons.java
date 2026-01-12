package com.zenith.something.dynamicProgramming.matrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 312: Burst Balloons
 *
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons. When you burst balloon i, you get nums[left] * nums[i] *
 * nums[right]
 * coins. Find the maximum coins you can collect by bursting the balloons
 * wisely.
 */
public class BurstBalloons {

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public int maxCoins(int[] nums) {
        int n = nums.length;

        Map<String, Integer> map = new HashMap<>();
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        return dp(arr, 0, n + 1, map);
    }

    private int dp(int[] arr, int left, int right, Map<String, Integer> map) {
        if (left + 1 == right)
            return 0;
        if (map.containsKey(left + "#" + right)) {
            return map.get(left + "#" + right);
        }
        int max = 0;
        for (int k = left + 1; k < right; k++) {
            int part1 = map.getOrDefault(left + "#" + k, dp(arr, left, k, map));
            int part2 = map.getOrDefault(k + "#" + right,dp(arr, k, right, map));
            int coins = arr[left] * arr[k] * arr[right]
                    + part1
                    + part2;
            max = Math.max(max, coins);
        }
        map.put(left + "#" + right, max);
        return max;
    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();

        System.out.println("Test 1: nums = [3,1,5,8]");
        System.out.println("Output: " + bb.maxCoins(new int[] { 3, 1, 5, 8 }));
        System.out.println("Expected: 167\n");

        System.out.println("Test 2: nums = [1,5]");
        System.out.println("Output: " + bb.maxCoins(new int[] { 1, 5 }));
        System.out.println("Expected: 10\n");

        System.out.println("Test 3: nums = [1]");
        System.out.println("Output: " + bb.maxCoins(new int[] { 1 }));
        System.out.println("Expected: 1\n");
    }
}
