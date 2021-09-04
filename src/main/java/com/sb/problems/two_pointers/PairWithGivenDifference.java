package com.sb.problems.two_pointers;

import java.util.*;

/**
 * For an unsorted array A, find if any pair of values have diff B
 */
public class PairWithGivenDifference {
    public static void main(String[] args) {
        PairWithGivenDifference obj = new PairWithGivenDifference();
        System.out.println(obj.pairWithGivenDiff(Arrays.asList(5,10,3,2,50,80), 78));
        System.out.println(obj.pairWithGivenDiff(Arrays.asList(-10,20), 30));

        System.out.println(obj.pairWithGivenDiff(Arrays.asList(5,10,3,2,50,82), 78));//2,3,5,10,50,80
        System.out.println(obj.pairWithGivenDiff(Arrays.asList(-10,21), 30));
        System.out.println(obj.pairWithGivenDiff(Arrays.asList(-259, -825, 459, 825, 221, 870, 626, 934, 205, 783, 850, 398), -42));

        System.out.println("~~");

        System.out.println(obj.hashMapSolution(Arrays.asList(5,10,3,2,50,80), 78));
        System.out.println(obj.hashMapSolution(Arrays.asList(-10,20), 30));

        System.out.println(obj.hashMapSolution(Arrays.asList(5,10,3,2,50,82), 78));//2,3,5,10,50,80
        System.out.println(obj.hashMapSolution(Arrays.asList(-10,21), 30));
        System.out.println(obj.hashMapSolution(Arrays.asList(-259, -825, 459, 825, 221, 870, 626, 934, 205, 783, 850, 398), -42));
        //-825,-259,205,221,398,459,626,783,825, 850, 870, 934
    }

    /**
     * This is not a 2-pointer solution, but has time complexity of O(n)
     * @param A - List of elements
     * @param B - difference to be found
     * @return - true if elements have diff B, else false
     */
    private boolean hashMapSolution(List<Integer> A, int B) {
        if(B == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : A) {
            set.add(B+i);
        }
        for(int a : A) {
            if(set.contains(a)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 2-pointer solution using sorting, has time complexity of O(nlogn)
     * @param A - List of elements
     * @param B - difference to be found
     * @return - true if elements have diff B, else false
     */
    private boolean pairWithGivenDiff(List<Integer> A, int B) {
        int reqDiff = Math.abs(B);
        Collections.sort(A);
        int i = 0;
        int j = 1;

        while(i < A.size() && j < A.size()) {
            int diff = A.get(j) - A.get(i);
            if(diff < reqDiff) {
                j++;
            } else if(diff > reqDiff) {
                if(i+1 == j){
                    j++;
                }
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
