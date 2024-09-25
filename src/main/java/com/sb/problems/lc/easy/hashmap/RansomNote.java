package com.sb.problems.lc.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true



Constraints:

    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.


 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        if (ransomNote.isEmpty()) {
            return true;
        }
        Map<Character, Integer> noteMap = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++) {
            if (noteMap.containsKey(ransomNote.charAt(i))) {
                noteMap.put(ransomNote.charAt(i), noteMap.get(ransomNote.charAt(i)) + 1);
            } else {
                noteMap.put(ransomNote.charAt(i), 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (noteMap.containsKey(magazine.charAt(i))) {
                if(noteMap.get(magazine.charAt(i)) == 1) {
                    noteMap.remove(magazine.charAt(i));
                } else {
                    noteMap.put(magazine.charAt(i), noteMap.get(magazine.charAt(i)) - 1);
                }
            }
            if (noteMap.isEmpty()) {
                return true;
            }
        }
        return false;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        if (ransomNote.isEmpty()) {
            return true;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            if (charMap.containsKey(magazine.charAt(i))) {
                charMap.put(magazine.charAt(i), charMap.get(magazine.charAt(i)) + 1);
            } else {
                charMap.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(!charMap.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            if(charMap.get(ransomNote.charAt(i)) == 1) {
                charMap.remove(ransomNote.charAt(i));
            } else {
                charMap.put(ransomNote.charAt(i), charMap.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("a", "b"));
        System.out.println(rn.canConstruct("abc", "c"));
        System.out.println(rn.canConstruct("aa", "ab"));
        System.out.println(rn.canConstruct("aa", "aab"));
        System.out.println(rn.canConstruct("", "aab"));

        System.out.println(rn.canConstruct2("a", "b"));
        System.out.println(rn.canConstruct2("abc", "c"));
        System.out.println(rn.canConstruct2("aa", "ab"));
        System.out.println(rn.canConstruct2("aa", "aab"));
        System.out.println(rn.canConstruct2("", "aab"));
    }
}
