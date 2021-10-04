package com.sb.problems.backtracking;

import java.util.*;

/**
 * THIS IS INCOMPLETE SOLUTION
 */
public class CombinationSum2 {


    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        //ArrayList<Integer> tempList = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        getCombinations(results, A, B, 0, new ArrayList<>());
        return results;
    }

    private static void getCombinations(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> a, int sum, int index, ArrayList<Integer> tempList) {
        if(sum == 0){
            results.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index; i < a.size(); i++) {
            int diff = sum - a.get(i);
            if(diff >= 0/* && !tempList.contains(a.get(i))*/) {
                tempList.add(a.get(i));
                getCombinations(results, a, diff, i, tempList);
                tempList.remove(a.get(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(2,3,6,7)), 7));
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5)), 8));
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)), 28));
    }

}
