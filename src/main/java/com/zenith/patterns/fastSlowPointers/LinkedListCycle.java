package com.zenith.patterns.fastSlowPointers;

import java.util.Objects;

import com.zenith.structures.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Method to create a sample linked list with a cycle
    public static ListNode createSampleLinkedListWithCycle() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = createSampleLinkedListWithCycle();
        LinkedListCycle detector = new LinkedListCycle();
        boolean hasCycle = detector.hasCycle(head);
        System.out.println("Linked list has cycle: " + hasCycle);
    }
}
