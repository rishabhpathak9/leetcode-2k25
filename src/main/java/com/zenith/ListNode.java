package com.zenith;

public class ListNode {

    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createSampleLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public static void printList(ListNode head) {
        System.out.println("The values in the linkedList list are: ");
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
    }
}
