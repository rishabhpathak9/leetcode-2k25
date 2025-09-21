package com.zenith.something.fastSlowPointers;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) {
                break;
            }
        }
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
        int result = findDuplicateNumber.findDuplicate(new int[]{1, 2, 3, 4, 2, 5});
        System.out.println("Duplicate number is : " + result);
    }
}
