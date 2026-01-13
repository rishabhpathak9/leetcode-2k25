package com.zenith.something.dynamicProgramming.countDistinctWays;

import java.util.Arrays;

/**
 * LeetCode 91: Decode Ways
 *
 * A message containing letters from A-Z can be encoded into numbers using the
 * mapping:
 * 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if (n == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int res = solve(s, n, dp);
        return res;
    }

    private int solve(String s, int n, int[] dp) {
        if(dp[n]!=-1) return dp[n];
        if (n < 0) {
            return 0;
        }
        if (n == 0)
            return 1;
        if (n == 1)
            return s.charAt(n - 1) == '0' ? 0 : 1;
        
        int res = 0;
        if (s.charAt(n - 1) != '0') {
            res += solve(s, n - 1, dp);
        }
        int val = Integer.parseInt(s.substring(n - 2, n));
        if (val >= 10 && val < 27) {
            res += solve(s, n - 2, dp);
        }
        dp[n] = res;
        return res;
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();

        System.out.println("Test 1: s = \"10\"");
        System.out.println("Output: " + dw.numDecodings("12"));
        System.out.println("Expected: 2 (\"1,2\" or \"12\")\n");

        System.out.println("Test 2: s = \"226\"");
        System.out.println("Output: " + dw.numDecodings("226"));
        System.out.println("Expected: 3 (\"2,2,6\", \"22,6\", \"2,26\")\n");

        System.out.println("Test 3: s = \"0\"");
        System.out.println("Output: " + dw.numDecodings("0"));
        System.out.println("Expected: 0\n");

        System.out.println("Test 4: s = \"1\"");
        System.out.println("Output: " + dw.numDecodings("1"));
        System.out.println("Expected: 1\n");

        System.out.println("Test 5: s = \"27\"");
        System.out.println("Output: " + dw.numDecodings("27"));
        System.out.println("Expected: 1\n");
    }
}
