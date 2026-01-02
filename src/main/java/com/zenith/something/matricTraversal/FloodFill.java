package com.zenith.something.matricTraversal;

public class FloodFill {

    /**
     * LeetCode 733: Flood Fill (practice scaffold)
     * 
     * An image is represented by an m x n integer grid `image` where `image[i][j]` 
     * represents the pixel value of the image.
     * 
     * You are also given three integers sr, sc, and newColor. 
     * You should perform a flood fill on the image starting from the pixel `image[sr][sc]`.
     * 
     * To perform a flood fill:
     * 1. Begin with the starting pixel.
     * 2. Change the color of the pixel to newColor.
     * 3. Perform the same process for any pixels horizontally or vertically adjacent 
     *    to the pixel, as long as they have the same color as the starting pixel.
     * 
     * Return the modified image after performing the flood fill.
     * 
     * Example 1:
     * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     * 
     * Example 2:
     * Input: image = [[0,0,0],[0,1,1]], sr = 1, sc = 1, newColor = 1
     * Output: [[0,0,0],[0,1,1]]
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color){
            return image;
        }
        dfs(image, sr ,sc, color, image[sr][sc]);
        return image;
    }
    int[][] dirs = {
                        {0,1},
                        {1,0},
                        {-1,0},
                        {0,-1}
                    };
    void dfs(int[][] image, int r, int c, int color, int startCol){
        image[r][c] = color;
        for(int[] dir : dirs){
            int nr = r+dir[0];
            int nc = c+dir[1];
            
            if((nr>=0 && nc>=0) && (nr<image.length && nc<image[0].length)){
                if(image[nr][nc] == startCol){
                    dfs(image,nr, nc, color, startCol);
                }
            }
        }
    }

    private static void printImage(int[][] image) {
        System.out.println("Result:");
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloodFill solver = new FloodFill();

        // Case 1: standard example with region to fill
        int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
        int sr1 = 1, sc1 = 1, newColor1 = 2;
        System.out.println("Case 1: image = [[1,1,1],[1,1,0],[1,0,1]], sr=1, sc=1, newColor=2");
        System.out.println("Expected: [[2,2,2],[2,2,0],[2,0,1]]");
        int[][] result1 = solver.floodFill(image1, sr1, sc1, newColor1);
        printImage(result1);

        // Case 2: newColor same as original color (no change)
        int[][] image2 = {{0,0,0},{0,1,1}};
        int sr2 = 1, sc2 = 1, newColor2 = 1;
        System.out.println("\nCase 2: image = [[0,0,0],[0,1,1]], sr=1, sc=1, newColor=1");
        System.out.println("Expected: [[0,0,0],[0,1,1]] (no change, newColor equals original)");
        int[][] result2 = solver.floodFill(image2, sr2, sc2, newColor2);
        printImage(result2);

        // Case 3: single cell image
        int[][] image3 = {{5}};
        int sr3 = 0, sc3 = 0, newColor3 = 7;
        System.out.println("\nCase 3: image = [[5]], sr=0, sc=0, newColor=7");
        System.out.println("Expected: [[7]]");
        int[][] result3 = solver.floodFill(image3, sr3, sc3, newColor3);
        printImage(result3);

        // Case 4: fill entire grid (all same color)
        int[][] image4 = {{3,3,3},{3,3,3},{3,3,3}};
        int sr4 = 0, sc4 = 0, newColor4 = 4;
        System.out.println("\nCase 4: image = [[3,3,3],[3,3,3],[3,3,3]], sr=0, sc=0, newColor=4");
        System.out.println("Expected: all pixels become 4");
        int[][] result4 = solver.floodFill(image4, sr4, sc4, newColor4);
        printImage(result4);

        // Case 5: disconnected regions
        int[][] image5 = {{1,0,1},{0,1,0},{1,0,1}};
        int sr5 = 0, sc5 = 0, newColor5 = 2;
        System.out.println("\nCase 5: image = [[1,0,1],[0,1,0],[1,0,1]], sr=0, sc=0, newColor=2");
        System.out.println("Expected: only corner (0,0) changes to 2 (isolated from others)");
        int[][] result5 = solver.floodFill(image5, sr5, sc5, newColor5);
        printImage(result5);
    }
}
