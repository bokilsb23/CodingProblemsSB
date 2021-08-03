package com.sb.utils;

import java.util.List;

public class BinarySearch {
    public static int binarySearch(final List<Integer> A, int B) {
        int max = A.size()-1;
        int min = 0;

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
}
