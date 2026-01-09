package com.zenith.something.dynamicProgramming.stringPartition;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 139: Word Break
 *
 * Given a string s and a dictionary of strings wordDict, return true if s
 * can be segmented into a space-separated sequence of dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--){
            for (String word : wordDict) {
                if(i + word.length() <= n && s.substring(i, i + word.length()).equals(word)){
                    dp[i] = dp[i] || dp[i + word.length()];
                }
            }
        }
        dp(s, wordDict, "");
        return dp[0];
    }

    private boolean dp(String s, List<String> wordDict, String curS) {
        if (s.equals(curS)) {
            return true;
        }
        if (s.length() <= curS.length()) {
            return false;
        }
        boolean ret = false;
        for (String word : wordDict) {
            ret = ret || dp(s, wordDict, curS + word);
        }
        return ret;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        System.out.println("Test 1: s = \"leetcode\", wordDict = [\"leet\", \"code\"]");
        System.out.println("Output: " + wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println("Expected: true\n");

        System.out.println("Test 2: s = \"applepenapple\", wordDict = [\"apple\", \"pen\"]");
        System.out.println("Output: " + wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println("Expected: true\n");

        System.out
                .println("Test 3: s = \"catsandsanddog\", wordDict = [\"cat\", \"cats\", \"and\", \"sand\", \"dog\"]");
        System.out.println(
                "Output: " + wb.wordBreak("catsandsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println("Expected: true\n");

        System.out.println("Test 4: s = \"a\", wordDict = [\"b\"]");
        System.out.println("Output: " + wb.wordBreak("a", Arrays.asList("b")));
        System.out.println("Expected: false\n");

        System.out.println("Test 5: s = \"abcd\", wordDict = [\"a\", \"ab\", \"abc\"]");
        System.out.println("Output: " + wb.wordBreak("abcd", Arrays.asList("a", "ab", "abc")));
        System.out.println("Expected: false\n");

        System.out.println("Test 6: s = \"aaaaaaa\", wordDict = [\"aaaa\", \"aaa\"]");
        System.out.println("Output: " + wb.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        System.out.println("Expected: true\n");

        System.out.println("Test 7: s = \"cars\", wordDict = [\"car\", \"ca\", \"rs\"]");
        System.out.println("Output: " + wb.wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        System.out.println("Expected: true\n");
    }
}
