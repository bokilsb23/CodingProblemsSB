package com.sb.problems.lc.easy.strings;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.



Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.


 */
public class FirstOccurrenceOfString {
    public int getFirstOccurrence(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            //slide the inner window till we exhaust the length of needle/or we find non matching character
            while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {//This means the last window matched needle, it's start index would be i
                return i;
            } else {//increase the start of the window by 1, reset pointer for traversing inside the window.
                i++;
                j = 0;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FirstOccurrenceOfString foc = new FirstOccurrenceOfString();

        System.out.println(foc.getFirstOccurrence("hello", "ell"));
        System.out.println(foc.getFirstOccurrence("sadbutsad", "sad"));
        System.out.println(foc.getFirstOccurrence("leetcode", "leeto"));
        System.out.println(foc.getFirstOccurrence("aaaba", "aab"));
    }
}
