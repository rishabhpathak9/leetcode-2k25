package com.zenith.patterns.dynamicProgramming.bitmasking;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode 847: Shortest Path Visiting All Nodes
 *
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
 * You are given an array graph where graph[u] is an array of nodes that u is
 * adjacent to.
 * Return the length of the shortest path that visits every node. You may start
 * and stop at any node, you may revisit nodes multiple times, and you may reuse
 * edges.
 *
 * Approach: multi-source BFS over states (node, visitedMask). Because nodes may
 * be revisited, a plain DFS over (node, mask) cycles forever; BFS explores
 * states level by level, so the first state whose mask covers every node gives
 * the shortest length. Time O(n^2 * 2^n), space O(n * 2^n).
 */
public class ShortestPathAllNodes {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        int fullMask = (1 << n) - 1;

        boolean[][] seen = new boolean[1 << n][n];
        Queue<int[]> queue = new ArrayDeque<>(); // {node, mask}
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] { i, 1 << i });
            seen[1 << i][i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            for (int size = queue.size(); size > 0; size--) {
                int[] cur = queue.poll();
                for (int next : graph[cur[0]]) {
                    int mask = cur[1] | (1 << next);
                    if (mask == fullMask) return steps;
                    if (!seen[mask][next]) {
                        seen[mask][next] = true;
                        queue.offer(new int[] { next, mask });
                    }
                }
            }
        }
        return -1; // unreachable for a connected graph
    }

    public static void main(String[] args) {
        ShortestPathAllNodes span = new ShortestPathAllNodes();

        System.out.println("Test 1: graph = [[1,2,3],[0],[0],[0]]");
        int[][] graph1 = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };
        System.out.println("Output: " + span.shortestPathLength(graph1));
        System.out.println("Expected: 4\n");

        System.out.println("Test 2: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]");
        int[][] graph2 = { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };
        System.out.println("Output: " + span.shortestPathLength(graph2));
        System.out.println("Expected: 4\n");

        System.out.println("Test 3: graph = [[1],[0]]");
        int[][] graph3 = { { 1 }, { 0 } };
        System.out.println("Output: " + span.shortestPathLength(graph3));
        System.out.println("Expected: 1\n");
    }
}
