package com.zenith.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * LeetCode 78: Subsets
     * 
     * Given an integer array nums of unique elements, return all the possible subsets (the power set).
     * The solution set must not contain duplicate subsets. You can return the solution in any order.
     * 
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 
     * Example 2:
     * Input: nums = [0]
     * Output: [[],[0]]
     * 
     * Example 3:
     * Input: nums = [1,2]
     * Output: [[],[1],[2],[1,2]]
     */
    static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int start, List<Integer> arr){

        res.add(List.copyOf(arr));

        for(int i = start; i< nums.length; i++){
                arr.add(nums[i]);
                helper(nums, i+1, arr);
                arr.remove(arr.size()-1);
            }
    }

    private static void printResult(List<List<Integer>> result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();

        // Case 1: Three distinct integers
        int[] nums1 = {1, 2, 3};
        System.out.println("Case 1: nums = [1,2,3]");
        System.out.println("Expected: 8 subsets (2^3 = 8)");
        List<List<Integer>> result1 = solver.subsets(nums1);
        System.out.println("Actual count: " + result1.size());
        printResult(result1);

        // Case 2: Single element
        res = new ArrayList<>();
        int[] nums2 = {0};
        System.out.println("\nCase 2: nums = [0]");
        System.out.println("Expected: 2 subsets (2^1 = 2)");
        List<List<Integer>> result2 = solver.subsets(nums2);
        System.out.println("Actual count: " + result2.size());
        printResult(result2);

        // Case 3: Two distinct integers
        res = new ArrayList<>();
        int[] nums3 = {1, 2};
        System.out.println("\nCase 3: nums = [1,2]");
        System.out.println("Expected: 4 subsets (2^2 = 4)");
        List<List<Integer>> result3 = solver.subsets(nums3);
        System.out.println("Actual count: " + result3.size());
        printResult(result3);

        // Case 4: Four distinct integers
        res = new ArrayList<>();
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("\nCase 4: nums = [1,2,3,4]");
        System.out.println("Expected: 16 subsets (2^4 = 16)");
        List<List<Integer>> result4 = solver.subsets(nums4);
        System.out.println("Actual count: " + result4.size());
        printResult(result4);

        // Case 5: Empty array
        res = new ArrayList<>();
        int[] nums5 = {};
        System.out.println("\nCase 5: nums = [] (empty)");
        System.out.println("Expected: 1 subset (empty set)");
        List<List<Integer>> result5 = solver.subsets(nums5);
        System.out.println("Actual count: " + result5.size());
        printResult(result5);
    }
}