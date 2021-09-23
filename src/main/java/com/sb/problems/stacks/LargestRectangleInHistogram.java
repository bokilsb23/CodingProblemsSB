package com.sb.problems.stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(getLargestArea(new int[]{6,2,5,4,5,1,6}));
    }

    private static int getLargestArea(int[] A) {
        int maxArea = 0;
        int top;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < A.length) { //for all the elements in the array
            if(stack.isEmpty() || A[stack.peek()] <= A[i]) {//push the current element to stack if the previous element was smaller or the stack is empty
                stack.push(i++);
            }
            else {//if the previous element was larger, pop the previous element, and calculate area till the previous smallest bar with the height of current popped element
                //This step is calculating area considering currently popped element as the smallest, so any bar smaller than current bar will be our terminating condition on both sides
                //we terminate right by checking i's length, and the left smaller will be peek of the stack
                top = stack.pop();
                int currArea = A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxArea < currArea) {
                    maxArea = currArea;
                }
            }

        }
        //check remaining bards in the stack for same condition
        while(!stack.isEmpty()) {
            top = stack.pop();
            int currArea  = A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

            if(maxArea < currArea) {
                maxArea = currArea;
            }
        }
        return maxArea;
    }
}
