package com.sb.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingInteger {

    public static void main(String[] args) {
        FirstMissingInteger fmi = new FirstMissingInteger();
        System.out.println(fmi.firstMissing(new ArrayList<>(Arrays.asList(1,4,2,6,3,9,7))));
        System.out.println(fmi.firstMissingSecondApproach(new ArrayList<>(Arrays.asList(1,4,2,6,3,9,7))));
    }

    private int firstMissing(ArrayList<Integer> A) {
        Set<Integer> existingElements = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                existingElements.add(a);
            }
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!existingElements.contains(i)) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    private int firstMissingSecondApproach(ArrayList<Integer> A) {

        //Step 1: Eliminate all the non positive values by marking them as int max
        for(int i=0;i<A.size();i++) {
            if(A.get(i) <= 0 ) {
                A.set(i, Integer.MAX_VALUE);
            }

        }

        for(int i=0; i< A.size(); i++) {
            int k = Math.abs(A.get(i));//necessary to eliminate IndexOutOfBounds for elements negated in current loop
            if(k <= A.size() && A.get(k-1) > 0) {
                A.set(k-1, -A.get(k-1));//If an element is found, set the value on it's index to negative
            }
        }

        //return index of the first positive element
        for(int i=0; i< A.size(); i++) {
            if(A.get(i) > 0) {
                return i+1;
            }
        }
        return 0;
    }
}
