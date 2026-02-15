package com.zenith.patterns.modifiedBinarySearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        int result = search(nums, target, 0, nums.length - 1);
        System.out.println("Index of " + target + ": " + result);
    }

    private static int search(int[] nums, int target, int beg, int end) {
        if (beg == end) {
            return target == nums[beg] ? beg : -1;
        }
        int mid = (beg + end) / 2;
        if (nums[beg] < nums[mid]) {
            if (nums[beg] <= target && target <= nums[mid]) {
                return search(nums, target, beg, mid);
            } else {
                return search(nums, target, mid + 1, end);
            }
        } else if (nums[mid] < nums[end]) {
            if (nums[mid] <= target && target <= nums[end]) {
                return search(nums, target, mid, end);
            } else {
                return search(nums, target, beg, mid);
            }
        } else {
            if (nums[beg] == target) {
                return beg;
            } else if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }

    }
}
