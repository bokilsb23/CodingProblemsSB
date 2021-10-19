package com.sb.problems.hashing;

public class SlidingWindowSubstring {
    static String minimumWindow(String A, String B) {
        int mapArray[] = new int[256];

        int windowLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int count = 0;
        for (char c : B.toCharArray()) {
            if (mapArray[c] == 0)
                count++;
            mapArray[c]++;
        }

        int i = 0;
        int j = 0;

        while (j < A.length()) {
            mapArray[A.charAt(j)]--;
            if (mapArray[A.charAt(j)] == 0)
                count--;

            if (count == 0) {
                while (count == 0) {

                    if (windowLength > j - i + 1) {
                        windowLength = Math.min(windowLength, j - i + 1);
                        windowStart = i;
                    }

                    mapArray[A.charAt(i)]++;
                    if (mapArray[A.charAt(i)] > 0) {
                        count++;
                    }
                    i++;
                }
            }
            j++;
        }

        if (windowLength != Integer.MAX_VALUE) {
            return String.valueOf(A).substring(windowStart, windowLength + windowStart);
        }
        else {
            return "-1";
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.print(minimumWindow(s, t));

    }
}
