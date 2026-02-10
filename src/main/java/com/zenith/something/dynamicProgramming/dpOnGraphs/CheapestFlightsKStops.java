package com.zenith.something.dynamicProgramming.dpOnGraphs;

import java.util.Arrays;

/**
 * LeetCode 787: Cheapest Flights Within K Stops
 *
 * There are n cities connected by m flights. Each flight starts from city u and
 * arrives at v with a price w. Now given all the cities and flights, together with
 * starting city src and the destination dst, your task is to find the cheapest price
 * from src to dst with up to k stops. If there is no such route, output -1.
 */
public class CheapestFlightsKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] cur = new int[n];
        int inf = 1000001;
        Arrays.fill(prev, inf);
        Arrays.fill(cur, inf);
        prev[src] = 0;
        cur[src] = 0;
        for(int i = 0; i<k+1; i++){
            for(int[] e : flights){
                if(prev[e[0]]!= inf){
                    cur[e[1]] = Math.min(prev[e[0]]+e[2], cur[e[1]]);
                }
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
        for(int el : cur){
        System.out.print(el+" ");}
        if(prev[dst]==inf) return -1;
        return prev[dst];
    }

    public static void main(String[] args) {
        CheapestFlightsKStops cfks = new CheapestFlightsKStops();

        System.out.println("Test 1: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1");
        int[][] flights1 = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println("Output: " + cfks.findCheapestPrice(4, flights1, 0, 3, 1));
        System.out.println("Expected: 700\n");

        System.out.println("Test 2: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1");
        int[][] flights2 = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println("Output: " + cfks.findCheapestPrice(3, flights2, 0, 2, 1));
        System.out.println("Expected: 200\n");

        System.out.println("Test 3: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0");
        int[][] flights3 = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println("Output: " + cfks.findCheapestPrice(3, flights3, 0, 2, 0));
        System.out.println("Expected: 500\n");
    }
}
