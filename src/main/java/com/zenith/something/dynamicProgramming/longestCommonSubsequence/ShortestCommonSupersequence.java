package com.zenith.something.dynamicProgramming.longestCommonSubsequence;

/**
 * LeetCode 1092: Shortest Common Supersequence
 *
 * Given two strings str1 and str2, return the shortest string that has both
 * str1 and str2 as subsequences. If multiple answers exist, any valid one is
 * fine.
 */
public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int dp[][] = new int[m + 1][n + 1];

        int lcsCount = 0;
        StringBuilder lcs = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (lcsCount < dp[i][j]) {
                        lcsCount++;
                        lcs.append(str1.charAt(i - 1));
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m, j = n;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.append(str1.charAt(i - 1));
                i--;
            } else {
                result.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence();

        System.out.println("Test 1: str1 = \"abac\", str2 = \"cab\"");
        System.out.println("Output: " + scs.shortestCommonSupersequence("abac", "cab"));
        System.out.println("Example valid output: cabac (length 5)\n");

        System.out.println("Test 2: str1 = \"leetcode\", str2 = \"etco\"");
        System.out.println("Output: " + scs.shortestCommonSupersequence("leetcode", "etco"));
        System.out.println("Example valid output: leetcode (length 8)\n");

        System.out.println("Test 3: str1 = \"abc\", str2 = \"def\"");
        System.out.println("Output: " + scs.shortestCommonSupersequence("abc", "def"));
        System.out.println("Example valid output: abcdef (length 6)\n");

        System.out.println("Test 4: str1 = \"\", str2 = \"abc\"");
        System.out.println("Output: " + scs.shortestCommonSupersequence("", "abc"));
        System.out.println("Expected: abc\n");

        System.out.println("Test 5: str1 = \"abc\", str2 = \"abc\"");
        System.out.println("Output: " + scs.shortestCommonSupersequence("abc", "abc"));
        System.out.println("Expected: abc\n");
    }
}
