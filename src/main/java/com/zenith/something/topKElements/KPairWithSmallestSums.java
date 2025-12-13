package com.zenith.something.topKElements;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPairWithSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = pairWithSmallestSums(nums1, nums2, k);
        for (List<Integer> el : result) {
            System.out.println(el.get(0) + " " + el.get(1));
        }
    }

    private static List<List<Integer>> pairWithSmallestSums(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(a -> -1 * (a.get(0) + a.get(1))));
        for (int el1 : nums1) {
            for (int el2 : nums2) {
                heap.add(List.of(el1, el2));
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.stream().toList();
    }

}
