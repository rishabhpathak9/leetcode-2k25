package com.zenith.patterns.linkedListInPlaceReversal;

import java.util.Objects;

import com.zenith.structures.ListNode;
import static com.zenith.structures.ListNode.printList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        ListNode newHead = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = ListNode.createSampleLinkedList();
        printList(head);
        head = reverseLinkedList.reverseList(head);
        printList(head);

    }

}
