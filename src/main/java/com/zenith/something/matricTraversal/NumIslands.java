package com.zenith.something.matricTraversal;

public class NumIslands {

    /**
     * LeetCode 200: Number of Islands (practice scaffold)
     * 
     * Given an m x n 2D binary grid `grid` which represents a map of '1's (land) and '0's (water),
     * return the number of islands.
     * 
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
     * or vertically. You may assume all four edges of the grid are all surrounded by water.
     * 
     * Example 1:
     * Input: grid = [
     *   ['1','1','1','1','0'],
     *   ['1','1','0','1','0'],
     *   ['1','1','0','0','0'],
     *   ['0','0','0','0','0']
     * ]
     * Output: 1
     * 
     * Example 2:
     * Input: grid = [
     *   ['1','1','0','0','0'],
     *   ['1','1','0','0','0'],
     *   ['0','0','1','0','0'],
     *   ['0','0','0','1','1']
     * ]
     * Output: 3
     */

    public int numIslands(char[][] grid) {
        int c= 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i< m; i++){
            for (int j = 0; j< n; j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(i,j,grid);
                }
            }
        }
        return c;
        
    }

    private void dfs(int r, int c, char[][] grid){

        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length){
            if(grid[r][c] == '1'){
                grid[r][c] = '0';
           
                dfs(r-1,c,grid);
                dfs(r+1,c,grid);
                dfs(r,c+1,grid);
                dfs(r,c-1,grid);
            }
        }
    }

    private static void printGrid(char[][] grid) {
        System.out.println("Grid:");
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        NumIslands solver = new NumIslands();

        // Case 1: Single connected island
        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("Case 1: Single connected island");
        printGrid(grid1);
        System.out.println("Expected: 1");
        printResult(solver.numIslands(grid1));

        // Case 2: Multiple disconnected islands
        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("\nCase 2: Multiple disconnected islands");
        printGrid(grid2);
        System.out.println("Expected: 3");
        printResult(solver.numIslands(grid2));

        // Case 3: All water (no islands)
        char[][] grid3 = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        System.out.println("\nCase 3: All water (no islands)");
        printGrid(grid3);
        System.out.println("Expected: 0");
        printResult(solver.numIslands(grid3));

        // Case 4: All land (one big island)
        char[][] grid4 = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        System.out.println("\nCase 4: All land (one big island)");
        printGrid(grid4);
        System.out.println("Expected: 1");
        printResult(solver.numIslands(grid4));

        // Case 5: Checkerboard pattern (max islands)
        char[][] grid5 = {
            {'1','0','1','0'},
            {'0','1','0','1'},
            {'1','0','1','0'},
            {'0','1','0','1'}
        };
        System.out.println("\nCase 5: Checkerboard pattern");
        printGrid(grid5);
        System.out.println("Expected: 8");
        printResult(solver.numIslands(grid5));

        // Case 6: Diagonal islands (not connected)
        char[][] grid6 = {
            {'1','0','0'},
            {'0','1','0'},
            {'0','0','1'}
        };
        System.out.println("\nCase 6: Diagonal pattern (not connected)");
        printGrid(grid6);
        System.out.println("Expected: 3");
        printResult(solver.numIslands(grid6));
    }
}
