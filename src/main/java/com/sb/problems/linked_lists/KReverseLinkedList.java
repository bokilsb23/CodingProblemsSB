package com.sb.problems.linked_lists;

import java.util.Arrays;
import java.util.Stack;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 *
 * list K at a time and returns modified linked list.
 *
 * NOTE : The length of the list is divisible by K
 */
public class KReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = populateLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode1 = kReverseLinkedList(listNode, 2);
    }

    /**
     * Solution using stack
     * @param A - Head of linked list
     * @param B - integer K
     * @return - head of modified linked list
     */
    private static ListNode kReverseLinkedList(ListNode A, int B) {
        ListNode curr = A;
        ListNode currNode;
        ListNode prevNode = null;
        ListNode head = null;
        Stack<Integer> stack = new Stack<>();
        while(curr != null) {
            int i = 0;
            while (i < B && curr != null) {
                stack.push(curr.val);
                curr = curr.next;
                i++;
            }
            while (!stack.isEmpty()) {
                currNode = new ListNode(stack.pop());
                if(head == null) {
                    head = currNode;
                }
                if(prevNode != null) {
                    prevNode.next = currNode;
                }
                prevNode = currNode;
            }
        }
        return head;
    }
}
