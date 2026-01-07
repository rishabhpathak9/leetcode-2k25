package com.zenith.something.dynamicProgramming.editDistance;

/**
 * LeetCode 712: Minimum ASCII Delete Sum for Two Strings
 *
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted
 * characters
 * to make the two strings equal.
 */
public class MinimumASCIIDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int tot = 0;
        for(int i =0; i<m; i++){
            tot+=(int)s1.charAt(i);
        }
        for(int i =0; i<n; i++){
            tot+=(int)s2.charAt(i);
        }
        int[][] dp = new  int[m+1][n+1];

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j-1]+(int)s1.charAt(i-1), dp[i][j]);
                }
            }
        }
        dp(s1,m,s2,n);
        return tot-2*dp[m][n];
    }

    private int dp(String s1, int m, String s2, int n) {
        if(m == 0 || n==0){
            return 0;
        }
        int toReturn = Math.max(dp(s1, m-1, s2, n),dp(s1, m, s2, n-1));
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            toReturn = Math.max(dp(s1, m-1, s2, n-1)+(int)s1.charAt(m-1)+(int)s2.charAt(n-1), toReturn);
        }
        return toReturn;
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSum sol = new MinimumASCIIDeleteSum();

        System.out.println("Test 1: s1 = \"sea\", s2 = \"eat\"");
        System.out.println("Output: " + sol.minimumDeleteSum("sea", "eat"));
        System.out.println(
                "Expected: 231 (delete 's'(115) + 'a'(97) + 't'(116) = 328 or delete 's'(115) + 'e'(101) + 'a'(97) = 313, min is 231)\n");

        System.out.println("Test 2: s1 = \"delete\", s2 = \"leet\"");
        System.out.println("Output: " + sol.minimumDeleteSum("delete", "leet"));
        System.out.println("Expected: 403\n");

        System.out.println("Test 3: s1 = \"abc\", s2 = \"abc\"");
        System.out.println("Output: " + sol.minimumDeleteSum("abc", "abc"));
        System.out.println("Expected: 0\n");

        System.out.println("Test 4: s1 = \"a\", s2 = \"b\"");
        System.out.println("Output: " + sol.minimumDeleteSum("a", "b"));
        System.out.println("Expected: 195 (delete 'a'(97) + 'b'(98) = 195)\n");

        System.out.println("Test 5: s1 = \"\", s2 = \"abc\"");
        System.out.println("Output: " + sol.minimumDeleteSum("", "abc"));
        System.out.println("Expected: 294 ('a'(97) + 'b'(98) + 'c'(99))\n");

        System.out.println("Test 6: s1 = \"abc\", s2 = \"\"");
        System.out.println("Output: " + sol.minimumDeleteSum("abc", ""));
        System.out.println("Expected: 294 ('a'(97) + 'b'(98) + 'c'(99))\n");
    }
}
