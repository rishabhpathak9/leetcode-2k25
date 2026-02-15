package com.zenith.patterns.dynamicProgramming.knapsack01;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    /**
     * LeetCode 416: Partition Equal Subset Sum (practice scaffold)
     *
     * Given a non-empty array nums containing only positive integers, find if the
     * array
     * can be partitioned into two subsets such that the sum of elements in both
     * subsets is equal.
     *
     * This file provides sample inputs and an empty `canPartition` method for
     * practice.
     */

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        Arrays.fill(prev, false);
        prev[0] = true;

        for (int i = 1; i <= n; i++) {
            curr[0] = false;
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    curr[j] = prev[j];
                } else {
                    curr[j] = prev[j - nums[i - 1]] || prev[j];
                }
            }

            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[sum];
    }

    private static void printResult(boolean result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solver = new PartitionEqualSubsetSum();

        // Case 1: classic positive case
        int[] nums1 = { 1, 5, 11, 5 };
        System.out.println("Case 1: [1,5,11,5]  Expected: true");
        printResult(solver.canPartition(nums1));

        // Case 2: cannot partition
        int[] nums2 = { 1, 2, 3, 5 };
        System.out.println("\nCase 2: [1,2,3,5]  Expected: false");
        printResult(solver.canPartition(nums2));

        // Case 3: all ones, even count
        int[] nums3 = { 1, 1, 1, 1, 1, 1 };
        System.out.println("\nCase 3: [1,1,1,1,1,1]  Expected: true");
        printResult(solver.canPartition(nums3));

        // Case 4: single large element
        int[] nums4 = { 100 };
        System.out.println("\nCase 4: [100]  Expected: false");
        printResult(solver.canPartition(nums4));

        // Case 5: another positive case
        int[] nums5 = { 2, 3, 7, 8 };
        System.out.println("\nCase 5: [2,3,7,8]  Expected: true (7+3 == 8+2)");
        printResult(solver.canPartition(nums5));
    }
}
