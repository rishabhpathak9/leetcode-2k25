package com.zenith.patterns.topKElements;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(nums, k);
        System.out.println("Kth largest element: " + result);
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int val : nums) {
            heap.add(val);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

}
