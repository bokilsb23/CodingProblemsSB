package com.sb.problems.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchBipedList {
    private static int solve(ArrayList<Integer> A, int B) {
        int min = 0;
        int max = A.size();

        int pivot = 0;
        boolean isWholeReverse = false;
        while (min <= max) {
            // 1,2,3,4,5,4,3,2,1
            int mid = min + (max-min)/2;
            if(A.get(mid) == B) {
                return mid;
            }
            if(mid+1 == A.size()) {
                if(A.get(mid) < A.get(mid-1)) {
                    isWholeReverse = true;
                }
                break;
            }
            if(mid-1 == 0) {
                if(A.get(mid-1) > A.get(mid)) {
                    isWholeReverse = true;
                }
                break;
            }
            if(A.get(mid) > A.get(mid+1) && A.get(mid) > A.get(mid-1)) {
                pivot = mid;
                break;
            }
            else if(A.get(mid) > A.get(mid+1) && A.get(mid) < A.get(mid-1)) {
                max = mid-1;
            }
            else if(A.get(mid) < A.get(mid+1) && A.get(mid) > A.get(mid-1)) {
                min = mid+1;
            }
        }

        int result;
        if(!isWholeReverse){
            result = binarySearch(A, B, 0, pivot);
            if(result != -1) {
                return result;
            }
        }

        result = reverseBinarySearch(A,B, pivot+1, A.size()-1);
        if(result != -1) {
            return result;
        }

        return result;
    }

    private static int binarySearch(final List<Integer> A, int B, int min, int max) {
        while(min<=max) {
            int mid = min + (max-min)/2;
            if(A.get(mid) < B) {
                min = mid+1;
            }
            else if(A.get(mid) > B) {
                max = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    private static int reverseBinarySearch(final List<Integer> A, int B, int min, int max) {
        while(min<=max) {
            int mid = min + (max-min)/2;
            if(A.get(mid) > B) {
                min = mid+1;
            }
            else if(A.get(mid) < B) {
                max = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList(Arrays.asList(1,3,4,6,5,2));
        ArrayList<Integer> list = new ArrayList(Arrays.asList(-1,3,4,6,8,9,-2));
        System.out.println(solve(list,-2));
    }
}
