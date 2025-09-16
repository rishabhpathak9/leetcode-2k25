package com.zenith.something.slidingWindow;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String input) {
        int[] isPresent = new int[128];
        Arrays.fill(isPresent, -1);
        int result = 0;
        int i = 0;
        int start = 0;
        while(i<input.length()){
            int index = (int)input.charAt(i);
            if(isPresent[index] != -1){
                start = Math.max(isPresent[index]+1, start);
            }
            isPresent[index] = i;
            result = Math.max(result, i-start+1);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        int result = s.lengthOfLongestSubstring("abba");
        System.out.println(result);
    }
}
