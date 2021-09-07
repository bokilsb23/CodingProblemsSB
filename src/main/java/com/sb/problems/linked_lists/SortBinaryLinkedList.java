package com.sb.problems.linked_lists;

import java.util.Arrays;
import java.util.List;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;


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

    private static ListNode solve(ListNode A) {
        int numZeroes=0;
        int numOnes=0;

        ListNode next = A;
        while(next != null) {
            if(next.val==0) {
                numZeroes++;
            }
            if(next.val==1) {
                numOnes++;
            }
            next = next.next;
        }

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
}
