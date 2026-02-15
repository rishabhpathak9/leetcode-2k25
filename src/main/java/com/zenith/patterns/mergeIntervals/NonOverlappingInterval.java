package com.zenith.patterns.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int result = noOfNonOverlappingIntervals(intervals);
        System.out.println(result);
    }

    public static int noOfNonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int n = intervals.length;
        int count = 1;
        int lastendTime = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastendTime) {
                count++;
                lastendTime = intervals[i][1];
            }
        }
        return n - count;

    }
}
