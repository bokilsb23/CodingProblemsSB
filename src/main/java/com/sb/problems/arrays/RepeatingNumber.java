package com.sb.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatingNumber {


    //If List is not final
    private int repeatedNumber(List<Integer> A) {

         for(int i=0; i<A.size(); i++) {
             if(A.get(Math.abs(A.get(i))) >=0) {
                 A.set(Math.abs(A.get(i)), -A.get(Math.abs(A.get(i))));
             }
             else {
                 return Math.abs(A.get(Math.abs(A.get(i))));
             }
         }
         return -1;
    }

    //If List is final
    private int repeatedNumberFinalList(final List<Integer> A) {
        Set<Integer> tempSet = new HashSet<>(A.size()-1);
        for(int i=0; i<A.size(); i++) {
            if(tempSet.contains(A.get(i))) {
                return A.get(i);
            }
            else {
                tempSet.add(A.get(i));
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        RepeatingNumber rn = new RepeatingNumber();
        System.out.println(rn.repeatedNumber(Arrays.asList(3,4,1,4,1)));
        System.out.println(rn.repeatedNumber(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,23,15,16,17,18,19,20,21,22,23)));
    }
}
