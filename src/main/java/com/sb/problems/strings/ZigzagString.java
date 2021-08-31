package com.sb.problems.strings;

import java.util.Arrays;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P.......A........H.......N
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 * And then read line by line: PAHNAPLSIIGYIR
 */

public class ZigzagString {
    public static void main(String[] args) {
        ZigzagString obj = new ZigzagString();

        System.out.println(obj.convert("PAYPALISHIRING", 3));

        System.out.println(obj.convert("PAYPALISHIRING", 4));


        System.out.println(obj.convert("ABCD", 2));
    }


    /**
     * Convert to zigzag string with B number of rows
     * @param A - Original String
     * @param B - number of rows
     * @return - converted string
     */
    private String convert(String A, int B) {
        if(B == 1 || B >= A.length()) {
            return A;
        }
        String res[] = new String[A.length()];
        Arrays.fill(res, "");
        int j = 0;
        boolean down = true;

        for(int i = 0; i < A.length(); i++) {

            res[j] += A.charAt(i);
            if(j==B-1) {
                down = false;
            }
            else if(j == 0) {
                down = true;
            }
            if(down) {
                j++;
            } else {
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : res) {
            sb.append(s);
        }
        return sb.toString();
    }
}
