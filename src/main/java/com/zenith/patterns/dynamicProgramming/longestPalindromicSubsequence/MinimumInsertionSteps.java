package com.zenith.patterns.dynamicProgramming.longestPalindromicSubsequence;

/**
 * LeetCode 1312: Minimum Insertion Steps to Make a String Palindrome
 *
 * Given a string s, return the minimum number of characters you must insert
 * at any position of the string to make it a palindrome.
 */
public class MinimumInsertionSteps {

    public int minInsertions(String s) {
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
        return n-dp[n][n];
    }

    public static void main(String[] args) {
        MinimumInsertionSteps mis = new MinimumInsertionSteps();

        System.out.println("Test 1: s = \"zzazz\"");
        System.out.println("Output: " + mis.minInsertions("zzazz"));
        System.out.println("Expected: 0 (already palindrome)\n");

        System.out.println("Test 2: s = \"mbadm\"");
        System.out.println("Output: " + mis.minInsertions("mbadm"));
        System.out.println("Expected: 2 (insert 'b' and 'm' to make \"mmbadmm\" or \"mbdabm\")\n");

        System.out.println("Test 3: s = \"a\"");
        System.out.println("Output: " + mis.minInsertions("a"));
        System.out.println("Expected: 0\n");

        System.out.println("Test 4: s = \"ab\"");
        System.out.println("Output: " + mis.minInsertions("ab"));
        System.out.println("Expected: 1 (insert 'a' to make \"aba\")\n");

        System.out.println("Test 5: s = \"abcde\"");
        System.out.println("Output: " + mis.minInsertions("abcde"));
        System.out.println("Expected: 4 (insert \"dcba\" to make \"abcdedcba\")\n");

        System.out.println("Test 6: s = \"racecar\"");
        System.out.println("Output: " + mis.minInsertions("racecar"));
        System.out.println("Expected: 0 (already palindrome)\n");
    }
}
