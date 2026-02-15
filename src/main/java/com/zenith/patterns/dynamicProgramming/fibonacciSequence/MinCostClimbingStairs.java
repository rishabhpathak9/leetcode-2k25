package com.zenith.patterns.dynamicProgramming.fibonacciSequence;

public class MinCostClimbingStairs {

    /**
     * LeetCode 746: Min Cost Climbing Stairs (practice scaffold)
     * 
     * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
     * Once you pay the cost, you can climb one or two steps.
     * 
     * You can either start from the step with index 0, or the step with index 1.
     * Return the minimum cost to reach the top of the floor.
     * 
     * Example 1:
     * Input: cost = [10,15,20]
     * Output: 15
     * Explanation: You start at index 1, pay 15, climb two steps to reach the top.
     * The total cost is 15.
     * 
     * Example 2:
     * Input: cost = [1,100,1,1,1,100,1,1,100,1]
     * Output: 6
     * Explanation: You will climb on the path as 0->2->3->4->6->9->10 in minimum cost of 6.
     * 
     * Constraints:
     * - 2 <= cost.length <= 1000
     * - 0 <= cost[i] <= 999
     */

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int cur = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = cur;
        }

        return Math.min(prev1, prev2);
    }
    

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solver = new MinCostClimbingStairs();

        // Case 1: Simple example
        int[] cost1 = {10, 15, 20};
        System.out.println("Case 1: cost = [10, 15, 20]");
        System.out.println("Expected: 15 (start at index 1, pay 15, climb two steps)");
        printResult(solver.minCostClimbingStairs(cost1));

        // Case 2: Example with larger path
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("\nCase 2: cost = [1,100,1,1,1,100,1,1,100,1]");
        System.out.println("Expected: 6 (path: 0->2->3->4->6->9->10)");
        printResult(solver.minCostClimbingStairs(cost2));

        // Case 3: Two steps only
        int[] cost3 = {5, 10};
        System.out.println("\nCase 3: cost = [5, 10]");
        System.out.println("Expected: 5 (start at index 0, climb two steps)");
        printResult(solver.minCostClimbingStairs(cost3));

        // Case 4: Increasing costs
        int[] cost4 = {1, 2, 3, 4, 5};
        System.out.println("\nCase 4: cost = [1, 2, 3, 4, 5]");
        System.out.println("Expected: 6 (take smaller steps: 1->1->1 = 3, but optimal is 1->2->3)");
        printResult(solver.minCostClimbingStairs(cost4));

        // Case 5: All same cost
        int[] cost5 = {5, 5, 5, 5};
        System.out.println("\nCase 5: cost = [5, 5, 5, 5]");
        System.out.println("Expected: 10 (either 5+5 or 5+5, all paths same)");
        printResult(solver.minCostClimbingStairs(cost5));

        // Case 6: One very expensive step
        int[] cost6 = {1, 999, 1, 1};
        System.out.println("\nCase 6: cost = [1, 999, 1, 1]");
        System.out.println("Expected: 3 (skip expensive step 999)");
        printResult(solver.minCostClimbingStairs(cost6));

        // Case 7: Alternating pattern
        int[] cost7 = {1, 5, 2, 5, 1};
        System.out.println("\nCase 7: cost = [1, 5, 2, 5, 1]");
        System.out.println("Expected: 4 (path: 0->2->4)");
        printResult(solver.minCostClimbingStairs(cost7));

        // Case 8: Large input
        int[] cost8 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 100};
        System.out.println("\nCase 8: cost = [1,1,1,1,1,1,1,1,1,100]");
        System.out.println("Expected: 10 (9 steps of cost 1)");
        printResult(solver.minCostClimbingStairs(cost8));
    }
}
