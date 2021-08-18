package com.sb.problems.maths;

import java.math.BigInteger;

public class NextSmallestPalindrome {

    public static void main(String[] args) {
        NextSmallestPalindrome obj = new NextSmallestPalindrome();
        /*System.out.println(obj.nextSmallestPalindrome("23589"));//23632
        System.out.println(obj.nextSmallestPalindrome("91999"));//92029
        System.out.println(obj.nextSmallestPalindrome("11111"));//11211
        System.out.println(obj.nextSmallestPalindrome("93524"));//93539
        System.out.println(obj.nextSmallestPalindrome("99999"));//100001
       System.out.println(obj.nextSmallestPalindrome("111111"));//112211


        System.out.println(obj.nextSmallestPalindrome("235899"));//236632
        System.out.println(obj.nextSmallestPalindrome("919999"));//920029
        System.out.println(obj.nextSmallestPalindrome("935243"));//935539
        System.out.println(obj.nextSmallestPalindrome("999999"));//1000001
        System.out.println(obj.nextSmallestPalindrome("9999999999"));//1000001
        System.out.println(obj.nextSmallestPalindrome("387427793198650286024"));//387427793202397724783
        System.out.println(obj.nextSmallestPalindrome("2168576189279543123341"));//2168576189339816758612*/
        System.out.println(obj.nextSmallestPalindrome("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));//2168576189339816758612



    }

    private String nextSmallestPalindrome(String str) {
        return nextSmallestPalindrome(str, false);
    }

    /**
     * Returns next smallest palindrome number from given number
     *
     * @param str - given number
     * @return - next smallest palindrome
     */
    private String nextSmallestPalindrome(String str, boolean isUpdated) {
        String A = str;
        boolean isLesser = true;
        int mid = A.length() / 2;
        for (int i = 0; i <= mid; i++) {

            if(i == mid && isUpdated) {
                return A;
            }
            int indexOfRightElement = A.length() - i - 1;
            long charA = Character.getNumericValue(A.charAt(i));
            long charB = Character.getNumericValue(A.charAt(indexOfRightElement));
            if (charA > charB) {
                isLesser = false;
                A = replaceCharAt(A, A.length() - i - 1, A.charAt(i));
            } else if (charA < charB) {
                if(indexOfRightElement == i+1 && charA+1 < charB) {
                    char charToReplace = String.valueOf(charA+1).charAt(0);
                    A = replaceCharAt(A, A.length() - i - 1, charToReplace);
                    return replaceCharAt(A, i, charToReplace);
                }
                isLesser = true;
                A = replaceCharAt(A, A.length() - i - 1, A.charAt(i));
            }

            if ((i == (A.length() - i - 1) || (i + 1) == ((A.length() - i - 1))) && isLesser) {
                if (charA != 9) {
                    if (A.length() % 2 != 0) {
                        char charToReplace = String.valueOf(charA + 1).charAt(0);
                        return replaceCharAt(A, A.length() - i - 1, charToReplace);
                    } else {
                        char charToReplace = charA != charB ? String.valueOf(charB).charAt(0) : String.valueOf(charA + 1).charAt(0);

                        A = replaceCharAt(A, A.length() - i - 1, charToReplace);
                        return replaceCharAt(A, i, charToReplace);
                    }
                } else {
                    String nextDegreeNumber = getNextDegreeNumber(str);
                    return isPalindrome(new BigInteger(nextDegreeNumber)) ? nextDegreeNumber : nextSmallestPalindrome(nextDegreeNumber, true);
                }
            }
        }
        return A;
    }

    /**
     * gets number of next degree if the current number contains 9s in the end
     *
     * @param str - current number
     * @return - next degree number
     */
    private String getNextDegreeNumber(String str) {
        String A = str;

        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == '9') {
                A = replaceCharAt(A, i, '0');
                if (i > 0 && A.charAt(i - 1) != '9') {
                    return replaceCharAt(A, i - 1, String.valueOf(Character.getNumericValue(A.charAt(i - 1) + 1)).charAt(0));
                }
            }
            /*else {
                return replaceCharAt(A, i, String.valueOf(Character.getNumericValue(A.charAt(i))+1).charAt(0));
            }*/
        }
        return String.valueOf(new BigInteger(str).add(BigInteger.ONE));
    }

    private String replaceCharAt(String str, int i, char c) {
        return str.substring(0, i) + c + str.substring(i + 1);
    }

    private boolean isPalindrome(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0) {
            return false;
        }
        BigInteger reversed = BigInteger.ZERO;
        BigInteger tempNum = number;

        while (tempNum.compareTo(BigInteger.ZERO) != 0) {
            BigInteger digit = tempNum.mod(BigInteger.TEN);

            reversed = (reversed.multiply(BigInteger.TEN)).add(digit);
            tempNum = tempNum.divide(BigInteger.TEN);
        }
        return reversed.compareTo(number) == 0;
    }
}
