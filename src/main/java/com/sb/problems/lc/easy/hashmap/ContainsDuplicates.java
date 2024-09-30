package com.sb.problems.lc.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] arr, int k) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for ( int i = 0; i < arr.length; i++) {
            if(idxMap.containsKey(arr[i])) {
                if(Math.abs(idxMap.get(arr[i]) - i) <= k) {
                    return true;
                }
            }
            idxMap.put(arr[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates c = new ContainsDuplicates();
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(c.containsDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
