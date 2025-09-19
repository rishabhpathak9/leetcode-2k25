package com.zenith.something.slidingWindow;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128]; // ASCII character count
        for (char c : t.toCharArray()) {
            map[c]++; // Count each character in t
        }

        int left = 0, right = 0; // Window pointers
        int minLen = Integer.MAX_VALUE; // Track minimum window length
        int minStart = 0; // Track start index of minimum window
        int count = t.length(); // Number of characters we need to match

        char[] sArr = s.toCharArray();

        while (right < sArr.length) {
            // If current character is needed, decrease count
            if (map[sArr[right]] > 0) {
                count--;
            }
            map[sArr[right]]--; // Decrease count in map (can go negative)
            right++;

            // When all characters matched, try to shrink window from left
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
                map[sArr[left]]++; // Restore character count
                // If character at left is needed, increase count
                if (map[sArr[left]] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(sArr, minStart, minLen);
    }
    
    public static void main(String[] args) {
        MinimumWindowSubstring sc = new MinimumWindowSubstring();
        String result = sc.minWindow("aa", "aa");
        System.out.println(result); // Output: "BANC"
    }
}