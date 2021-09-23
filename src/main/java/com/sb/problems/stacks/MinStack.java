package com.sb.problems.stacks;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minValStack;
    public MinStack() {
        stack =  new Stack<>();
        minValStack = new Stack<>();
    }

    private void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minValStack.push(x);
        }
        else {
            stack.push(x);
            int min = minValStack.pop();
            minValStack.push(min);
            if (x < min)
                minValStack.push(x);
            else
                minValStack.push(min);
        }
    }

    public void pop() {
        if(!stack.isEmpty()) stack.pop();
        if(!minValStack.isEmpty())minValStack.pop();
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minValStack.isEmpty() ? -1 : minValStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(10);
        ms.push(20);
        ms.push(30);
        System.out.println(ms.getMin());
        ms.push(5);
        System.out.println(ms.getMin());
    }
}
