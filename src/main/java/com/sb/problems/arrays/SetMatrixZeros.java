package com.sb.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 */
public class SetMatrixZeros {


    /**
     * This solution uses extra O(m+n) space in worst case scenario, with time complexity O(m*n)
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> setMatrixZeros(ArrayList<ArrayList<Integer>> A) {
        Set<Integer> rowMap = new HashSet<>();
        Set<Integer> colMap = new HashSet<>();
        for(int i=0; i< A.size(); i++) {
            for(int j=0;j<A.get(i).size();j++) {
                if(A.get(i).get(j) == 0) {
                    rowMap.add(i);
                    colMap.add(j);
                }
            }
        }

        for(int i=0; i< A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if(rowMap.contains(i) || colMap.contains(j)) {
                    A.get(i).set(j, 0);
                }
            }
        }
        return A;
    }

    /**
     * This solution doesn't use additional space, but is not efficient with time complexity
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> setMatrixZerosWithNoAdditionalSpace(ArrayList<ArrayList<Integer>> A) {
        for(int i=0; i< A.size(); i++) {
            for(int j=0;j<A.get(i).size();j++) {
                if(A.get(i).get(j) == 0) {
                    setAllWithMarker(i,j,A);
                }
            }
        }

        for(int i=0; i< A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if(A.get(i).get(j) == -1) {
                    A.get(i).set(j, 0);
                }
            }
        }
        return A;
    }

    private void setAllWithMarker(int i, int j, ArrayList<ArrayList<Integer>> A) {
        A.set(i,new ArrayList(A.get(i).stream().map(val -> val !=0 ?  -1 : 0).collect(Collectors.toList())));
        A.forEach(lst -> {
            if(lst.get(j) != 0) {
                lst.set(j, -1);
            }
        });
    }


    public static void main(String[] args) {
        SetMatrixZeros obj = new SetMatrixZeros();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,1,1,0)),
                new ArrayList<>(Arrays.asList(1,1,1,1)),
                new ArrayList<>(Arrays.asList(1,1,0,1)),
                new ArrayList<>(Arrays.asList(0,1,1,1))

        ));

        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,0,1)),
                new ArrayList<>(Arrays.asList(1,1,1)),
                new ArrayList<>(Arrays.asList(1,1,1))

        ));

        ArrayList<ArrayList<Integer>> arr3 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,0,1)),
                new ArrayList<>(Arrays.asList(1,1,1)),
                new ArrayList<>(Arrays.asList(1,0,1))

        ));

        ArrayList<ArrayList<Integer>> arrayLists = obj.setMatrixZeros(arr);
        System.out.println(arrayLists);

        ArrayList<ArrayList<Integer>> arrayLists2 = obj.setMatrixZeros(arr2);
        System.out.println(arrayLists2);

        ArrayList<ArrayList<Integer>> arrayLists3 = obj.setMatrixZeros(arr3);
        System.out.println(arrayLists3);
    }
}
