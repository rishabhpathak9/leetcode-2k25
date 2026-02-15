package com.zenith.patterns.monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // expected output: [-1, 3, -1]
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int key = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= key) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.put(key, -1);
            } else {
                result.put(key, stack.peek());
            }
            stack.push(key);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result.get(nums1[i]);
        }
        return nums1;
    }
}
