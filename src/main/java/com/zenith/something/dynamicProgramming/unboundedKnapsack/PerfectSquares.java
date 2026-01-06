package com.zenith.something.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

/**
 * LeetCode 279: Perfect Squares
 * 
 * Given an integer n, return the least number of perfect square numbers
 * which sum to n.
 * 
 * A perfect square is an integer that is the square of an integer.
 * For example, 1, 4, 9, 16, 25 are perfect squares (1^2, 2^2, 3^2, 4^2, 5^2)
 */
public class PerfectSquares {

    /**
     * Sample Test Cases:
     * 
     * Example 1:
     * Input: n = 7
     * Output: 2
     * Explanation: 7 = 4 + 3, and 3 = 1 + 1 + 1, so the least number is 2 (4 + 1 +
     * 1 + 1)
     * Or: 7 = 4 + 1 + 1 + 1 (4 perfect squares minimum: 2^2 + 1^2 + 1^2 + 1^2)
     * Actually: 7 = 4 + 3 can't be simplified further, so answer is 2 (using DP)
     * 
     * Example 2:
     * Input: n = 2
     * Output: 2
     * Explanation: 2 = 1 + 1, two perfect squares
     * 
     * Example 3:
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9 (2^2 + 3^2)
     * 
     * Example 4:
     * Input: n = 1
     * Output: 1
     * Explanation: 1 = 1^2, one perfect square
     * 
     * Example 5:
     * Input: n = 4
     * Output: 1
     * Explanation: 4 = 2^2, one perfect square
     * 
     * Example 6:
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4 (2^2 + 2^2 + 2^2)
     * 
     * Example 7:
     * Input: n = 100
     * Output: 1
     * Explanation: 100 = 10^2, one perfect square
     * 
     * Example 8:
     * Input: n = 99
     * Output: 2
     * Explanation: 99 = 81 + 18 = 9^2 + 18 (18 = 9 + 9 = 3^2 + 3^2)
     * So answer is 3 (9^2 + 3^2 + 3^2)
     * 
     * Example 9:
     * Input: n = 15
     * Output: 4
     * Explanation: 15 = 9 + 4 + 1 + 1 (3^2 + 2^2 + 1^2 + 1^2)
     * 
     * Example 10:
     * Input: n = 32
     * Output: 2
     * Explanation: 32 = 16 + 16 (4^2 + 4^2)
     */

    public int numSquares(int n) {
        int len = ((int) Math.sqrt(n));
        int dp[] = new int[n+1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=len; j++){
                int jthSq = j*j;
                if(i>=jthSq){
                    dp[i] = Math.min(dp[i], dp[i-jthSq]+1);
                }
            }
        }
        dp(len,n);
        return dp[n];
    }

    private int dp(int len, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return 10001;
        }
        int min = 10001;
        for (int j = 0; j < len; j++) {
            int ithSq = (j+1)*(j+1);
            if (n >= ithSq)
                min = Math.min(min, dp(len, n - ithSq) + 1);
        }
        return min;
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();

        // Test cases
        System.out.println("Test 1: n = 7");
        System.out.println("Output: " + ps.numSquares(7));
        System.out.println("Expected: 2\n");

        System.out.println("Test 2: n = 2");
        System.out.println("Output: " + ps.numSquares(2));
        System.out.println("Expected: 2\n");

        System.out.println("Test 3: n = 13");
        System.out.println("Output: " + ps.numSquares(13));
        System.out.println("Expected: 2\n");

        System.out.println("Test 4: n = 1");
        System.out.println("Output: " + ps.numSquares(1));
        System.out.println("Expected: 1\n");

        System.out.println("Test 5: n = 4");
        System.out.println("Output: " + ps.numSquares(4));
        System.out.println("Expected: 1\n");

        System.out.println("Test 6: n = 12");
        System.out.println("Output: " + ps.numSquares(12));
        System.out.println("Expected: 3\n");

        System.out.println("Test 7: n = 100");
        System.out.println("Output: " + ps.numSquares(100));
        System.out.println("Expected: 1\n");

        System.out.println("Test 8: n = 99");
        System.out.println("Output: " + ps.numSquares(99));
        System.out.println("Expected: 3\n");

        System.out.println("Test 9: n = 15");
        System.out.println("Output: " + ps.numSquares(15));
        System.out.println("Expected: 4\n");

        System.out.println("Test 10: n = 32");
        System.out.println("Output: " + ps.numSquares(32));
        System.out.println("Expected: 2\n");
    }
}
