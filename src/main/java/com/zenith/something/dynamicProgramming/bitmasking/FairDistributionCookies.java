package com.zenith.something.dynamicProgramming.bitmasking;

/**
 * LeetCode 2305: Fair Distribution of Cookies
 *
 * You are given an integer array cookies of length n, where cookies[i]
 * represents
 * the number of cookies in the ith bag. You are also given an integer k that
 * represents
 * the number of children to distribute all the bags of cookies to. All the bags
 * of cookies
 * must be distributed to the children such that the unfairness is minimized.
 * Return the minimum unfairness.
 */
public class FairDistributionCookies {

    int n;
    int[] cs;

    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        int fullMask = (1<<n)-1;
        cs = cookies;
        return solve(fullMask, k);
    }
        

    private int solve(int mask, int k) {
        if(mask == 0) return 0;

        if (k==1) return sum(mask);

        int ans = Integer.MAX_VALUE;
        for(int sub = mask; sub>0; sub = mask & (sub - 1)){
            ans = Math.min(ans, Math.max(solve(sub^mask, k-1), sum(sub)));
            
        }
        return ans;
    }

    private int sum(int mask) {
        int res = 0;
        for(int i = 0; i<n; i ++){
            if(((1<<i)&mask) != 0) res += cs[i];
        }
        return res;
    }


    public static void main(String[] args) {
        FairDistributionCookies fdc = new FairDistributionCookies();

        System.out.println("Test 1: cookies = [8,15,10,20,8], k = 2");
        System.out.println("Output: " + fdc.distributeCookies(new int[] { 8,15,10,20,8}, 2));
        System.out.println("Expected: 31\n");

        System.out.println("Test 2: cookies = [6,6,6,6], k = 3");
        System.out.println("Output: " + fdc.distributeCookies(new int[] { 6, 6, 6, 6 }, 3));
        System.out.println("Expected: 12\n");

        System.out.println("Test 3: cookies = [1,2,3,4,5], k = 2");
        System.out.println("Output: " + fdc.distributeCookies(new int[] { 1, 2, 3, 4, 5 }, 2));
        System.out.println("Expected: 8\n");
    }
}
