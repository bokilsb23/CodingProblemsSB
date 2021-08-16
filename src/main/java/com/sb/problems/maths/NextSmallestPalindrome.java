package com.sb.problems.maths;

public class NextSmallestPalindrome {


    public static void main(String[] args) {
        NextSmallestPalindrome obj = new NextSmallestPalindrome();
        System.out.println(obj.nextSmallestPalindrome("23589"));//23632
        System.out.println(obj.nextSmallestPalindrome("91999"));//92029
        System.out.println(obj.nextSmallestPalindrome("11111"));//11211
        System.out.println(obj.nextSmallestPalindrome("93524"));//93539
        System.out.println(obj.nextSmallestPalindrome("99999"));//100001
       System.out.println(obj.nextSmallestPalindrome("111111"));//112211


        System.out.println(obj.nextSmallestPalindrome("235899"));//238832
        System.out.println(obj.nextSmallestPalindrome("919999"));//920029
        System.out.println(obj.nextSmallestPalindrome("935243"));//935539
        System.out.println(obj.nextSmallestPalindrome("999999"));//1000001


    }

    /**
     * Returns next smallest palindrome number from given number
     * @param str - given number
     * @return - next smallest palindrome
     */
    private String nextSmallestPalindrome(String str) {
        String A = str;
        boolean isLesser = true;
        for(int i = 0; i<= A.length()/2; i++) {
            int charA = Character.getNumericValue(A.charAt(i));
            int charB = Character.getNumericValue(A.charAt(A.length() - i - 1));
            if(charA > charB) {
                isLesser = false;
                A = replaceCharAt(A, A.length() - i - 1, A.charAt(i));
            }
            else if(charA < charB) {
                isLesser = true;
                A = replaceCharAt(A, A.length() - i - 1, A.charAt(i));
            }

            if((i == (A.length() - i - 1) || (i+1) == ((A.length() - i - 1))) && isLesser) {
                if(charA != 9) {
                    if(A.length()%2 != 0) {
                        char charToReplace = String.valueOf(charA + 1).charAt(0);
                        return replaceCharAt(A, A.length() - i - 1, charToReplace);
                    }
                    else {
                        char charToReplace = String.valueOf(charA + 1).charAt(0);
                        if(charA != charB) {
                            charToReplace = String.valueOf(charA > charB ? charA : charB).charAt(0);
                        }

                        A = replaceCharAt(A, A.length() - i - 1, charToReplace);
                        return replaceCharAt(A, i, charToReplace);
                    }
                }
                else {
                    return nextSmallestPalindrome(getNextDegreeNumber(str));
                }
            }
        }
        return A;
    }

    /**
     * gets number of next degree if the current number contains 9s in the end
     * @param str - current number
     * @return - next degree number
     */
    private String getNextDegreeNumber(String str) {
        String A = str;
        for(int i = A.length()-1; i >= 0; i--){
            if(A.charAt(i) == '9') {
                A = replaceCharAt(A, i, '0');
            }
            else {
                return replaceCharAt(A, i, String.valueOf(Character.getNumericValue(A.charAt(i))+1).charAt(0));
            }
        }
        return String.valueOf(Integer.valueOf(str) + 1);
    }

    private String replaceCharAt(String str, int i, char c) {
        return str.substring(0,i) + c + str.substring(i+1);
    }
}
