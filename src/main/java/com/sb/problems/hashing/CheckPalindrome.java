package com.sb.problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {
    private static int checkPalindrome(String A) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : A.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int numOdds = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2 != 0) {
                numOdds++;
            }
        }

        if(A.length()%2 == 0) {
            return numOdds == 0 ? 1 : 0;
        } else {
            return numOdds == 1 ? 1 : 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(checkPalindrome("abcde"));
        System.out.println(checkPalindrome("abbaee"));
        System.out.println(checkPalindrome(""));
        System.out.println(checkPalindrome("abbaeed"));
        System.out.println(checkPalindrome("a"));

    }
}
