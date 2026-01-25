package com.zenith.something.dynamicProgramming.digitDP;

import java.util.Arrays;

/**
 * LeetCode 233: Number of Digit One
 *
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative
 * integers less than or equal to n.
 */
public class NumberDigitOne {

    int sl, ans;
    String s;
    int[][][] mem;

    public int countDigitOne(int n) {
        s = String.valueOf(n);
        sl = s.length();
        mem = new int[sl+1][2][sl+1];

        for(int i = 0; i<=sl; i++)
            for(int j=0; j<2; j++)
                Arrays.fill(mem[i][j], -1);

     ans = solve(0, 1, 0);
        return ans;
    }

    int solve(int idx, int tight, int count) {
        if (idx == sl) 
            return count;
        if(mem[idx][tight][count] != -1) return mem[idx][tight][count];

        int lb = 0;
        int ub = tight==1 ? s.charAt(idx) - '0' : 9;

        int res = 0;
        for (int i = lb; i <= ub; i++) {
            int nTight = tight==1 && ub==i ? 1 : 0;
            if (i == 1) res += solve(idx + 1, nTight, count + 1);
        
            else res += solve(idx + 1, nTight, count);
            
        }
        mem[idx][tight][count] = res;

        return res;
    }


    public static void main(String[] args) {
        NumberDigitOne ndo = new NumberDigitOne();

        System.out.println("Test 1: n = 13");
        System.out.println("Output: " + ndo.countDigitOne(13));
        System.out.println("Expected: 6 (1,10,11,12,13)\n");

        System.out.println("Test 2: n = 0");
        System.out.println("Output: " + ndo.countDigitOne(0));
        System.out.println("Expected: 0\n");

        System.out.println("Test 3: n = 1");
        System.out.println("Output: " + ndo.countDigitOne(1));
        System.out.println("Expected: 1\n");

        System.out.println("Test 4: n = 824883294");
        System.out.println("Output: " + ndo.countDigitOne(824883294));
        System.out.println("Expected: 767944060\n");
    }
}
