package com.zenith.something.matricTraversal;

public class SurroundedRegions {

    /**
     * LeetCode 130: Surrounded Regions (practice scaffold)
     * 
     * Given an m x n board containing 'X' and 'O', capture all regions that are 4-directionally 
     * surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * 
     * A region is 4-directionally connected 'O's that reach any boundary without crossing 'X'.
     * 'O's that reach the boundary are safe and should NOT be flipped.
     * 
     * Example 1:
     * Input: board = [
     *   ['X','X','X','X'],
     *   ['X','O','O','X'],
     *   ['X','X','O','X'],
     *   ['X','O','X','X']
     * ]
     * Output: [
     *   ['X','X','X','X'],
     *   ['X','X','X','X'],
     *   ['X','X','X','X'],
     *   ['X','O','X','X']
     * ]
     * 
     * Example 2:
     * Input: board = [['X']]
     * Output: [['X']]
     * 
     * Strategy: Instead of searching for surrounded regions, mark all 'O's connected to boundaries,
     * then flip remaining 'O's to 'X'.
     */

    public void solve(char[][] board) {
        for(int i = 0; i<board[0].length; i++){
            if(board[0][i] == 'O'){
                dfs(0,i,board);
            }
            if(board[board.length-1][i] == 'O'){
                dfs(board.length-1,i,board);
            }
        }

        for(int i = 0; i<board.length; i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(board[i][board[0].length-1] == 'O'){
                dfs(i,board[0].length-1,board);
            }
        }
        
        for (char[] board1 : board) {
            for (int j = 0; j<board[0].length; j++) {
                if (board1[j] == 'S') {
                    board1[j] = 'O';
                } else if (board1[j] == 'O') {
                    board1[j] = 'X';
                }
            }
        }
    }

    int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs (int r, int c, char[][] b){
        if(b[r][c]=='O'){
            b[r][c] = 'S';
        
            for (int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr>=0 && nc>=0 && nr<b.length && nc<b[0].length){
                    dfs(nr,nc,b);
                }
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SurroundedRegions solver = new SurroundedRegions();

        // Case 1: Standard example with surrounded region
        char[][] board1 = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        System.out.println("Case 1: Standard example");
        System.out.println("Before:");
        printBoard(board1);
        solver.solve(board1);
        System.out.println("After (all O's should become X):");
        printBoard(board1);

        // Case 2: Single cell
        char[][] board2 = {{'X'}};
        System.out.println("\nCase 2: Single cell");
        System.out.println("Before:");
        printBoard(board2);
        solver.solve(board2);
        System.out.println("After:");
        printBoard(board2);

        // Case 3: O's connected to boundary
        char[][] board3 = {
            {'X','O','X'},
            {'O','O','O'},
            {'X','O','X'}
        };
        System.out.println("\nCase 3: O's connected to boundary (should not be flipped)");
        System.out.println("Before:");
        printBoard(board3);
        solver.solve(board3);
        System.out.println("After (no O's should become X):");
        printBoard(board3);

        // Case 4: All X's
        char[][] board4 = {
            {'X','X','X'},
            {'X','X','X'},
            {'X','X','X'}
        };
        System.out.println("\nCase 4: All X's");
        System.out.println("Before:");
        printBoard(board4);
        solver.solve(board4);
        System.out.println("After (no change):");
        printBoard(board4);

        // Case 5: Checkerboard pattern
        char[][] board5 = {
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'},
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'}
        };
        System.out.println("\nCase 5: Checkerboard pattern");
        System.out.println("Before:");
        printBoard(board5);
        solver.solve(board5);
        System.out.println("After (O's on edges stay, internal O's flip to X):");
        printBoard(board5);

        // // Case 6: Nested surrounded regions
        char[][] board6 = {
            {'X','X','X','X','X','X'},
            {'X','O','O','O','O','X'},
            {'X','O','X','X','O','X'},
            {'X','O','X','X','O','X'},
            {'X','O','O','O','O','X'},
            {'X','X','X','X','X','X'}
        };
        System.out.println("\nCase 6: Nested surrounded region (double-walled)");
        System.out.println("Before:");
        printBoard(board6);
        solver.solve(board6);
        System.out.println("After (all O's surrounded flip to X):");
        printBoard(board6);
    }
}
