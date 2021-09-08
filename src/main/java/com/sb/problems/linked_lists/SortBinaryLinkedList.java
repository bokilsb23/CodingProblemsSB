package com.sb.problems.linked_lists;

import java.util.Arrays;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;

/**
 * Given a Linked List A consisting of N nodes.
 *
 * The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.
 *
 * You need to sort the linked list and return the new linked list.
 *
 * NOTE:
 *
 * Try to do it in constant space.
 */
public class SortBinaryLinkedList {
    public static void main(String[] args) {
        ListNode listNode = populateLinkedList(Arrays.asList(0, 1, 1, 1, 0, 0, 0));
        ListNode solve = solve(listNode);
        listNode = populateLinkedList(Arrays.asList(0, 0, 0, 0));
        solve = solve(listNode);
        listNode = populateLinkedList(Arrays.asList(1,1,1,1));
        solve = solve(listNode);
        listNode = populateLinkedList(Arrays.asList());
        solve = solve(listNode);

    }

    private static ListNode sortBinaryLinkedList(ListNode A) {
        int numZeroes=0;
        int numOnes=0;

        ListNode next = A;
        //count number of 0s and 1s
        while(next != null) {
            if(next.val==0) {
                numZeroes++;
            }
            if(next.val==1) {
                numOnes++;
            }
            next = next.next;
        }

        //create a new linked list and populate it with 0s and 1s in sequence
        ListNode head = null;
        ListNode prev = null;
        for(int i=0; i<numZeroes;i++) {
            ListNode ln = new ListNode(0);
            if(prev != null) {
                prev.next = ln;
            } else {
                head = ln;
            }
            prev = ln;
        }
        for(int i = 0; i<numOnes; i++) {
            ListNode ln = new ListNode(1);
            if(prev != null) {
                prev.next = ln;
            } else {
                head = ln;
            }
            prev = ln;
        }
        return head;
    }


    /**
     * InterviewBit method
     * @param A - head of linked list
     * @return - head of sorted linked list
     */
    private static ListNode solve(ListNode A) {
        ListNode start = new ListNode(0);
        start.next = A;
        ListNode curr = A, prev = start;
        while(curr != null){
            if(curr.next != null && (curr.next.val < curr.val)){
                // Insertion
                //keep checking in reverse until previous value is lesser than current value, and then insert
                while(prev.next != null && (prev.next.val < curr.next.val))
                    prev = prev.next;
                ListNode temp = prev.next;
                prev.next = curr.next;//pop out current value from the list
                curr.next = curr.next.next;
                prev.next.next = temp;
                prev = start;
            } else
                curr = curr.next;
        }
        return start.next;
    }



}
