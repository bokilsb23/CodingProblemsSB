package com.sb.problems.lc.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an
anagram
of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.



Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class Anagram {
    public boolean isAnagram(String a, String b) {
        if(a == null || b == null) {
            return false;
        }
        if(a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            if(!map.containsKey(b.charAt(i))) {
                return false;
            }
            if(map.get(b.charAt(i)) == 1) {
                map.remove(b.charAt(i));
            } else {
                map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        Anagram a = new Anagram();
        System.out.println(a.isAnagram("anagram", "nagaram"));
        System.out.println(a.isAnagram("rat", "car"));
        System.out.println(a.isAnagram("saket", "ketsa"));
        System.out.println(a.isAnagram(" ", " "));
    }
}
