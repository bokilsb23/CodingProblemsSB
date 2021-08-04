package com.sb.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumContiguousSubArray {

    public int getMaxSumForContiguousSubArray(ArrayList<Integer> A) {
        int sumTillHere = 0;
        int currentMaxSum = Integer.MIN_VALUE;
        /*int currentStartPosition = 0;
        int currentPosition = 0;*/
        for(int i = 0; i <A.size(); i++) {
            sumTillHere += A.get(i);
            if(sumTillHere > currentMaxSum) {
                /*if(currentMaxSum < 0) {
                    currentStartPosition= i;
                }*/
                currentMaxSum = sumTillHere;
                //currentPosition=i;

            }
            if(sumTillHere < 0) {
                sumTillHere = 0;
                //currentStartPosition= currentPosition;
            }
        }
        return currentMaxSum;
    }

    public static void main(String[] args) {
        MaxSumContiguousSubArray obj = new MaxSumContiguousSubArray();
        System.out.println(obj.getMaxSumForContiguousSubArray(new ArrayList<>(Arrays.asList(-2,-3,4,-1,-2,1,5,-3))));
        System.out.println(obj.getMaxSumForContiguousSubArray(new ArrayList<>(Arrays.asList(-2,-3,-4,-1,-2,-1,-5,-3))));
        System.out.println(obj.getMaxSumForContiguousSubArray(new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10))));
        System.out.println(obj.getMaxSumForContiguousSubArray(new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4))));


    }
}
