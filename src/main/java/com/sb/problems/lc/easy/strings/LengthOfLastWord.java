package com.sb.problems.lc.easy.strings;

public class LengthOfLastWord {
    /*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.



Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
     */
    public int lastWordLength1(String s) {
        if(s == null) {
            return 0;
        }
        s = s.trim();
        if(s.isEmpty()) {
            return 0;
        }
        int lastSpace = s.lastIndexOf(' ');
        return s.length() - lastSpace - 1;
    }


    public int lastWordLength2(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        boolean nonSpaceOccured = false;
        int wordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            //Skip trailing spaces
            if(s.charAt(i) != ' ' || nonSpaceOccured) {
                nonSpaceOccured = true;
                if(s.charAt(i) != ' ') {
                    wordLength++;
                } else {
                    break;
                }
            }
        }
        return wordLength;
    }

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lastWordLength1(" "));
        System.out.println(l.lastWordLength2(" "));
        System.out.println("========================");
        System.out.println(l.lastWordLength1("Hello World"));
        System.out.println(l.lastWordLength2("Hello World"));
        System.out.println("========================");
        System.out.println(l.lastWordLength1("   fly me   to   the moon  "));
        System.out.println(l.lastWordLength2("   fly me   to   the moon  "));
        System.out.println("========================");
        System.out.println(l.lastWordLength1("luffy is still joyboy"));
        System.out.println(l.lastWordLength2("luffy is still joyboy"));
        System.out.println("========================");
        System.out.println(l.lastWordLength1(""));
        System.out.println(l.lastWordLength2(""));
        System.out.println("========================");
    }

}
