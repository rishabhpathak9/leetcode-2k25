package com.zenith.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /**
     * LeetCode 46: Permutations
     * 
     * Given an array nums of distinct integers, return all the possible permutations.
     * You can return the answer in any order.
     * 
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 
     * Example 2:
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     * 
     * Example 3:
     * Input: nums = [1]
     * Output: [[1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void helper(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                helper(nums, current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    private static void printResult(List<List<Integer>> result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();

        // Case 1: Three distinct integers
        int[] nums1 = {1, 2, 3};
        System.out.println("Case 1: nums = [1,2,3]");
        System.out.println("Expected: 6 permutations (3! = 6)");
        List<List<Integer>> result1 = solver.permute(nums1);
        System.out.println("Actual: ");
        printResult(result1);

        // Case 2: Two distinct integers
        int[] nums2 = {0, 1};
        System.out.println("\nCase 2: nums = [0,1]");
        System.out.println("Expected: 2 permutations (2! = 2)");
        List<List<Integer>> result2 = solver.permute(nums2);
        System.out.println("Actual: ");
        printResult(result2);

        // Case 3: Single element
        int[] nums3 = {1};
        System.out.println("\nCase 3: nums = [1]");
        System.out.println("Expected: 1 permutation");
        List<List<Integer>> result3 = solver.permute(nums3);
        System.out.println("Actual: ");
        printResult(result3);

        // Case 4: Four distinct integers
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("\nCase 4: nums = [1,2,3,4]");
        System.out.println("Expected: 24 permutations (4! = 24)");
        List<List<Integer>> result4 = solver.permute(nums4);
        System.out.println("Actual count: " + result4.size());
        printResult(result4);

        // Case 5: Two same values (edge case - not in actual problem, but good to test)
        int[] nums5 = {1, 1};
        System.out.println("\nCase 5: nums = [1,1] (edge case)");
        System.out.println("Expected: 2 permutations (with duplicates)");
        List<List<Integer>> result5 = solver.permute(nums5);
        System.out.println("Actual: ");
        printResult(result5);
    }
}
