package com.zenith.something.modifiedBinarySearch;

public class MinInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMin(nums, 0, nums.length - 1);
        System.out.println("Min is: " + result);
    }

    private static int findMin(int[] nums, int beg, int end) {
        if (nums[beg] < nums[end]) {
            return nums[beg];
        }
        if (end - beg < 2) {
            return Math.min(nums[beg], nums[end]);
        }
        int mid = (beg + end) / 2;
        if (nums[beg] < nums[mid]) {
            return findMin(nums, mid, end);
        } else {
            return findMin(nums, beg, mid);
        }

    }
}
