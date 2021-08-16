package com.sb.problems.maths;

public class PalindromeInteger {

    public static void main(String[] args) {
        PalindromeInteger pi = new PalindromeInteger();
        System.out.println(123/100);
        System.out.println(pi.isPalindrome(1234));
        System.out.println(pi.isPalindrome(12321));
        System.out.println(pi.isPalindrome(123321));
    }

    public boolean isPalindrome(int number) {
        if(number < 0) {
            return false;
        }
        int reversed = 0;
        int tempNum = number;

        while(tempNum != 0) {
            int digit = tempNum % 10;

            reversed = (reversed * 10) + digit;
            tempNum/=10;
        }
        return reversed == number;
    }
}