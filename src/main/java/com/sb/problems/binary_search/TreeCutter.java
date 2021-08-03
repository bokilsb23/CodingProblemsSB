package com.sb.problems.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeCutter {


    public static void main(String[] args) {
        TreeCutter cutter = new TreeCutter();
        System.out.println("Result1:"+ cutter.getMaxWoodCutterHeight(new ArrayList<>(Arrays.asList(117, 84, 50, 119, 74, 128)), 58));
        System.out.println("Result1:"+ cutter.getMaxWoodCutterHeight(new ArrayList<>(Arrays.asList(114, 55, 95, 131, 77, 111, 141)), 95));
        System.out.println("Result2:"+ cutter.getMaxWoodCutterHeight(new ArrayList<>(Arrays.asList(4,42,40,26,46)), 20));
        System.out.println("Result3:"+ cutter.getMaxWoodCutterHeight(new ArrayList<>(Arrays.asList(4,42,40,26,46)), 0));
        System.out.println("Result4:"+ cutter.getMaxWoodCutterHeight(new ArrayList<>(Arrays.asList(10,25,18,26,35,66,100)), 200));
    }

    public int getMaxWoodCutterHeight(ArrayList<Integer> trees, int woodRequired) {
        Collections.sort(trees);
        int tallestTreeHeight = trees.get(trees.size()-1);
        int maxHeight=0;
        for(int height=tallestTreeHeight-1; height >=1; height--) {
            int woodCut;
            int numberOfTreesLessThanHeight = numberOfLessThanOrEqualElements(trees, height);
            woodCut = getTotalCutWood(trees, numberOfTreesLessThanHeight,height);
            if(woodCut >= woodRequired) {
                return height;
            }
        }

        return maxHeight;
    }

    private int getTotalCutWood(ArrayList<Integer> trees, int lessThanHeight, int height) {
        int count = 0;
        for(int i = trees.size() -1 ; i >=lessThanHeight; i--) {
            count += (trees.get(i) - height);
        }
        return count;
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
}
