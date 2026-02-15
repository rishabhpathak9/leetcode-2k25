package com.zenith.patterns.dynamicProgramming.longestPalindromicSubsequence;

/**
 * LeetCode 516: Longest Palindromic Subsequence
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining elements.
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for (int i =1 ; i<= n; i++ ){
            for (int j =  1; j<=n ; j++){
                if(s.charAt(i-1)== s.charAt(n-j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

        System.out.println("Test 1: s = \"bbbab\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("bbbab"));
        System.out.println("Expected: 4 (LPS is \"bbbb\")\n");

        System.out.println("Test 2: s = \"cbbd\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("cbbd"));
        System.out.println("Expected: 2 (LPS is \"bb\")\n");

        System.out.println("Test 3: s = \"a\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("a"));
        System.out.println("Expected: 1\n");

        System.out.println("Test 4: s = \"racecar\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("racecar"));
        System.out.println("Expected: 7 (entire string is palindrome)\n");

        System.out.println("Test 5: s = \"abcde\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("abcde"));
        System.out.println("Expected: 1\n");

        System.out.println("Test 6: s = \"aaaa\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("aaaa"));
        System.out.println("Expected: 4\n");

        System.out.println("Test 7: s = \"abacabad\"");
        System.out.println("Output: " + lps.longestPalindromeSubseq("abacabad"));
        System.out.println("Expected: 7 (LPS is \"abacaba\")\n");
    }
}
