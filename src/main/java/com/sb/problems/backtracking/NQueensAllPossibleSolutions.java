package com.sb.problems.backtracking;

import java.util.ArrayList;

public class NQueensAllPossibleSolutions {

    public static void main(String[] args) {
        NQueensAllPossibleSolutions nq = new NQueensAllPossibleSolutions();
        System.out.println(nq.nQueens(2));
    }

    private ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
    private boolean[] cols, leftDiag, rightDiag;



    private  ArrayList<ArrayList<String>> nQueens(int a) {
        cols = new boolean[a];
        leftDiag = new boolean[a*2];
        rightDiag = new boolean[a*2];
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<a;i++)temp.add(0);
        solve(combinations,temp, a, 0);

        return convertResults(combinations, a);
    }

    private ArrayList<ArrayList<String>> convertResults(ArrayList<ArrayList<Integer>> combinations, int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(ArrayList<Integer> inner : combinations) {
            ArrayList<String> currRes = new ArrayList<>();
            for(int innerEle : inner) {
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<n;k++) {
                    if(k==innerEle-1) {
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                currRes.add(sb.toString());
            }
            result.add(currRes);
        }
        return result;
    }

    private void solve(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currSoln, int n, int row) {
        if(row == n) {
            result.add(new ArrayList<>(currSoln));
            return;
        }

        for(int i=0; i<n;i++) {
            if(cols[i] || leftDiag[i+row] || rightDiag[row - i + n]) {
                continue;
            }
            cols[i] = leftDiag[i+row] = rightDiag[row - i + n] = true;
            currSoln.set(i, row+1);
            solve(result, currSoln, n, row+1);
            cols[i] = leftDiag[row+i] = rightDiag[row-i+n] = false;
        }
    }
}
