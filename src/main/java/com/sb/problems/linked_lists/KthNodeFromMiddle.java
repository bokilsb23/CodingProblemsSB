package com.sb.problems.linked_lists;

import java.util.Arrays;
import java.util.Stack;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;

/**
 * Given a linked list A of length N and an integer B.
 *
 * You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.
 *
 * If no such element exists, then return -1.
 *
 * NOTE:
 *
 * Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.
 */
public class KthNodeFromMiddle {
    public static void main(String[] args) {
        System.out.println(kthNodeFromMiddle(populateLinkedList(Arrays.asList(3,4,7,5,6,16,15,61,16)), 3));
        System.out.println(kthNodeFromMiddle(populateLinkedList(Arrays.asList(1,14,6,16,4,10)), 2));
        System.out.println(kthNodeFromMiddle(populateLinkedList(Arrays.asList(1,14,6,16,4,10)), 10));


        System.out.println(solve(populateLinkedList(Arrays.asList(3,4,7,5,6,16,15,61,16)), 3));
        System.out.println(solve(populateLinkedList(Arrays.asList(1,14,6,16,4,10)), 2));
        System.out.println(solve(populateLinkedList(Arrays.asList(1,14,6,16,4,10)), 10));
    }

    /**
     * Solution using stack
     * @param A - first element of the LinkedList
     * @param B - Bth node from the middle towards head
     * @return - value of Bth node from the middle towards head
     */
    private static int kthNodeFromMiddle(ListNode A, int B) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = A;
        while(curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        int mid = (stack.size()/2)+1;
        if(B >= mid) {
            return -1;
        }
        return stack.get(mid - (B+1));
    }

    /**
     * InterviewBit solution method. This one doesn't require stack
     * @param head - first element of the LinkedList
     * @param B - Bth node from the middle towards head
     * @return - value of Bth node from the middle towards head
     */
    private static int solve(ListNode head, int B) {
        ListNode slow = head;
        ListNode fast = head;
        int mid = 0;

        //This loop will make point slow to the middle element and 'mid' will contain the mid length of the given linked list
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            mid++;
            fast = fast.next.next;
        }
        //Returning -1 in case the desired position is greater than B (Caution:In case you initialize mid with 1, you need to check for B>=mid)
        if(B>mid) return -1;

        //Finding the actual kth value from the beginning of list
        int kthFromHead = mid - B;
        slow = head;

        //Moving to the kth node from beginning
        while(kthFromHead-->0) {
            slow = slow.next;
        }
        return slow.val;
    }
}
