package com.zenith.patterns.dynamicProgramming.probabilityDP;

/**
 * LeetCode 837: New 21 Game
 *
 * Alice plays the following game, loosely based on the card game "21".
 * Alice starts with 0 points and draws numbers while she has less than k
 * points.
 * During each draw, she draws a number between 1 and maxPts inclusive, which
 * she adds to her points.
 * She continues drawing until she has at least k points and then stops.
 * It is possible to go over - if she goes over by taking a number and lands
 * within the range of [k, n],
 * she will win. Return the probability that Alice wins the game.
 */
public class New21Game {

    public double probabilityOfWinning(int n, int k, int maxPts) {
        if (k == 0)
            return 1.0;
        double[] mem = new double[n + maxPts + 1];

        double sum = 0;
        for (int cur = k; cur < k + maxPts; cur++) {
            if (n >= cur) {
                mem[cur] = 1;
                sum += 1;
            } else
                mem[cur] = 0;
        }
        for (int cur = k - 1; cur >= 0; cur--) {
            mem[cur] = sum / maxPts;
            sum += mem[cur] - mem[cur + maxPts];

        }
        return mem[0];
    }

    // private double dp(int cur) {

    // if (cur >= k) {
    // if (n >= cur)
    // return 1;
    // return 0;
    // }
    // if (mem[cur] != -1)
    // return mem[cur];
    // double sum = 0;
    // for (int i = 1; i <= maxPts; i++)
    // sum += dp(cur + i);
    // mem[cur] = sum / maxPts;
    // return sum / maxPts;
    // }

    public static void main(String[] args) {
        New21Game n21 = new New21Game();

        System.out.println("Test 1: n = 10, k = 1, maxPts = 10");
        System.out.println("Output: " + n21.probabilityOfWinning(10, 1, 10));
        System.out.println("Expected: 1.0\n");

        System.out.println("Test 2: n = 6, k = 1, maxPts = 10");
        System.out.println("Output: " + n21.probabilityOfWinning(6, 1, 10));
        System.out.println("Expected: 0.6\n");

        System.out.println("Test 3: n = 21, k = 17, maxPts = 10");
        System.out.println("Output: " + n21.probabilityOfWinning(21, 17, 10));
        System.out.println("Expected: 0.73\n");
    }
}
