package com.sb.problems.stacks;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        //System.out.println(simplifyPath("/a/./b/../../c/"));
        //System.out.println(simplifyPath("/a/./b/../c/"));
        //System.out.println(simplifyPath("/home/"));
       // System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }

    private static String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String substring = A.substring(1);
        String[] dirs = substring.split("/");

        for(String dir:dirs) {
            if(!dir.equals(".") && !dir.equals("..") && !dir.trim().isEmpty()) {
                stack.push(dir);
            }
            else if(dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) {
            return "/";
        }
        for(String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
}
