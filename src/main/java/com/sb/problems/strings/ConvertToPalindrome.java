package com.sb.problems.strings;

public class ConvertToPalindrome {

    public static void main(String[] args) {
        ConvertToPalindrome obj = new ConvertToPalindrome();
        //System.out.println(obj.solve("epyyevdadveyype"));
        System.out.println(obj.solve("abca"));
    }


    private int solve(String A) {
        int i = 0, j = A.length()-1;
        while(i<j) {
            if(A.charAt(i) == A.charAt(j)) {
                i++; j--;
            }
            else {
                if(isPalindrome(A, i)) {
                    return 1;
                }
                if(isPalindrome(A,j)) {
                    return 1;
                }
                return 0;
            }
        }
        //if we reach here, it means original string was already a palindrome. This means if the string has odd number of characters,
        //we can remove the mid element and it will still be a palindrome, but if it has even number of chars, it won't remain a palindrome
        //by removing a character from it
        if(A.length() %2 != 0) {
            return 1;
        }
        return 0;
    }


    private boolean isPalindrome(String A, int index) {
        int i = 0, j = A.length()-1;

        while(i<j) {
            //eliminate mismatched character from palindrome calculation by incrementing/decrementing the corresponding index
            if(i == index) {
                i++;
            }
            if(j == index) {
                j--;
            }
            if(A.charAt(i) != A.charAt(j)) {
                return false;
            }
            else {
                i++; j--;
            }
        }
        return true;
    }

    /////////////INEFFICIENT SOLUTION////////////////////
    private int convertToPalindrome(String A) {
        for(int i=0; i<A.length(); i++) {
            if(isPalindrome(removeCharAt(A, i))) {
                return 1;
            }
        }
        return 0;
    }


    private boolean isPalindrome(String A) {
        for(int i = 0; i < A.length()/2; i++) {
            if(A.charAt(i) != A.charAt(A.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    private String removeCharAt(String A, int index) {
        return A.substring(0, index) + A.substring(index+1);
    }
}
