package com.zenith.patterns.linkedListInPlaceReversal;

import com.zenith.structures.ListNode;
import static com.zenith.structures.ListNode.printList;

public class SwapNodeInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = head;
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode toReturn = head.getNext();
        ListNode curr;
        ListNode next;
        ListNode lastPrev = null;
        while (prev != null && prev.getNext() != null) {
            curr = prev.getNext();
            next = curr.getNext();
            curr.setNext(prev);
            prev.setNext(next);
            if (lastPrev != null) {
                lastPrev.setNext(curr);
            }
            lastPrev = prev;
            prev = next;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        SwapNodeInPairs swapNodeInPairs = new SwapNodeInPairs();
        ListNode head = ListNode.createSampleLinkedList();
        printList(head);
        head = swapNodeInPairs.swapPairs(head);
        printList(head);

    }
}
