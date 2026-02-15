package com.zenith.patterns.dynamicProgramming.catalanNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 22: Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 */
public class GenerateParentheses {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        solve(n, "", 0, 0);
        return res.stream().toList();
    }

    void solve(int n, String s, int l, int r) {
        if (s.length() == n << 1) {
            res.add(s);
            return;
        }
        if (l < n)
            solve(n, s + "(", l + 1, r);

        if (l > r)
            solve(n, s + ")", l, r + 1);

    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();

        System.out.println("Test 1: n = 1");
        System.out.println("Output: " + gp.generateParenthesis(1));
        System.out.println("Expected: [\"()\"]\n");

        System.out.println("Test 2: n = 2");
        System.out.println("Output: " + gp.generateParenthesis(2));
        System.out.println("Expected: [\"(())\", \"()()\"]\n");

        System.out.println("Test 3: n = 3");
        System.out.println("Output: " + gp.generateParenthesis(3));
        System.out.println("Expected: [\"((()))\", \"(()())\", \"(())()\", \"()(())\", \"()()()\"]\n");
    }
}
