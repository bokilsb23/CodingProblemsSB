package com.sb.problems.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> anagrams = anagrams(Arrays.asList("cat", "dog", "god", "tac"));
        System.out.println(anagrams);
    }


    private static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i < A.size(); i++) {
            char[] strArr = A.get(i).toCharArray();
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);
            if(map.containsKey(sortedStr)) {
                ArrayList<Integer> integers = map.get(sortedStr);
                integers.add(i+1);
                map.put(sortedStr, integers);
            } else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i+1);
                map.put(sortedStr, integers);
            }
        }

        return new ArrayList<>(map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));

    }
}
