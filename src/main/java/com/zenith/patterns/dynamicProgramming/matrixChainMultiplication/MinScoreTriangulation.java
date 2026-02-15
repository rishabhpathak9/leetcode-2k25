package com.zenith.patterns.dynamicProgramming.matrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1039: Minimum Score Triangulation of Polygon
 *
 * You have a convex n-sided polygon and you triangulate it into n-2 triangles.
 * The score of a triangulation is the sum of the products of the lengths of
 * each triangle's edges.
 * Two triangulations of a polygon have the same set of edges except the
 * diagonals.
 * Return the lowest score of a triangulation.
 */
public class MinScoreTriangulation {

    public int minScoreTriangulation(int[] values) {
        Map<String, Integer> map = new HashMap<>();
        int result = dp(values, 0, values.length - 1, map);
        return result;
    }

    private int dp(int[] arr, int i, int j, Map<String, Integer> map) {
        if (map.containsKey(i + "#" + j)) {
            return map.get(i + "#" + j);
        }
        if (i + 2 == j) {
            return arr[i] * arr[i + 1] * arr[j];
        }
        if (i + 2 > j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int temp = arr[i] * arr[k] * arr[j] + dp(arr, i, k, map) + dp(arr, k, j, map);
            min = Math.min(min, temp);
        }
        map.put(i + "#" + j, min);
        return min;
    }

    public static void main(String[] args) {
        MinScoreTriangulation mst = new MinScoreTriangulation();

        System.out.println("Test 1: values = [1,2,3]");
        System.out.println("Output: " + mst.minScoreTriangulation(new int[] { 1, 2, 3 }));
        System.out.println("Expected: 6\n");

        System.out.println("Test 2: values = [3,7,4,5]");
        System.out.println("Output: " + mst.minScoreTriangulation(new int[] { 3, 7, 4, 5 }));
        System.out.println("Expected: 144\n");

        System.out.println("Test 3: values = [1,3,1,4,1,5]");
        System.out.println("Output: " + mst.minScoreTriangulation(new int[] { 1, 3, 1, 4, 1, 5 }));
        System.out.println("Expected: 13\n");
    }
}
