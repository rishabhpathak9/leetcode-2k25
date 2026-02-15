package com.zenith.patterns.dynamicProgramming.dpOnGraphs;

/**
 * LeetCode 1334: Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * There are n cities numbered from 0 to n-1. Given an array edges where
 * edges[i] = [fromi, toi, weighti] represents a bidirectional edge between
 * cities with the given weight. Given the integer distanceThreshold, return the
 * city with the smallest number of cities that are reachable through some path
 * and whose distance is at most distanceThreshold. If there are multiple cities
 * with the same smallest number of neighbors at a distance threshold, return the city with the greatest number.
 */
public class FindCitySmallestNeighbors {

    int[][] g,dp;
    int n, maxD;
    int inf = 100000001;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        g = new int[n][n];
        dp = new int[n][n];
        maxD = distanceThreshold;

        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                g[i][j] = inf;
                dp[i][j] = inf;
            }
        }
        for(int[] e : edges){
            g[e[0]][e[1]] = e[2];
            dp[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
            dp[e[1]][e[0]] = e[2];
        }

        for(int k = 0; k<n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j<n; j++){
                    dp[i][j] = Math.min(dp[i][k]+dp[k][j], dp[i][j]);
                }
            }
        }

        int res = inf;
        int ans = -1;
        for(int i = 0; i < n; i++){
            int c = 0;
            for(int j = 0; j< n; j++){
                if(i!=j && dp[i][j] <= maxD) 
                    c++;
            }
            if(c<=res){
                res = c;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindCitySmallestNeighbors fcsn = new FindCitySmallestNeighbors();

        System.out.println("Test 1: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4");
        int[][] edges1 = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println("Output: " + fcsn.findTheCity(4, edges1, 4));
        System.out.println("Expected: 3\n");

        System.out.println("Test 2: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2");
        int[][] edges2 = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        System.out.println("Output: " + fcsn.findTheCity(5, edges2, 2));
        System.out.println("Expected: 0\n");
    }
}
