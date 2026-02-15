package com.zenith.patterns.dynamicProgramming.countDistinctWays;

import java.util.Arrays;

/**
 * LeetCode 2266: Count Number of Texts
 *
 * Alice is texting Bob using her phone. The mapping of digits to letters is as
 * on old phones:
 * 2 -> "abc", 3 -> "def", 4 -> "ghi", 5 -> "jkl", 6 -> "mno", 7 -> "pqrs", 8 ->
 * "tuv", 9 -> "wxyz"
 * For example, if Alice wants to say "hello", she can press 4,3,5,5,6 and Bob
 * knows she pressed
 * the key 3 once followed by 5 twice, then 6 once.
 * Given a string pressedKeys containing only digits 2-9, return the total
 * number of possible
 * text messages Alice can send.
 */
public class CountNumberOfTexts {

    public int countTexts(String pressedKeys) {
        int[] dp = new int[pressedKeys.length() + 1];
        Arrays.fill(dp, -1);
        int res = dp(pressedKeys, pressedKeys.length(), dp);
        return res;
    }

    private int dp(String s, int n, int[] dp) {

        if (dp[n] != -1)
            return dp[n];
        if (n == 1 || n == 0) {
            return 1;
        }
        char cur = s.charAt(n - 1);
        long res = dp(s, n - 1, dp);
        if (n > 1 && cur == s.charAt(n - 2)) {
            res += dp(s, n - 2, dp);
            if (n > 2 && cur == s.charAt(n - 3)) {
                res += dp(s, n - 3, dp);
                if (n > 3 && (cur == '7' || cur == '9') && cur == s.charAt(n - 4)) {
                    res += dp(s, n - 4, dp);
                }
            }
        }
        dp[n] = (int) (res % 1000000007);
        return dp[n];
    }

    public static void main(String[] args) {
        CountNumberOfTexts cnot = new CountNumberOfTexts();

        System.out.println("Test 1: pressedKeys = \"22233\"");
        System.out.println("Output: " + cnot.countTexts("22233"));
        System.out.println("Expected: 8\n");

        System.out.println("Test 2: pressedKeys = \"222222222222222222222222222222222222\"");
        System.out.println("Output: " + cnot.countTexts("222222222222222222222222222222222222"));
        System.out.println("Expected: 82876089\n");
    }
}
