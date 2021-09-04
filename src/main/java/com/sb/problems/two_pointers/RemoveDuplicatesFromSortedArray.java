package com.sb.problems.two_pointers;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;


/**
 * Given a sorted array A consisting of duplicate elements.
 *
 *  Your task is to remove all the duplicates and return a sorted array of distinct elements consisting of all distinct elements present in A.
 *
 * But, instead of returning an answer array, you have to rearrange the given array in-place such that it resembles what has been described above.
 * Hence, return a single integer, the index(1-based) till which the answer array would reside in the given array A.
 *
 * Note: This integer is the same as the number of integers remaining inside A had we removed all the duplicates.
 * Look at the example explanations for better understanding.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(solution(asList(1,1,2)));
        System.out.println(solution(asList(1,2,2,3,3)));
        System.out.println(solution(asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3)));
    }

    private static int solution(List<Integer> A){
        int n = A.size();
        int i = 0;
        if(n<=1)
            return n;
        for(int j=i+1;j<n;j++) {
            if(!A.get(i).equals(A.get(j))) {
                i++;
                Collections.swap(A, i, j);
            }
        }
        return i+1;
    }


}
