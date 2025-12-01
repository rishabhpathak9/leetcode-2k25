package com.zenith.something.linkedListInPlaceReversal;

import com.zenith.ListNode;
import static com.zenith.ListNode.printList;

public class ReverseLinkedListII {

    public ListNode reverseList2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.setNext(head);
        ListNode curr = dummyNode;
        ListNode beforeLeft = curr;
        int i = 0;
        while (i < left) {
            beforeLeft = curr;
            curr = curr.getNext();
            i++;
        }
        ListNode leftNode = curr;
        ListNode prev = curr;
        curr = curr.getNext();
        ListNode next = curr;
        while (i < right) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            i++;
        }
        leftNode.setNext(next);
        beforeLeft.setNext(prev);
        return dummyNode.getNext();
    }

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedList = new ReverseLinkedListII();
        ListNode head = ListNode.createSampleLinkedList();
        printList(head);
        head = reverseLinkedList.reverseList2(head, 2, 4);
        printList(head);

    }

}
