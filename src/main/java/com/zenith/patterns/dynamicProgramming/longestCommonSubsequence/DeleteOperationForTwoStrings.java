package com.zenith.patterns.dynamicProgramming.longestCommonSubsequence;

/**
 * LeetCode 583: Delete Operation for Two Strings
 *
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same, where in each step you can
 * delete exactly one character in either string.
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // dp(word1, word2, m, n);
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings sol = new DeleteOperationForTwoStrings();

        System.out.println("Test 1: word1 = \"sea\", word2 = \"eat\"");
        System.out.println("Output: " + sol.minDistance("sea", "eat"));
        System.out.println("Expected: 2\n");

        System.out.println("Test 2: word1 = \"abc\", word2 = \"abc\"");
        System.out.println("Output: " + sol.minDistance("abc", "abc"));
        System.out.println("Expected: 0\n");

        System.out.println("Test 3: word1 = \"abc\", word2 = \"def\"");
        System.out.println("Output: " + sol.minDistance("abc", "def"));
        System.out.println("Expected: 6\n");

        System.out.println("Test 4: word1 = \"a\", word2 = \"b\"");
        System.out.println("Output: " + sol.minDistance("a", "b"));
        System.out.println("Expected: 2\n");

        System.out.println("Test 5: word1 = \"\", word2 = \"\"");
        System.out.println("Output: " + sol.minDistance("", ""));
        System.out.println("Expected: 0\n");
    }
}
