package com.zenith.patterns.topKElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

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
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        Set<String> visited = new HashSet<>();
        heap.add(new int[]{0, 0});
        visited.add("0#0");
        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0 && !heap.isEmpty()) {
            int[] smallestPair = heap.poll();
            int i = smallestPair[0];
            int j = smallestPair[1];

            result.add(List.of(nums1[i], nums2[j]));
            if (i + 1 < nums1.length && !visited.contains((i + 1) + "#" + j)) {
                heap.add(new int[]{i + 1, j});
                visited.add((i + 1) + "#" + j);
            }
            if (j + 1 < nums2.length && !visited.contains(i + "#" + (j + 1))) {
                visited.add(i + "#" + (j + 1));
                heap.add(new int[]{i, j + 1});
            }
        }
        return result;
    }
}
