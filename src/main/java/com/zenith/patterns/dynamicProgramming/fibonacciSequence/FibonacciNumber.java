package com.zenith.patterns.dynamicProgramming.fibonacciSequence;

public class FibonacciNumber {

    /**
     * LeetCode 509: Fibonacci Number (practice scaffold)
     * 
     * The Fibonacci numbers, commonly denoted F(n), form a sequence in which each number is 
     * the sum of the two preceding ones. Starting from F(0) = 0 and F(1) = 1.
     * 
     * F(n) = F(n-1) + F(n-2), where F(0) = 0 and F(1) = 1.
     * 
     * Given n, calculate F(n).
     * 
     * Example 1:
     * Input: n = 2
     * Output: 1
     * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1
     * 
     * Example 2:
     * Input: n = 3
     * Output: 2
     * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2
     * 
     * Example 3:
     * Input: n = 4
     * Output: 3
     * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3
     * 
     * Constraints:
     * - 0 <= n <= 30
     */

    public int fib(int n) {
        if (n < 1){
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 1; i <= n; i++){
            int third = first + second;
            second = first;
            first = third;
        }
        return first;
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        FibonacciNumber solver = new FibonacciNumber();

        // Case 1: n = 0
        int n1 = 0;
        System.out.println("Case 1: n = " + n1);
        System.out.println("Expected: 0 (base case)");
        printResult(solver.fib(n1));

        // Case 2: n = 1
        int n2 = 1;
        System.out.println("\nCase 2: n = " + n2);
        System.out.println("Expected: 1 (base case)");
        printResult(solver.fib(n2));

        // Case 3: n = 2
        int n3 = 2;
        System.out.println("\nCase 3: n = " + n3);
        System.out.println("Expected: 1 (F(2) = F(1) + F(0) = 1 + 0)");
        printResult(solver.fib(n3));

        // Case 4: n = 3
        int n4 = 3;
        System.out.println("\nCase 4: n = " + n4);
        System.out.println("Expected: 2 (F(3) = F(2) + F(1) = 1 + 1)");
        printResult(solver.fib(n4));

        // Case 5: n = 4
        int n5 = 4;
        System.out.println("\nCase 5: n = " + n5);
        System.out.println("Expected: 3 (F(4) = F(3) + F(2) = 2 + 1)");
        printResult(solver.fib(n5));

        // Case 6: n = 5
        int n6 = 5;
        System.out.println("\nCase 6: n = " + n6);
        System.out.println("Expected: 5");
        printResult(solver.fib(n6));

        // Case 7: n = 6
        int n7 = 6;
        System.out.println("\nCase 7: n = " + n7);
        System.out.println("Expected: 8");
        printResult(solver.fib(n7));

        // Case 8: n = 10
        int n8 = 10;
        System.out.println("\nCase 8: n = " + n8);
        System.out.println("Expected: 55");
        printResult(solver.fib(n8));

        // Case 9: n = 15
        int n9 = 15;
        System.out.println("\nCase 9: n = " + n9);
        System.out.println("Expected: 610");
        printResult(solver.fib(n9));

        // Case 10: n = 30 (max constraint)
        int n10 = 30;
        System.out.println("\nCase 10: n = " + n10);
        System.out.println("Expected: 832040");
        printResult(solver.fib(n10));
    }
}
