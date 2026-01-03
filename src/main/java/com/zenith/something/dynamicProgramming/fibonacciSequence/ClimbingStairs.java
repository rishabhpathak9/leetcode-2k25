package com.zenith.something.dynamicProgramming.fibonacciSequence;

public class ClimbingStairs {

    /**
     * LeetCode 70: Climbing Stairs (practice scaffold)
     * 
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can climb 1 or 2 steps. In how many distinct ways can you climb
     * to the top?
     * 
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: 1 step + 1 step, or 2 steps
     * 
     * Example 2:
     * Input: n = 3
     * Output: 3
     * Explanation: 1 step + 1 step + 1 step, or 1 step + 2 steps, or 2 steps + 1
     * step
     * 
     * Example 3:
     * Input: n = 4
     * Output: 5
     * Explanation: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]
     * 
     * Constraints:
     * - 1 <= n <= 45
     */

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int nMinus2 = 1;
        int nMinus1 = 2;

        for (int i = 3; i <= n; i++) {
            int temp = nMinus2 + nMinus1;
            nMinus2 = nMinus1;
            nMinus1 = temp;
        }
        return nMinus1;
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        ClimbingStairs solver = new ClimbingStairs();

        // Case 1: n = 1
        int n1 = 1;
        System.out.println("Case 1: n = " + n1);
        System.out.println("Expected: 1 (only one way: [1])");
        printResult(solver.climbStairs(n1));

        // Case 2: n = 2
        int n2 = 2;
        System.out.println("\nCase 2: n = " + n2);
        System.out.println("Expected: 2 (ways: [1,1], [2])");
        printResult(solver.climbStairs(n2));

        // Case 3: n = 3
        int n3 = 3;
        System.out.println("\nCase 3: n = " + n3);
        System.out.println("Expected: 3 (ways: [1,1,1], [1,2], [2,1])");
        printResult(solver.climbStairs(n3));

        // Case 4: n = 4
        int n4 = 4;
        System.out.println("\nCase 4: n = " + n4);
        System.out.println("Expected: 5 (ways: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2])");
        printResult(solver.climbStairs(n4));

        // Case 5: n = 5
        int n5 = 5;
        System.out.println("\nCase 5: n = " + n5);
        System.out.println("Expected: 8 (Fibonacci pattern continues)");
        printResult(solver.climbStairs(n5));

        // Case 6: n = 10
        int n6 = 10;
        System.out.println("\nCase 6: n = " + n6);
        System.out.println("Expected: 89");
        printResult(solver.climbStairs(n6));

        // Case 7: n = 45 (large input)
        int n7 = 45;
        System.out.println("\nCase 7: n = " + n7);
        System.out.println("Expected: 1134903170");
        printResult(solver.climbStairs(n7));
    }
}
