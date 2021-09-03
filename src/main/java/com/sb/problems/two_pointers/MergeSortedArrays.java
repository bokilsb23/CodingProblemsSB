package com.sb.problems.two_pointers;

import java.util.ArrayList;

public class MergeSortedArrays {



    public ArrayList<Integer> mergeSortedArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size() == 0) {
            return b;
        }
        if(b.size() == 0){
            return a;
        }
        ArrayList<Integer> tempArray = new ArrayList<>();
        int start = 0;
        int mid = a.size();
        a.addAll(b);
        int i = start;
        int j = mid;
        int index = 0;
        while(i < mid && j <a.size()) {
            if(a.get(i) < a.get(j)) {
                tempArray.add(index, a.get(i));
                i++;
            } else {
                tempArray.add(index, a.get(j));
                j++;
            }
            index++;
        }

        if(i >= mid) {
            while (j < a.size()) {
                tempArray.add(index, a.get(j));
                j++;
                index++;
            }
        }
        else if(j >= a.size()){
            while(i<mid) {
                tempArray.add(index, a.get(i));
                i++;
                index++;
            }
        }
        a.clear();
        return tempArray;
    }
}
