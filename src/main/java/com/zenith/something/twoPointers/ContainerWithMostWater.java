package com.zenith.something.twoPointers;


public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int beg =0;
        int end = height.length-1;
        int maxVa = 0;
        while (beg<end){
            int currAr = Math.min(height[beg], height[end])*(end-beg);
            if (maxVa < currAr){
                maxVa=currAr;
            }
            if(height[beg] > height[end]){
                end--;
            } else {
                beg++;
            }
        }
        return maxVa;
    }
    
    public int[] createSampleInput() {
        return new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    }

    public static void main(String[] args) {
        ContainerWithMostWater ma = new ContainerWithMostWater();
        int[] sample = ma.createSampleInput();
        for (int num : sample) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
