package com.sb.problems.linked_lists;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode populateLinkedList(List<Integer> lst) {
        ListNode head = null;
        ListNode prev = null;
        for(Integer i:lst) {
            ListNode ln = new ListNode(i);
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
