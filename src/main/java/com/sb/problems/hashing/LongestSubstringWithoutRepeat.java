package com.sb.problems.hashing;

public class LongestSubstringWithoutRepeat {

    private static int lengthOfLongestSubstring(String A) {
        if(A.length() <= 1) {
            return A.length();
        }

        String result = "";
        int maxStrLength = -1;

        for(Character c  : A.toCharArray()) {
            String currStr = String.valueOf(c);

            if(result.contains(currStr)) {
                result = result.substring(result.indexOf(currStr) + 1);
            }
            result = result.concat(currStr);
            maxStrLength = Math.max(maxStrLength, result.length());
        }
        return maxStrLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbbdefgh"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("a"));
    }
}
