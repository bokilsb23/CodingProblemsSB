package com.sb.problems.lc.easy.strings;

import java.util.Arrays;

/*
* Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.



Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


* */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder output = new StringBuilder();

        for (int j = 0; j < strs[0].length(); j++) {
            char currentChar = strs[0].charAt(j);
            boolean currCharExists = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i] == null || strs[i].length() <= j || currentChar != strs[i].charAt(j)) {
                    currCharExists = false;
                    break;
                }
            }
            if (currCharExists) {
                output.append(currentChar);
            } else {
                break;
            }
        }
        return output.toString();
    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        /*
        * The reason why we sort the input array of strings and compare the first and last strings
        * is that the longest common prefix of all the strings must be a prefix of the first string
        * and a prefix of the last string in the sorted array. This is because strings are ordered
        * based on their alphabetical order (Lexicographical order).
        * For example, consider the input array of strings {"flower", "flow", "flight"}.
        * After sorting the array, we get {"flight", "flow", "flower"}. The longest common prefix of all the strings is "fl",
        * which is located at the beginning of the first string "flight" and the second string "flow".
        * Therefore, by comparing the first and last strings of the sorted array,
        * we can easily find the longest common prefix.
        * */
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];
        int i = 0;
        StringBuilder commonPrefix = new StringBuilder();
        while (i < firstStr.length() && i < lastStr.length()) {
            if (firstStr.charAt(i) == lastStr.charAt(i)) {
                commonPrefix.append(firstStr.charAt(i));
                i++;
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(lcp.longestCommonPrefix2(strs));
        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(lcp.longestCommonPrefix2(strs));
        strs = null;
        System.out.println(lcp.longestCommonPrefix2(strs));
        strs = new String[]{};
        System.out.println(lcp.longestCommonPrefix2(strs));
        strs = new String[]{" awv", " a", " as"};
        System.out.println(lcp.longestCommonPrefix(strs));
        strs = new String[]{"car", "cartoon", "rubbish"};
        System.out.println(lcp.longestCommonPrefix2(strs));
        strs = new String[]{"car", "cartoon", "cart"};
        System.out.println(lcp.longestCommonPrefix2(strs));
    }
}
