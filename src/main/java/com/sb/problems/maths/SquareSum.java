package com.sb.problems.maths;

import java.util.ArrayList;

public class SquareSum {

    public ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int a = 0; a * a < A; a++) {
            for (int b = 0; b * b < A; b++) {
                if (a * a + b * b == A && a <= b) {
                    ArrayList<Integer> newEntry = new ArrayList<>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SquareSum obj = new SquareSum();
        System.out.println(obj.squareSum(2));
    }
}
