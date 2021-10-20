package com.sb.problems.linked_lists;

import java.util.Stack;

import static java.util.Arrays.asList;

public class ReverseLinkedList {


    public static void main(String[] args) {
        ListNode list = ListNode.populateLinkedList(asList(1,4,5,8,2));
        System.out.println(reverseLinkedList(list));
    }

    //Using stack
    private static ListNode reverseLinkedList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        stack.push(head.val);
        while(curr.next != null) {
            curr = curr.next;
            stack.push(curr.val);
        }

        ListNode prev = null;
        ListNode result;
        ListNode resHead = null;
        boolean first = true;
        while(!stack.isEmpty()) {
            result = new ListNode(stack.pop());
            if(prev != null) {
                prev.next = result;
            }
            prev = result;
            if(first) {
                resHead = result;
                first = false;
            }
        }
        return resHead;
    }
}
