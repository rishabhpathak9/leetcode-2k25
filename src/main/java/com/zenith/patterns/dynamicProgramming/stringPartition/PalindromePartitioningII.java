package com.zenith.patterns.dynamicProgramming.stringPartition;

import java.util.Arrays;

/**
 * LeetCode 132: Palindrome Partitioning II
 *
 * Given a string s, return the minimum cuts needed for a palindrome
 * partitioning of s.
 */
public class PalindromePartitioningII {

    String s;
    int mem[];

    public int minCut(String s) {
        this.s = s;
        int n = s.length();
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        if (isPalindrome(s))
            return 0;
        return dp(n);
    }

    private int dp(int rem) {
        if (mem[rem] != -1)
            return mem[rem];
        if (isPalindrome(s.substring(0, rem)))
            return 0;

        int ans = rem - 1;
        for (int i = rem - 1; i >= 0; i--) {
            if (isPalindrome(s.substring(i, rem))) {
                ans = Math.min(dp(i) + 1, ans);
            }
        }
        mem[rem] = ans;
        return ans;
    }

    private boolean isPalindrome(String sub) {
        int i = 0;
        int j = sub.length() - 1;
        while (i < j) {
            if (sub.charAt(i) != sub.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioningII pp = new PalindromePartitioningII();

        System.out.println("Test 1: s = \"aab\"");
        System.out.println("Output: " + pp.minCut("aab"));
        System.out.println("Expected: 1 (\"aa|b\")\n");

        System.out.println("Test 2: s = \"a\"");
        System.out.println("Output: " + pp.minCut("a"));
        System.out.println("Expected: 0\n");

        System.out.println("Test 3: s = \"ab\"");
        System.out.println("Output: " + pp.minCut("ab"));
        System.out.println("Expected: 1 (\"a|b\")\n");

        System.out.println("Test 4: s = \"aabbaa\"");
        System.out.println("Output: " + pp.minCut("aabbaa"));
        System.out.println("Expected: 0 (already palindrome)\n");

        System.out.println("Test 5: s = \"cdd\"");
        System.out.println("Output: " + pp.minCut("cdd"));
        System.out.println("Expected: 1 (\"c|dd\")\n");
    }
}
