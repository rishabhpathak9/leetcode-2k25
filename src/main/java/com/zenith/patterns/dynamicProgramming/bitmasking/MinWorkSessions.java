package com.zenith.patterns.dynamicProgramming.bitmasking;

/**
 * LeetCode 1986: Minimum Number of Work Sessions to Finish the Tasks
 *
 * There are n tasks assigned to you. The task takes an integer taskTime[i]
 * hours to finish.
 * You are also given an integer sessionTime which is the maximum hours per
 * session.
 * You are allowed to complete the tasks in any order and in multiple sessions.
 * Find the minimum number of sessions needed to complete all the given tasks.
 */
public class MinWorkSessions {

    int sessionTime;

    public int minSessions(int[] tasks, int sessionTime) {
        this.sessionTime = sessionTime;
        return 1 + dp(tasks, (1 << tasks.length) - 1, sessionTime);
    }

    private int dp(int[] tasks, int mask, int timeLeft) {
        if (mask == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            if ((mask & (1 << i)) == 0)
                continue;
            int task = tasks[i];
            int nextMask = mask ^ (1 << i);

            if (timeLeft >= task)
                ans = Math.min(ans, dp(tasks, nextMask, timeLeft - task));
            else
                ans = Math.min(ans, 1 + dp(tasks, nextMask, sessionTime - task));
        }
        return ans;
    }

    public static void main(String[] args) {
        MinWorkSessions mws = new MinWorkSessions();

        System.out.println("Test 1: tasks = [1,2,3,4,5], sessionTime = 15");
        System.out.println("Output: " + mws.minSessions(new int[] { 1, 2, 3, 4, 5 }, 15));
        System.out.println("Expected: 1\n");

        System.out.println("Test 2: tasks = [3,1,3,2], sessionTime = 8");
        System.out.println("Output: " + mws.minSessions(new int[] { 3, 1, 3, 2 }, 8));
        System.out.println("Expected: 2\n");

        System.out.println("Test 3: tasks = [1,2,3], sessionTime = 3");
        System.out.println("Output: " + mws.minSessions(new int[] { 1, 2, 3 }, 3));
        System.out.println("Expected: 2\n");
    }
}
