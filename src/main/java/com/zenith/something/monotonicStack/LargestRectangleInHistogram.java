package com.zenith.something.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        // int[] nums = {2, 1, 2};

        System.out.println(largestRectangle(nums));
    }

    public static int largestRectangle(int[] nums) {
        int max = 0, n = nums.length;
        Deque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int val = i == n ? 0 : nums[i];
            int left = i;
            while (!stack.isEmpty() && val < stack.peek().getHeight()) {
                Pair poppedItem = stack.pop();
                int idx = poppedItem.getIndex();
                int height = poppedItem.getHeight();
                max = Math.max(max, height * (i - idx));
                left = idx;
            }
            stack.push(new Pair(left, val));
            max = Integer.max(max, val);
        }

        return max;

    }
}

class Pair {

    private int index;
    private int height;

    protected Pair(int left, int right) {
        this.index = left;
        this.height = right;
    }

    protected int getIndex() {
        return index;
    }

    protected int getHeight() {
        return height;
    }
}
