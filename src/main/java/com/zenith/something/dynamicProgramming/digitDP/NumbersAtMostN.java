package com.zenith.something.dynamicProgramming.digitDP;

/**
 * LeetCode 902: Numbers At Most N Given Digit Set
 *
 * Given an array of digits which is sorted in non-decreasing order. You can
 * write
 * numbers using each digits[i] as many times as we want. For example, if digits
 * = [1,3,5,7],
 * we may write numbers such as 13, 551, 677, etc. Return the count of positive
 * integers
 * we can make such that the value of the integer is less than or equal to n.
 */
public class NumbersAtMostN {
    int res;
    int sn;
    int dn;
    String[] dgts;
    String s;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = String.valueOf(n);
        sn = s.length();
        dn = digits.length;
        dgts = digits;

        res = 0;
        for (int i = 1; i < sn; i++)
            res += pow(dn, i);

        res += solve(0, true);
        return res;
    }

    int solve(int idx, boolean tight) {
        if (idx == sn)
            return 1;

        int ans = 0;
        for (String d : dgts) {
            if (d.charAt(0) > s.charAt(idx))
                continue;
            else if (d.charAt(0) < s.charAt(idx))
                ans += pow(dn, sn - idx - 1);

            else if (tight && d.charAt(0) == s.charAt(idx))
                ans += solve(idx + 1, true);
        }
        return ans;
    }

    private int pow(int base, int exp) {
        int ans = 1;
        while (exp-- > 0)
            ans *= base;
        return ans;
    }

    public static void main(String[] args) {
        NumbersAtMostN namn = new NumbersAtMostN();

        System.out.println("Test 1: digits = [\"1\",\"3\",\"5\",\"7\"], n = 100");
        System.out.println("Output: " + namn.atMostNGivenDigitSet(new String[] { "1", "3", "5", "7" }, 100));
        System.out.println("Expected: 20\n");

        System.out.println("Test 2: digits = [\"1\",\"4\",\"9\"], n = 2");
        System.out.println("Output: " + namn.atMostNGivenDigitSet(new String[] { "1", "4", "9" }, 2));
        System.out.println("Expected: 1\n");
    }
}
