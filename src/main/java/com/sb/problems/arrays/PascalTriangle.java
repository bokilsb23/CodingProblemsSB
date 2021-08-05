package com.sb.problems.arrays;

import java.util.ArrayList;


public class PascalTriangle {

    /**
     * Returns Kth row in Pascal triangle in O(n) complexity.
     * Any element in Pascal's triangle is nCr
     * (combination formula where n is row number and r is element number in row)
     * @param A - row number in the Pascal Triangle (starting from 0)
     * @return - kth row from the triangle
     */
    private ArrayList<Integer> getKthRowInPascalTriangleOn(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<=A; i++) {
            result.add(i,null);
        }
        result.set(0,1);
        result.set(A,1);
        int num = 1;
        for(int i=1; i<=A/2; i++) {
            num=(num*(A-i+1))/i; // num*(A-(i-1))/i
            result.set(i, num);
            result.set(A-i, num);
        }

        return result;
    }


    /**
     * Prints Pascal Triangle till row A
     * @param A - Last Row's number
     * @return - list of list containing Pascal's triangle till row A
     */
    private ArrayList<ArrayList<Integer>> getPascalTriangle(int A) {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        for(int i=0; i< A; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || i == j) {
                    innerList.add(j, 1);
                } else {
                    int resultNumber = outerList.get(i-1).get(j) + outerList.get(i-1).get(j-1);
                    innerList.add(j, resultNumber);
                }
            }
            outerList.add(i, innerList);
        }
        return outerList;
    }



    /**
     * Returns Kth row in Pascal triangle
     * @param k - row number in the Pascal Triangle (starting from 0)
     * @return - kth row from the triangle
     */
    @Deprecated
    private ArrayList<Integer> getKthRowInPascalTriangle(int k) {
        ArrayList<Integer> prevList = new ArrayList<>();
        for(int i=0; i<=k; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || i == j) {
                    innerList.add(j, 1);
                } else {
                    int resultNumber = prevList.get(j) + prevList.get(j-1);
                    innerList.add(j, resultNumber);
                }
            }
            prevList = innerList;
        }
        return prevList;
    }

    /**
     * Recursive method to get [k,i]th element in a Pascal Triangle where i <= k
     * @param k - row number in Pascal Triangle (starting from 0)
     * @param i - column number in Pascal Triangle (starting from 0)
     * @return - element on index [k,i] of the triangle
     */
    private int getKIthElementOfPascalTriangle(int k, int i) {
        if(i > k) {
            throw new IllegalArgumentException(
                    String.format("value of column index %d cannot be greater than value of row index %d in Pascal's Triangle", i, k));
        }
        if(i == k || i == 0) {
            return 1;
        }
        else if(i == 1 || i == k-1) {
            return k;
        }
        else {
            return getKIthElementOfPascalTriangle(k-1, i) + getKIthElementOfPascalTriangle(k-1, i-1);
        }
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();

        //System.out.println(pt.getKthRowInPascalTriangle(20));

        System.out.println(pt.getKthRowInPascalTriangleOn(3));

        System.out.println(pt.getKIthElementOfPascalTriangle(8, 9));
    }
}
