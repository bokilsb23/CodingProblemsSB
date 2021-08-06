package com.sb.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortSquaredArrays {

    public static void main(String[] args) {
        SortSquaredArrays a = new SortSquaredArrays();
        a.sortSquaredArray(Arrays.asList(1,2,3,4,5,15)).stream().forEach(t -> System.out.print(t+" "));
        a.sortSquaredArray(Arrays.asList(-15,-12,-11,-5,-1)).stream().forEach(t -> System.out.print(t+" "));
    }

    public List<Integer> sortSquaredArray(List<Integer> A) {
        List<Integer> results1 = new ArrayList<>(A.size());
        List<Integer> results2 = new ArrayList<>(A.size());
        for(int i=0; i<A.size();i++) {
            if(A.get(i) < 0) {
                results2.add(Double.valueOf(Math.pow(A.get(i),2)).intValue());
            }
            else {
                results1.add(Double.valueOf(Math.pow(A.get(i),2)).intValue());
            }
        }
        return mergeArraysWithOppositeSortSequence(results1, results2);
    }


    private ArrayList<Integer> mergeArraysWithOppositeSortSequence(List<Integer> A, List<Integer> B) {
        int i = 0, j = B.size()-1, k = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i<A.size() && j >=0)
        {
            if (Math.pow(A.get(i),2) < Math.pow(B.get(j),2)){
                result.add(k++, A.get(i++));
            }
            else {
                result.add(k++, B.get(j--));
            }

        }

        while (i < A.size()){
            result.add(k++, A.get(i++));
        }

        while (j >=0) {
            result.add(k++, B.get(j--));
        }
        return result;
    }
}
