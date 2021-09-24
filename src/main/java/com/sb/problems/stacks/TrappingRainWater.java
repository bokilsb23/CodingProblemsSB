package com.sb.problems.stacks;

import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(calculateTrappedWater(Arrays.asList(3, 0, 2, 0, 4)));
        System.out.println(calculateTrappedWater(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
        System.out.println(calculateTrappedWater(Arrays.asList(1,2)));
    }

    private static int calculateTrappedWater(List<Integer> A) {
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];

        left[0] = A.get(0);
        for(int i =1; i < A.size(); i++) {
            left[i] = (Math.max(left[i-1], A.get(i)));
        }
        right[A.size()-1] = A.get(A.size()-1);
        for(int i = A.size()-2; i >=0; i--) {
            right[i] = Math.max(right[i+1], A.get(i));
        }

        int totalWaterTrapped = 0;
        for(int i = 0; i < A.size(); i++) {
            totalWaterTrapped += (Math.min(left[i], right[i]) - A.get(i));
        }
        return totalWaterTrapped;
    }
}
