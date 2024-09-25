package com.sb.problems.lc.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true



Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.


 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Character> charMap = new HashMap<>();
        for(int i = 0; i < a.length(); i++) {
            if(!charMap.containsKey(a.charAt(i))) {
                charMap.put(a.charAt(i), b.charAt(i));
            } else if(!charMap.get(a.charAt(i)).equals(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("ketki", "saket"));
    }
}
