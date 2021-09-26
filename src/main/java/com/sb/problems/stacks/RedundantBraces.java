package com.sb.problems.stacks;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        System.out.println(redundantBraces("((a+b))"));
        System.out.println(redundantBraces("(b)"));
        System.out.println(redundantBraces("(a+b)"));
        System.out.println(redundantBraces("(a+(a+b))"));
    }

    private static int redundantBraces(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(c == ')') {
                int count = 0;
                while(!stack.isEmpty() && stack.peek() != '(') {
                    count++;
                    stack.pop();
                }
                stack.pop();//to remove ( after the expression so that it doesn't get calculated in next expression
                if(count < 2) {
                    return 1;
                }
            }
            else {
                stack.push(c);
            }
        }
        return 0;
    }
}
