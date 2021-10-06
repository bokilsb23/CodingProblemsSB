package com.sb.problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FirstRepeatingValue {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(10,5,3,4,3,5,6))));
        System.out.println(solve(new ArrayList<>(Arrays.asList(6, 10, 5, 4, 9, 120))));
        System.out.println(solve(new ArrayList<>(Arrays.asList(8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3))));
    }


    private static int solve(ArrayList<Integer> A) {
        int repeatingIdx=A.size();
        int repeatingVal=-1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<A.size();i++) {
            Integer ele = A.get(i);
            if(map.containsKey(ele)) {
                Integer prevIdx = map.get(ele);
                if(repeatingIdx > prevIdx) {
                    repeatingIdx = prevIdx;
                    repeatingVal = ele;
                }
            } else {
                map.put(ele, i);
            }
        }
        return repeatingVal;
    }
}
