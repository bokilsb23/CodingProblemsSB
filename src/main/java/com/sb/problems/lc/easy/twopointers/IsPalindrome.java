package com.sb.problems.lc.easy.twopointers;



/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alpha

numeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.



Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.

 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {

            //Skip current pointers till we get alphanumeric value
            while (isNonAlphaNumeric(s.charAt(i))) {
                i++;
            }
            while (isNonAlphaNumeric(s.charAt(j))) {
                j--;
            }
            //If current pointers do not match, string isn't palindrome
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isNonAlphaNumeric(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c);
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome("race a car"));
        System.out.println(isPalindrome.isPalindrome(" "));
    }

}
