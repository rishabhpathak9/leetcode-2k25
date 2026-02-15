package com.zenith.patterns.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {

    class RottenIndex {
        int i;
        int j;
        int time;

        public RottenIndex(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n =grid[0].length;
        Deque<RottenIndex> queue = new ArrayDeque<>();
        int freshAtStart = 0;
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 2){
                    queue.add(new RottenIndex(i, j, 0));
                } else if (grid[i][j] == 1){
                    freshAtStart++;
                }
            }
        }
        int currTime = 0;
        while (!queue.isEmpty()) {
            RottenIndex rottenIndex = queue.poll();
            int i = rottenIndex.i;
            int j = rottenIndex.j;
            currTime = rottenIndex.time;

            if(rottenIndex.i != 0){
                if (grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    freshAtStart--;
                    queue.add(new RottenIndex(i-1, j, currTime+1));
                }
            }
            if(rottenIndex.j != 0){
                if (grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    freshAtStart--;
                    queue.add(new RottenIndex(i, j-1, currTime+1));
                }
            }
            if(rottenIndex.i != m-1){
                if (grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    freshAtStart--;
                    queue.add(new RottenIndex(i+1, j, currTime+1));
                }
            }
            if(rottenIndex.j != n-1){
                if (grid[i][j+1] == 1){ 
                    grid[i][j+1] = 2;
                    freshAtStart--;
                    queue.add(new RottenIndex(i, j+1, currTime+1));
                }
            }   
        }
        return freshAtStart > 0 ? -1 : currTime;
    }

    private static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();

        // Case 1: Normal case with multiple rotten oranges
        // Grid:
        // 2 1 1
        // 1 1 0
        // 0 1 1
        int[][] grid1 = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println("Case 1: Multiple rotten oranges");
        System.out.println("Expected: 4 (all oranges rot in 4 minutes)");
        printResult(solver.orangesRotting(grid1));

        // Case 2: Single fresh orange with adjacent rotten
        // Grid:
        // 2 1
        // 1 1
        int[][] grid2 = {
                { 2, 1 },
                { 1, 1 }
        };
        System.out.println("\nCase 2: 2x2 grid");
        System.out.println("Expected: 2");
        printResult(solver.orangesRotting(grid2));

        // Case 3: Only rotten oranges
        // Grid:
        // 2 2
        // 2 2
        int[][] grid3 = {
                { 2, 2 },
                { 2, 2 }
        };
        System.out.println("\nCase 3: All rotten");
        System.out.println("Expected: 0");
        printResult(solver.orangesRotting(grid3));

        // Case 4: Impossible case - fresh orange isolated
        // Grid:
        // 2 0 1
        // 0 0 0
        // 0 0 1
        int[][] grid4 = {
                { 2, 0, 1 },
                { 0, 0, 0 },
                { 0, 0, 1 }
        };
        System.out.println("\nCase 4: Fresh oranges isolated (impossible)");
        System.out.println("Expected: -1");
        printResult(solver.orangesRotting(grid4));

        // Case 5: Only fresh oranges (no rotten)
        // Grid:
        // 1 1
        // 1 1
        int[][] grid5 = {
                { 1, 1 },
                { 1, 1 }
        };
        System.out.println("\nCase 5: Only fresh oranges");
        System.out.println("Expected: -1");
        printResult(solver.orangesRotting(grid5));

        // Case 6: No oranges at all
        // Grid:
        // 0 0
        // 0 0
        int[][] grid6 = {
                { 0, 0 },
                { 0, 0 }
        };
        System.out.println("\nCase 6: Empty grid (no oranges)");
        System.out.println("Expected: 0");
        printResult(solver.orangesRotting(grid6));

        // Case 7: Single rotten orange
        // Grid:
        // 2
        int[][] grid7 = { { 2 } };
        System.out.println("\nCase 7: Single rotten orange");
        System.out.println("Expected: 0");
        printResult(solver.orangesRotting(grid7));

        // Case 8: Single fresh orange
        // Grid:
        // 1
        int[][] grid8 = { { 1 } };
        System.out.println("\nCase 8: Single fresh orange");
        System.out.println("Expected: -1");
        printResult(solver.orangesRotting(grid8));

        int[][] grid9 = {
                { 2, 2 },
                { 1, 1 },
                { 0, 0 },
                { 2, 0 },
                
        };
        System.out.println("\nCase 9: Empty grid (no oranges)");
        System.out.println("Expected: 0");
        printResult(solver.orangesRotting(grid9));
    }
}
