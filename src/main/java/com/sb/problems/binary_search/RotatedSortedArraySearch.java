package com.sb.problems.binary_search;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
        System.out.println(obj.searchInRotatedSorterArray(Arrays.asList(3,4,5,1,2), 1));
        System.out.println(obj.searchInRotatedSorterArray(Arrays.asList(4,5,6,7,7,0,1,2,3), 7));
        System.out.println(obj.searchInRotatedSorterArray(Arrays.asList(5,17,100,3), 6));
    }


    /**
     * Search the element in the two sub-arrays divided on the pivot
     * @param A - rotated List
     * @param B - element to search
     * @return - index of element
     */
    private int searchInRotatedSorterArray(List<Integer> A, int B) {
        int pivot = searchPivotInList(A, 0, A.size() - 1);
        int first = binarySearch(A, 0, pivot, B);
        int second = binarySearch(A, pivot+1, A.size()-1, B);
        return first != -1 ? first : second;

    }


    /**
     * Simple binary search
     * @param A - List
     * @param min - start index of search
     * @param max - end index of search
     * @param item - item to find
     * @return - index of item
     */
    private int binarySearch(List<Integer> A, int min, int max, int item) {
        while(min <= max) {
            int mid = min + (max-min)/2;
            if(A.get(mid) == item) {
                return mid;
            }
            else if(A.get(mid) > item) {
                max = mid-1;
            }
            else if(A.get(mid) < item) {
                min = mid+1;
            }
        }
        return -1;
    }


    /**
     * Search the index where the array is rotating, i.e. where next number is lesser than current number
     * @param A -  rotated list
     * @param min - start index of the search
     * @param max - end index of the search
     * @return - pivot/rotation point
     */
    private int searchPivotInList(List<Integer> A, int min, int max) {
        if (max < min) {
            return -1;
        }
        if (max == min) {
            return max;
        }
        int mid = min + (max - min) / 2;

        if (mid < max && A.get(mid) > A.get(mid + 1)) {
            return mid;
        }
        if(mid > min && A.get(mid) < A.get(mid-1)) {
            return mid-1;
        }

        if(A.get(min) >= A.get(mid)) {
            return searchPivotInList(A, min, mid);
        }
        return searchPivotInList(A, mid, max);
    }
}
