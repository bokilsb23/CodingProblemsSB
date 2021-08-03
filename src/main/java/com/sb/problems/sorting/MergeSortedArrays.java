package com.sb.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays a = new MergeSortedArrays();
        /*ArrayList<Integer> integers = a.mergeSortedArrays(new ArrayList<>(Arrays.asList(1, 3, 5, 6, 18, 21)), new ArrayList<>(Arrays.asList(4, 8, 9, 15)));
        integers.forEach(System.out::println);*/

        System.out.println(a.getMedian(new ArrayList<>(Arrays.asList(1, 3, 5, 10, 18, 21)), new ArrayList<>(Arrays.asList(4, 8, 9, 15))));
    }

    //1,3,4,5,6,8,9,15,18,21,25

    public double getMedian(ArrayList<Integer> A, ArrayList<Integer> B) {
        int totalSize = (A.size()+B.size());
        int mid = (totalSize/2)+1;
        int index = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        double result = 0;
        if(A.size() == 0) {
            return getMedian(B, B.size(), (B.size()/2)+1);
        } else if(B.size() == 0) {
            return getMedian(A, A.size(), (A.size()/2)+1);
        }

        int i=0 , j = 0;

        while(i < A.size() && j < B.size()) {
            if(A.get(i) < B.get(j)) {
                tempList.add(index, A.get(i));
                i++;
            } else {
                tempList.add(index, B.get(j));
                j++;
            }
            if(index == mid) {
                return getMedian(tempList, totalSize, index);
            }
            index++;
        }

        if(i >= A.size()) {
            int medianInd = mid - index + j - 1;
            if(medianInd < B.size() && medianInd >= 0) {
                result = B.get(mid-index+j);
            }
        }

        else {
            int medianInd = mid - index +i-1;
            if(medianInd < A.size() && medianInd >= 0) {
                result = A.get(mid-index+i);
            }
        }
        return result;
    }

    public double getMedian(ArrayList<Integer> list, int totalSize, int index){
        if(totalSize == 0) {
            return 0.0;
        }
        if(totalSize%2 == 0) {
            return (list.get(index-1)+list.get(index-2))/2.0;

        }
        else {
            return list.get(index-1);
        }
    }


    public ArrayList<Integer> mergeSortedArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() == 0) {
            return B;
        }
        if(B.size() == 0){
            return A;
        }
        ArrayList<Integer> tempArray = new ArrayList<>();
        int start = 0;
        int mid = A.size();
        A.addAll(B);
        int i = start;
        int j = mid;
        int index = 0;
        while(i < mid && j <A.size()) {
            if(A.get(i) < A.get(j)) {
                tempArray.add(index, A.get(i));
                i++;
            } else {
                tempArray.add(index, A.get(j));
                j++;
            }
            index++;
        }

        if(i >= mid) {
            while (j < A.size()) {
                tempArray.add(index, A.get(j));
                j++;
                index++;
            }
        }
        else if(j >= A.size()){
            while(i<mid) {
                tempArray.add(index, A.get(i));
                i++;
                index++;
            }
        }
        return tempArray;
    }


}
