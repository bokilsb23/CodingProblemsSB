package com.sb.problems.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class LetterPhone {
    private static List<List<String>> numberToLetter = asList(singletonList("0"), singletonList("1"), asList("a","b","c"), asList("d","e","f"), asList("g","h","i"), asList("j","k","l"),
            asList("m","n","o"), asList("p","q","r","s"), asList("t","u","v"), asList("w","x","y","z"));
    public static void main(String[] args) {
        System.out.println(letterPhoneQueue("0123456"));
        System.out.println(letterPhoneQueue("78912"));
    }

    private static ArrayList<String> letterPhoneQueue(String A) {
        ArrayList<String> results = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add("");

        while(!queue.isEmpty()) {
            String curr = queue.remove();
            if(curr.length() == A.length()) {
                results.add(curr);
            }
            else {
                List<String> currStrings = numberToLetter.get(Integer.parseInt(String.valueOf(A.charAt(curr.length()))));
                for(String currStr : currStrings) {
                    queue.add(curr + currStr);
                }
            }
        }
        return results;
    }

}
