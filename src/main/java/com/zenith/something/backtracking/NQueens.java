package com.zenith.something.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /**
     * LeetCode 51: N-Queens
     * 
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
     * such that
     * no two queens attack each other.
     * 
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You
     * may return
     * the answer in any order.
     * 
     * Each solution contains a distinct board configuration of the n-queens'
     * placement, where
     * 'Q' and '.' both indicate a queen and an empty space, respectively.
     * 
     * Example 1:
     * Input: n = 1
     * Output: [["Q"]]
     * 
     * Example 2:
     * Input: n = 4
     * Output: [
     * [".Q..",
     * "...Q",
     * "Q...",
     * "..Q."],
     * ["..Q.",
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 
     * Constraints:
     * - 1 <= n <= 9
     */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(n, 0, board, result);
        return result;
    }

    private void backtrack(int n, int row, char[][] board, List<List<String>> result) {
        if (row == n) {
            result.add(convertBoardToList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(n, row + 1, board, result);
                board[row][col] = '.';
            }
        }

    }

    private List<String> convertBoardToList(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void printResult(List<List<String>> result) {
        System.out.println("Total solutions: " + result.size());
        for (List<String> solution : result) {
            System.out.println("Solution:");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        // Case 1: n = 1
        int n1 = 1;
        System.out.println("Case 1: n = " + n1);
        System.out.println("Expected: 1 solution");
        List<List<String>> result1 = solver.solveNQueens(n1);
        System.out.println("Actual count: " + result1.size());
        printResult(result1);

        // Case 2: n = 4
        int n2 = 4;
        System.out.println("Case 2: n = " + n2);
        System.out.println("Expected: 2 solutions");
        List<List<String>> result2 = solver.solveNQueens(n2);
        System.out.println("Actual count: " + result2.size());
        printResult(result2);

        // Case 3: n = 8
        int n3 = 8;
        System.out.println("Case 3: n = " + n3);
        System.out.println("Expected: 92 solutions");
        List<List<String>> result3 = solver.solveNQueens(n3);
        System.out.println("Actual count: " + result3.size());
        // Don't print all solutions for n=8 as it's too many

        // Case 4: n = 2
        int n4 = 2;
        System.out.println("Case 4: n = " + n4);
        System.out.println("Expected: 0 solutions (no valid placement)");
        List<List<String>> result4 = solver.solveNQueens(n4);
        System.out.println("Actual count: " + result4.size());
        printResult(result4);

        // Case 5: n = 3
        int n5 = 3;
        System.out.println("Case 5: n = " + n5);
        System.out.println("Expected: 0 solutions (no valid placement)");
        List<List<String>> result5 = solver.solveNQueens(n5);
        System.out.println("Actual count: " + result5.size());
        printResult(result5);
    }
}