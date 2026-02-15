package com.zenith.patterns.dynamicProgramming.longestPalindromicSubsequence;

/**
 * LeetCode 647: Palindromic Substrings
 *
 * Given a string s, return the number of palindromic substrings in it.
 * A string is palindromic when it reads the same backward as forward.
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += expand(i, s);
        }
        return res + n;

    }

    private int expand(int idx, String pal) {
        int count = 0;
        int d = 1;
        int n = pal.length();
        while ((idx - d) >= 0 && idx + d < n) {
            if (pal.charAt(idx - d) == pal.charAt(idx + d)) {
                count++;
                d++;
            } else {
                break;
            }
        }
        d = 1;
        if (idx + 1 < n && pal.charAt(idx) == pal.charAt(idx + 1)) {
            count++;
            while ((idx - d) >= 0 && idx + 1 + d < n && pal.charAt(idx - d) == pal.charAt(idx + 1 + d)) {
                count++;
                d++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();

        System.out.println("Test 1: s = \"abc\"");
        System.out.println("Output: " + ps.countSubstrings("abc"));
        System.out.println("Expected: 3 (\"a\", \"b\", \"c\")\n");

        System.out.println("Test 2: s = \"abcba\"");
        System.out.println("Output: " + ps.countSubstrings("abcba"));
        System.out.println("Expected: 7 (\"a\", \"b\", \"c\", \"b\", \"a\", \"bcb\", \"abcba\")\n");

        System.out.println("Test 3: s = \"a\"");
        System.out.println("Output: " + ps.countSubstrings("a"));
        System.out.println("Expected: 1\n");

        System.out.println("Test 4: s = \"aa\"");
        System.out.println("Output: " + ps.countSubstrings("aa"));
        System.out.println("Expected: 3 (\"a\", \"a\", \"aa\")\n");

        System.out.println("Test 5: s = \"aaaa\"");
        System.out.println("Output: " + ps.countSubstrings("aaaa"));
        System.out.println(
                "Expected: 10 (\"a\" appears 4 times, \"aa\" appears 3 times, \"aaa\" appears 2 times, \"aaaa\" appears 1 time)\n");

        System.out.println("Test 6: s = \"racecar\"");
        System.out.println("Output: " + ps.countSubstrings("racecar"));
        System.out.println("Expected: 10 (\"r\", \"a\", \"c\", \"e\", \"c\", \"a\", \"r\", \"cec\", \"aceca\", \"racecar\")\n");

        System.out.println("Test 7: s = \"nitin\"");
        System.out.println("Output: " + ps.countSubstrings("nitin"));
        System.out.println("Expected: 7 (\"n\", \"i\", \"t\", \"i\", \"n\", \"iti\", \"nitin\")\n");
    }
}
