package com.zenith.patterns.fastSlowPointers;

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = sumOfSquare(n);
        int fast = sumOfSquare(slow);
        while (fast != 1 && fast != slow) {
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));
        }
        return fast == 1;
    }

    private int sumOfSquare(int val) {
        int sum = 0;
        while (val > 0) {
            int x = (val % 10);
            sum += x * x;
            val = val / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        for (int n = 1; n < 31; n++) {
            boolean result = happyNumber.isHappy(n);
            System.out.println("Is " + n + " a happy number? " + result);
        }
    }
}
