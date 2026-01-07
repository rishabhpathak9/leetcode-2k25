package com.zenith.something.dynamicProgramming.editDistance;

/**
 * LeetCode 72: Edit Distance
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2. You have the following three operations
 * permitted on a word: insert a character, delete a character, replace a
 * character.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        dp(word1, m, word2, n);
        return dp[m][n];
    }

    private int dp(String word1, int m, String word2, int n) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return dp(word1, m - 1, word2, n - 1);
        } else {
            return Math.min(dp(word1, m - 1, word2, n) + 1,
                    Math.min(dp(word1, m, word2, n - 1) + 1,
                            dp(word1, m - 1, word2, n - 1) + 1));
        }

    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();

        System.out.println("Test 1: word1 = \"horse\", word2 = \"ros\"");
        System.out.println("Output: " + ed.minDistance("horse", "ros"));
        System.out.println("Expected: 3\n");

        System.out.println("Test 2: word1 = \"kitten\", word2 = \"sitting\"");
        System.out.println("Output: " + ed.minDistance("kitten", "sitting"));
        System.out.println("Expected: 3\n");

        System.out.println("Test 3: word1 = \"intention\", word2 = \"execution\"");
        System.out.println("Output: " + ed.minDistance("intention", "execution"));
        System.out.println("Expected: 5\n");

        System.out.println("Test 4: word1 = \"abc\", word2 = \"ab\"");
        System.out.println("Output: " + ed.minDistance("abc", "ab"));
        System.out.println("Expected: 1\n");

        System.out.println("Test 5: word1 = \"\", word2 = \"\"");
        System.out.println("Output: " + ed.minDistance("", ""));
        System.out.println("Expected: 0\n");

        System.out.println("Test 6: word1 = \"a\", word2 = \"\"");
        System.out.println("Output: " + ed.minDistance("a", ""));
        System.out.println("Expected: 1\n");
    }
}
