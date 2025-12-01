package com.zenith.something.monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<TempCount> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currTemp = temperatures[i];
            int countSinceLast = 0;
            while (!stack.isEmpty() && stack.peek().getTemp() <= currTemp) {
                countSinceLast += stack.pop().getCount();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
                stack.push(new TempCount(currTemp, 0));
            } else {
                result[i] = ++countSinceLast;
                stack.push(new TempCount(currTemp, countSinceLast));
            }

        }
        return result;
    }
}

class TempCount {

    private int temp;
    private int count;

    protected TempCount(int temp, int count) {
        this.temp = temp;
        this.count = count;
    }

    protected int getTemp() {
        return temp;
    }

    protected int getCount() {
        return count;
    }
}
