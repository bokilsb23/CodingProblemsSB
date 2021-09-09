package com.sb.problems.linked_lists;

import java.util.Arrays;

import static com.sb.problems.linked_lists.ListNode.populateLinkedList;


/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 *
 *     342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 *
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddNumbersAsLists {
    public static void main(String[] args) {
        ListNode res = addNumbersAsLists(populateLinkedList(Arrays.asList(2,4,3)), populateLinkedList(Arrays.asList(5,6,4)));

        ListNode res1 = addNumbersAsLists(populateLinkedList(Arrays.asList(9,9,9)), populateLinkedList(Arrays.asList(9,9,9,9)));
        ListNode res2 = addNumbersAsLists(populateLinkedList(Arrays.asList(9,9,9,0,0)), populateLinkedList(Arrays.asList(9,9,9,0,0)));
    }


    /**
     * InterviewBit solution
     * @param A - First number reversed list
     * @param B - second number reversed list
     * @return - reversed result
     */
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head = null;
        int sum = 0;
        int carry = 0;
        ListNode prev = null;
        ListNode last = null;
        while (A != null || B != null) {
            sum=0;
            if (A != null) {
                sum = A.val;
                A = A.next;
            }
            if (B != null) {
                sum = sum + B.val;
                B = B.next;
            }
            sum = sum + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10 % 10;
            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
            if (node.val != 0) {
                last = node;
            }
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            prev.next = node;
            node.next = null;
            last = node;
        }
        last.next = null;
        return head;
    }

    /**
     * My Solution
     * @param A - First number reversed list
     * @param B - second number reversed list
     * @return - reversed result
     */
    private static ListNode addNumbersAsLists(ListNode A, ListNode B) {

        if(A == null) {
            return B;
        }
        if(B == null) {
            return A;
        }

        ListNode currA = A;
        ListNode currB = B;
        ListNode prevNode = null;
        ListNode resHead = null;
        ListNode currNode = null;
        int carry = 0;

        while(currA != null && currB != null) {
            int valA = currA.val;
            int valB = currB.val;
            int currSum = valA+valB+carry;
            int currVal = (currSum) % 10;
            carry = (currSum)/10;
            currNode = new ListNode(currVal);
            if(prevNode == null) {
                resHead = currNode;
            } else {
                prevNode.next = currNode;
            }
            prevNode = currNode;
            currA = currA.next;
            currB = currB.next;
        }

        while(currA != null) {
            int currSum = currA.val + carry;
            int currVal = (currSum) % 10;
            carry = (currSum)/10;
            currNode = new ListNode(currVal);
            prevNode.next = currNode;
            prevNode = currNode;
            currA = currA.next;
        }

        while(currB != null) {
            int currSum = currB.val + carry;
            int currVal = (currSum) % 10;
            carry = (currSum)/10;
            currNode = new ListNode(currVal);
            prevNode.next = currNode;
            prevNode = currNode;
            currB = currB.next;
        }
        if(carry != 0) {
            currNode = new ListNode(carry);
            prevNode.next = currNode;
        }
        return removeTrailingZeroes(resHead);

    }

    private static ListNode removeTrailingZeroes(ListNode resHead) {
        ListNode node = reverse(resHead);

        while(node != null && node.val == 0) {
            node = node.next;
        }

        return reverse(node);
    }

    private static ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
