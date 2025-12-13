package com.zenith.something.topKElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthFrequentElement {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = findKthFrequents(nums, k);
        for (int el : result) {
            System.out.println(el);
        }
    }

    private static int[] findKthFrequents(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int el : nums) {
            if (!freq.containsKey(el)) {
                freq.put(el, 0);
            }
            freq.put(el, freq.get(el) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        freq.keySet().forEach(key -> {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        });
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }

}
