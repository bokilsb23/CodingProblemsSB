package com.sb.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutations {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println(p.permute(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))));
    }

    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        permute(results, A,0);
        return results;
    }

    private void permute(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> A, int i){
        if(i >= A.size()){
            result.add(new ArrayList<>(A));
            return;
        }
        for(int j = i; j < A.size(); j++){
            Collections.swap(A,j,i);
            permute(result, A, i+1);
            Collections.swap(A,j,i);
        }
    }

}
