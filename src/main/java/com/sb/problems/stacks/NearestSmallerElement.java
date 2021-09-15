package com.sb.problems.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 *
 * More formally,
 *
 *     G[i] for an element A[i] = an element A[j] such that
 *     j is maximum possible AND
 *     j < i AND
 *     A[j] < A[i]
 * Elements for which no smaller element exist, consider next smaller element as -1.
 *
 * Input Format
 *
 * The only argument given is integer array A.
 * Output Format
 *
 * Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
 * For Example
 *
 * Input 1:
 *     A = [4, 5, 2, 10, 8]
 * Output 1:
 *     G = [-1, 4, -1, 2, 2]
 * Explaination 1:
 *     index 1: No element less than 4 in left of 4, G[1] = -1
 *     index 2: A[1] is only element less than A[2], G[2] = A[1]
 *     index 3: No element less than 2 in left of 2, G[3] = -1
 *     index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
 *     index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
 *
 * Input 2:
 *     A = [3, 2, 1]
 * Output 2:
 *     [-1, -1, -1]
 * Explaination 2:
 *     index 1: No element less than 3 in left of 3, G[1] = -1
 *     index 2: No element less than 2 in left of 2, G[2] = -1
 *     index 3: No element less than 1 in left of 1, G[3] = -1
 */
public class NearestSmallerElement {
    public static void main(String[] args) {
        System.out.println(nearestSmallerElement(Arrays.asList(4,5,2,10,8)));
        System.out.println(nearestSmallerElement(Arrays.asList(-1,4,-1,2,2)));
        System.out.println(nearestSmallerElement(Arrays.asList(1,6,4,10,2,5)));
        System.out.println(nearestSmallerElement(Arrays.asList(1,3,0,2,5)));

    }

    private static List<Integer> nearestSmallerElement(List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(Integer i : A) {
            while(!stack.isEmpty() && stack.peek() >= i) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(i);
        }
        return result;
    }
}
