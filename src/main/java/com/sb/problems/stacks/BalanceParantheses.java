package com.sb.problems.stacks;

import java.util.Stack;

/**
 * Given a string A consisting only of '(' and ')'.
 *
 * You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 * Input Format
 * First argument is an string A.
 *
 * Output Format
 * Return 1 if parantheses in string are balanced else return 0.
 *
 * Example Input
 * Input 1:
 *
 *  A = "(()())"
 * Input 2:
 *
 *  A = "(()"
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 */
public class BalanceParantheses {

    public static void main(String[] args) {
        System.out.println(isBalanced("(()())"));
        System.out.println(solveWithStack("))((()(())"));
        System.out.println(solveWithStack("(())"));
    }

    private static int isBalanced(String str) {
        int count =0;

        for(Character c : str.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
                if(count < 0) {
                    return 0;
                }
            }
        }
        return count == 0 ? 1 : 0;
    }

    private static int solveWithStack(String A) {
        Stack<Character> stack = new Stack<>();
        for(char c: A.toCharArray()) {
            if(c == ')') {
                if(stack.isEmpty() || stack.peek() == ')') {
                    return 0;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
