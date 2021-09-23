package com.sb.problems.stacks;

import java.util.Stack;

public class EvaluateReversePolishExpression {
    public static void main(String[] args) {
        System.out.println(evaluateExpression(new String[]{"4","13","5","/","+"}));
        System.out.println(evaluateExpression(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println(evaluateExpression(new String[]{"2","1","+","3","*"}));
    }

    private static int evaluateExpression(String[] str) {
        Stack<Integer> stack = new Stack<>();
        for(String curr : str) {
            if(isNumber(curr)) {
                stack.push(Integer.parseInt(curr));
            } else {
                stack.push(operate(stack.pop(), stack.pop(), curr));
            }
        }
        return stack.pop();
    }

    private static Integer operate(int secondElement, int firstElement, String curr) {
        switch (curr) {
            case "+":
                return firstElement+secondElement;
            case "-":
                return firstElement-secondElement;
            case "*":
                return firstElement*secondElement;
            case "/":
                return firstElement/secondElement;
            default:
                throw new RuntimeException("Unsupported operator");
        }
    }

    private static boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }
}
