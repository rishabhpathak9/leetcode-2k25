package com.zenith.something.slidingWindow;

public class MaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        int i = 0;
        double sum = 0;
        for(i=0; i<k; i++){
            sum+= nums[i];
        }
        double maxSum = sum;
        for(i=k; i<nums.length; i++){
            sum-= nums[i-k];
            sum+= nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum/k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 3, 10};
        int k = 5;
        double result = findMaxAverage(nums, k);
        System.out.println(result);
    }
}
