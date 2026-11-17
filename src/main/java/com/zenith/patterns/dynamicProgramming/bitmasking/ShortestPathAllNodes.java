package com.zenith.patterns.dynamicProgramming.bitmasking;


/**
 * LeetCode 847: Shortest Path Visiting All Nodes
 *
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
 * You are given an array graph where graph[u] is an array of nodes that u is
 * adjacent to.
 * More formally, for each v in graph[u], there is an undirected edge between u
 * and v.
 * The graph has the following properties:
 * - There are no self-edges (graph[u] does not contain u).
 * - There are no parallel edges (graph[u] does not contain duplicate values).
 * - If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * - The graph may not be connected, meaning there may be two nodes u and v with
 * no path between them.
 * A path that visits every node exactly once is called a Hamiltonian path.
 * Return the length of the shortest Hamiltonian path of the graph. If no such
 * path exists, return -1.
 */
public class ShortestPathAllNodes {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        int[][] memo = new int[1 << n][n];

        // Initialize memo with -1 (uncomputed)
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dfs(i, 1 << i, graph, memo, fullMask));
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int node, int mask, int[][] graph, int[][] memo, int fullMask) {
        if (mask == fullMask) {
            return 0;
        }

        if (memo[mask][node] != -1) {
            return memo[mask][node];
        }

        int result = Integer.MAX_VALUE;
        for (int neighbor : graph[node]) {
            int newMask = mask | (1 << neighbor);
            int subResult = dfs(neighbor, newMask, graph, memo, fullMask);
            if (subResult != Integer.MAX_VALUE) {
                result = Math.min(result, subResult + 1);
            }
        }

        memo[mask][node] = result;
        return result;
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
