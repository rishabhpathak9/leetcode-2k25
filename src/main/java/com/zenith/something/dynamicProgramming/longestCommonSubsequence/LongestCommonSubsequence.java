package com.zenith.something.dynamicProgramming.longestCommonSubsequence;

/**
 * LeetCode 1143: Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest
 * common subsequence. A subsequence of a string is a new string generated
 * from the original string with some characters (can be none) deleted
 * without changing the relative order of the remaining characters.
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        dp(text1, text2, m, n);
        return dp[m][n];
    }

    private int dp(String text1, String text2, int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return dp(text1, text2, m - 1, n - 1) + 1;
        }
        return Math.max(dp(text1, text2, m, n - 1), dp(text1, text2, m - 1, n));
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        System.out.println("Test 1: text1 = \"abcde\", text2 = \"ace\"");
        System.out.println("Output: " + lcs.longestCommonSubsequence("abcde", "ace"));
        System.out.println("Expected: 3\n");

        System.out.println("Test 2: text1 = \"abc\", text2 = \"abc\"");
        System.out.println("Output: " + lcs.longestCommonSubsequence("abc", "abc"));
        System.out.println("Expected: 3\n");

        System.out.println("Test 3: text1 = \"abc\", text2 = \"def\"");
        System.out.println("Output: " + lcs.longestCommonSubsequence("abc", "def"));
        System.out.println("Expected: 0\n");

        System.out.println("Test 4: text1 = \"bsbininm\", text2 = \"jmjkbkjkv\"");
        System.out.println("Output: " + lcs.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        System.out.println("Expected: 1\n");

        System.out.println("Test 5: text1 = \"pmjghexybyrgzczy\", text2 = \"hafcdqbgncrcbihkd\"");
        System.out.println("Output: " + lcs.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
        System.out.println("Expected: 4\n");
    }
}
