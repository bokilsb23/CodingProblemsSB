package com.sb.problems.bit_manipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinXorValue {
    public static void main(String[] args) {
        MinXorValue obj = new MinXorValue();
        System.out.println(obj.getMinXorValue(Arrays.asList(9,5,3)));
    }

    private int getMinXorValue(List<Integer> A) {
        Collections.sort(A);
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            int currXor = (A.get(i) ^ A.get(i + 1));
            if (currXor < minXor) {
                minXor = currXor;
            }
        }
        return minXor;
    }
}
