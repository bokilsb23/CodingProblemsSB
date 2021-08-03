package com.sb.problems.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeCutterAltApproach {
    public static void main(String[] args) {
        TreeCutterAltApproach soln = new TreeCutterAltApproach();

        System.out.println(soln.solve(new ArrayList<>(Arrays.asList(117, 84, 50, 119, 74, 128)), 58));
    }


    public int solve(ArrayList<Integer> trees, int woodRequired) {
        Collections.sort(trees);
        int tallestTreeHeight = trees.get(trees.size()-1);
        int totalWood = sumOfElementsTillIndex(trees, trees.size());
        if(totalWood < woodRequired) {
            return 0;
        }
        int totalWoodToSave = totalWood - woodRequired;
        int maxHeight=0;
        for(int height=1; height <= tallestTreeHeight; height++) {
            if(height == 102) {
                System.out.println();
            }
            int woodSavedCount;
            int numberOfTreesLessThanHeight = numberOfLessThanOrEqualElements(trees, height);
            int numTreesGtEqCount = trees.size() - numberOfTreesLessThanHeight;
            int sumOfTreesLtCount = sumOfElementsTillIndex(trees,numberOfTreesLessThanHeight);
            woodSavedCount = (height * numTreesGtEqCount) + sumOfTreesLtCount;
            if(woodSavedCount == totalWoodToSave) {
                maxHeight =  height;
            }
        }

        return maxHeight;
    }



    private int numberOfLessThanOrEqualElements(final List<Integer> A, int B) {
        int indexOfNumber = getIndexOfNumber(A, B);
        if(indexOfNumber == A.size()) {
            return indexOfNumber;
        }
        int count = indexOfNumber;
        if(indexOfNumber+1 <= A.size()) {
            for(int i = indexOfNumber; i < A.size(); i++) {
                if(A.get(i) <= B) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getIndexOfNumber(final List<Integer> A, int B) {
        int min = 0;
        int max = A.size()-1;
        if(A.get(max) < B) {
            return A.size();
        }
        if(A.get(min) > B) {
            return 0;
        }
        while(min<=max) {
            int mid = min + (max-min)/2;
            if(A.get(mid) < B) {
                if(mid+1 < max) {
                    if(A.get(mid+1) > B) {
                        return mid+1;
                    }
                }
                min = mid+1;
            }
            else if(A.get(mid) > B) {
                if(mid > 0 && A.get(mid-1) < B) {
                    return mid;
                }
                max = mid-1;
            }
            else {
                return mid+1;
            }
        }
        return 0;
    }

    private int sumOfElementsTillIndex(List<Integer> list, int index) {
        int total = 0;
        for(int i = 0; i < index; i++) {
            total += list.get(i);
        }
        return total;
    }
}
