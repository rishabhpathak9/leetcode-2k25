package com.zenith.patterns.dynamicProgramming.knapsack01;

public class TargetSum {

    /**
     * LeetCode 494: Target Sum (practice scaffold)
     *
     * You are given an integer array nums and an integer target.
     * You want to build an expression out of nums by adding one of the symbols '+'
     * or '-'
     * before each integer in nums and then concatenate all the integers.
     *
     * For example, if nums = [2,1], you can add a '+' before 2 and a '-' before 1
     * and
     * concatenate them to build the expression "+2-1".
     *
     * Return the number of different expressions that you can build, which
     * evaluates to target.
     *
     * Example 1:
     * Input: nums = [1,1,1,1,1], target = 3
     * Output: 5
     * Explanation:
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * Example 2:
     * Input: nums = [1], target = 1
     * Output: 1
     *
     * Example 3:
     * Input: nums = [1], target = -1
     * Output: 1
     */

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        
        int subsetSum = (sum + target) / 2;
        
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        TargetSum solver = new TargetSum();

        // Case 1: classic example
        int[] nums1 = { 1, 1, 1, 1, 1 };
        int target1 = 3;
        System.out.println("Case 1: nums=[1,1,1,1,1], target=3");
        System.out.println("Expected: 5");
        printResult(solver.findTargetSumWays(nums1, target1));

        // Case 2: single element, positive target
        int[] nums2 = { 1 };
        int target2 = 1;
        System.out.println("\nCase 2: nums=[1], target=1");
        System.out.println("Expected: 1");
        printResult(solver.findTargetSumWays(nums2, target2));

        // Case 3: single element, negative target
        int[] nums3 = { 1 };
        int target3 = -1;
        System.out.println("\nCase 3: nums=[1], target=-1");
        System.out.println("Expected: 1");
        printResult(solver.findTargetSumWays(nums3, target3));

        // Case 4: cannot reach target
        int[] nums4 = { 1, 2, 3 };
        int target4 = 10;
        System.out.println("\nCase 4: nums=[1,2,3], target=10");
        System.out.println("Expected: 0 (impossible to reach 10)");
        printResult(solver.findTargetSumWays(nums4, target4));

        // Case 5: multiple elements
        int[] nums5 = { 1, 2, 1 };
        int target5 = 0;
        System.out.println("\nCase 5: nums=[1,2,1], target=0");
        System.out.println("Expected: 3 (+1+2-1=2, +1-2+1=0, -1+2-1=0)");
        printResult(solver.findTargetSumWays(nums5, target5));

        // Case 6: all same numbers
        int[] nums6 = { 5, 5, 5 };
        int target6 = 15;
        System.out.println("\nCase 6: nums=[5,5,5], target=15");
        System.out.println("Expected: 1 (+5+5+5=15)");
        printResult(solver.findTargetSumWays(nums6, target6));

        // Case 7: with zeros
        int[] nums7 = { 0, 1, 1 };
        int target7 = 1;
        System.out.println("\nCase 7: nums=[0,1,1], target=1");
        System.out.println("Expected: 4 (zero can be + or -, then +1+1 or +1-1 or -1+1)");
        printResult(solver.findTargetSumWays(nums7, target7));

        // Case 8: negative target
        int[] nums8 = { 1, 2, 3, 4, 5 };
        int target8 = -5;
        System.out.println("\nCase 8: nums=[1,2,3,4,5], target=-5");
        System.out.println("Expected: various (need to check)");
        printResult(solver.findTargetSumWays(nums8, target8));
    }
}
