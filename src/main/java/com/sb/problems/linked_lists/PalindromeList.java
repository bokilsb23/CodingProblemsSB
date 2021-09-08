package com.sb.problems.linked_lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 */
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

    /**
     * Solution using stack
     * @param A - Head of linked list
     * @return - 1 if is palindrome, else 0
     */
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


    //InterviewBit Solution

    public int lPalin(ListNode A) {
        if(A==null||A.next==null){
            return 1;
        }
        ListNode slow=A;
        ListNode fast=A;

        //Get slow pointer to mid of the linked list
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse the second half of the linked list
        slow.next=reverseList(slow.next);


        //Compare both halves
        slow=slow.next;
        while(slow!=null){
            if(A.val!=slow.val){
                return 0;
            }
            A=A.next;
            slow=slow.next;
        }
        return 1;
    }
    ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }

}
