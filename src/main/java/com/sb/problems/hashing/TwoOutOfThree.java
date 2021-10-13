package com.sb.problems.hashing;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;

/**
 * Item present in exactly 2 arrays out of 3
 */
public class TwoOutOfThree {
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> resMap = new HashMap<>();

        map.put(1, new HashSet<>(A));
        map.put(2, new HashSet<>(B));
        map.put(3, new HashSet<>(C));

        map.forEach((key, value) -> value.forEach(u -> {
            if (resMap.containsKey(u)) {
                resMap.put(u, resMap.get(u) + 1);
            } else {
                resMap.put(u, 1);
            }
        }));

        return resMap.entrySet().stream()
                .filter(t -> t.getValue() == 2)
                .map(Map.Entry::getKey).sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(asList(1,1,2)), new ArrayList<>(asList(2,3)), new ArrayList<>(singleton(3))));
        //System.out.println(solve(new ArrayList<>(asList(1,2)), new ArrayList<>(asList(1,3)), new ArrayList<>(asList(2,3))));
        //System.out.println(solve(new ArrayList<>(asList(1,2)), new ArrayList<>(asList(1,3)), new ArrayList<>(Collections.emptyList())));
        //System.out.println(solve(new ArrayList<>(asList(1,2)), new ArrayList<>(Collections.emptyList()), new ArrayList<>(Collections.emptyList())));
        //System.out.println(solve(new ArrayList<>(Collections.emptyList()), new ArrayList<>(Collections.emptyList()), new ArrayList<>(Collections.emptyList())));
        System.out.println(solve(new ArrayList<>(asList(1,23,4,5,6,7,8,9,1,2,3,4,5,7,8,9)), new ArrayList<>(asList(1,23,4,5,6,7,8,9,1,2,3,4,5,7,8,9)), new ArrayList<>(asList(1,4))));

    }
}
