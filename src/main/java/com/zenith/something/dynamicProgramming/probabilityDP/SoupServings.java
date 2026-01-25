package com.zenith.something.dynamicProgramming.probabilityDP;

import java.util.Arrays;

/**
 * LeetCode 808: Soup Servings
 *
 * There are two types of soup: type A and type B. Initially, there are n ml of
 * each type of soup.
 * There are four kinds of operations:
 * 1. Serve 100 ml of soup A and 0 ml of soup B
 * 2. Serve 75 ml of soup A and 25 ml of soup B
 * 3. Serve 50 ml of soup A and 50 ml of soup B
 * 4. Serve 25 ml of soup A and 75 ml of soup B
 * When we serve some soup, we give it to some bowl. Each operation takes the
 * same time to do.
 * After we do some operations, we're left with some amount of soup A and B in
 * the pot.
 * Return the probability that A will be empty first, plus half the probability
 * that A and B become empty at the same time.
 */
public class SoupServings {

    double mem[][];
    public double soupServings(int n) {
        if(n>=4051) return 0.99999;
        if(n%25==0)
            n = n/ 25;
        else n = (n/25)+1;
        mem = new double[n+1][n+1];
        for(int i = 0; i<=n; i++) Arrays.fill(mem[i], -1.0d);
        double res = dp(n, n);
        return res;
    }

    private double dp(int a, int b) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1;
        if (b <= 0)
            return 0;
        if(mem[a][b]!=-1) return mem[a][b];
        double sum = dp(a - 4, b) + dp(a - 3, b - 1) + dp(a - 2 , b - 2) + dp(a - 1, b - 3);
        mem[a][b] = sum/4;
        return mem[a][b];
    }

    public static void main(String[] args) {
        SoupServings ss = new SoupServings();

        System.out.println("Test 1: n = 50");
        System.out.println("Output: " + ss.soupServings(50));
        System.out.println("Expected: 0.625\n");

        System.out.println("Test 2: n = 100");
        System.out.println("Output: " + ss.soupServings(100));
        System.out.println("Expected: 0.71875\n");

        System.out.println("Test 3: n = 1");
        System.out.println("Output: " + ss.soupServings(1));
        System.out.println("Expected: 0.625\n");
    }
}
