package com.sb.problems.lc.medium.maths;


/*
* You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.



Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation:
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8

Example 2:

Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]



Constraints:

    1 <= arr.length, queries.length <= 3 * 104
    1 <= arr[i] <= 109
    queries[i].length == 2
    0 <= lefti <= rig

    ti < arr.length

Accepted
192.6K
Submissions
244.1K
Acceptance Rate
78.9%

* */
public class XorQueriesOfSubarray {


    public static void main(String[] args) {
        XorQueriesOfSubarray xor = new XorQueriesOfSubarray();

        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{0,3}, new int[]{3,3}};
        xor.calculateXor(queries, arr);

        arr = new int[]{4,8,2,10};
        queries = new int [][]{new int[]{2,3},new int[]{1,3},new int[]{0,0},new int[]{0,3}};
        xor.calculateXor(queries, arr);
        //xor.xor(2, 10);
    }

    private int[] calculateXor(int[][] queries, int[] arr) {
        int[] xorRes = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if(queries[i][0] == queries[i][1]){
                xorRes[i] = arr[queries[i][1]];
            } else{
                xorRes[i] = xor(arr[queries[i][0]], arr[queries[i][0] + 1]);//0,1
                for(int j = queries[i][0] + 2; j <= queries[i][1]; j++){//1
                    xorRes[i] = xor(xorRes[i], arr[j]);
                }
                //xorRes[i] = xor.xor(arr[queries[i][0]], arr[queries[i][1]]);
            }

            System.out.println(xorRes[i]);
        }
        return xorRes;
    }

    public int xor(int a, int b) {
        String xa = convertToBinary(a);
        String xb = convertToBinary(b);
        int maxLength = Math.max(xa.length(), xb.length());
        if(xa.length() < maxLength) {
            StringBuilder xasb = new StringBuilder(xa).reverse();
            for(int i = 1; i <= maxLength - xa.length(); i++) {
                xasb.append(0);
            }
            xa = xasb.reverse().toString();
        }

        if(xb.length() < maxLength) {
            StringBuilder xbsb = new StringBuilder(xb).reverse();
            for(int i = 0; i < maxLength - xb.length(); i++) {
                xbsb.append(0);
            }
            xb = xbsb.reverse().toString();
        }




        StringBuilder binaryXorSb = new StringBuilder();
        for (int i=1; i <= maxLength; i++) {
            if (xa.length() - i >= 0 && xb.length() - i >= 0) {
                binaryXorSb = new StringBuilder(bitXor(Character.getNumericValue(xa.charAt(xa.length() - i)), Character.getNumericValue(xb.charAt(xb.length() - i)))+"")
                        .append(binaryXorSb);
            }
            /*if(xa.length() - i < 0) {
                binaryXorSb = new StringBuilder(xb.charAt(xb.length() - i)).append(binaryXorSb);
            } else if(xb.length() - i < 0) {
                binaryXorSb = new StringBuilder(xa.charAt(xa.length() - i)).append(binaryXorSb);
            }*/
        }
        int binaryXor = Integer.parseInt(binaryXorSb.toString());
        return convertToDecimal(binaryXor, 2);
    }

    private int bitXor(int a, int b) {
        if(a > 1 || b > 1) {
            throw new IllegalArgumentException("Invalid arg. Should be binary 0 or 1");
        }
        if (a == b) return 0;
        return 1;
    }


    private String convertToBinary(int A) {
        if(A == 0) {
            return String.valueOf(A);
        }
        int divResult = A;
        StringBuilder result = new StringBuilder();
        while(divResult >= 1) {
            result = new StringBuilder(Long.toString(divResult % 2)).append(result);
            divResult /= 2;
        }
        return result.toString();
    }

    private int convertToDecimal(int number, int base) {
        String numString = String.valueOf(number);
        int decValue = 0;
        for(int i=0; i <numString.length(); i++) {
            decValue += Long.parseLong(String.valueOf(numString.charAt(numString.length() - i - 1))) * Math.round(Math.pow(base, i));
        }
        return decValue;
    }
}
