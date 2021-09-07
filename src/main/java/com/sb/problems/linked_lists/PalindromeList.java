package com.sb.problems.linked_lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode listNode1 = populateLinkedList(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println(isPalindrome(listNode1));

        ListNode listNode2 = populateLinkedList(Arrays.asList(1, 2, 3, 4, 1));
        System.out.println(isPalindrome(listNode2));

        ListNode listNode3 = populateLinkedList(Collections.singletonList(1));
        System.out.println(isPalindrome(listNode3));

        ListNode listNode4 = populateLinkedList(Arrays.asList());
        System.out.println(isPalindrome(listNode4));

        ListNode listNode5 = populateLinkedList(Arrays.asList(1,2,3,3,2,1));
        System.out.println(isPalindrome(listNode5));
    }

    private static int isPalindrome(ListNode A) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = A;

        while(curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = A;
        while(curr != null) {
            if(curr.val != stack.pop()) {
                return 0;
            }
            curr = curr.next;
        }
        return 1;
    }
}
