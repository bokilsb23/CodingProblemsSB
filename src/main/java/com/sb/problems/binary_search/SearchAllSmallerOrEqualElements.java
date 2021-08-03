package com.sb.problems.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SearchAllSmallerOrEqualElements {







    private static int getIndexOfNumber(final List<Integer> A, int B) {
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

    private static int numberOfLessThanOrEqualNumbers(final List<Integer> A, int B) {
        int indexOfNumber = getIndexOfNumber(A, B);
        if(indexOfNumber == A.size()) {
            return indexOfNumber;
        }
        int count = indexOfNumber;
        if(indexOfNumber+1 <= A.size()) {
            for(int i = indexOfNumber; i < A.size(); i++) {
                if(A.get(i) == B) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList(Arrays.asList(28,28,46,50,91,100));
        //System.out.println(numberOfLessThanOrEqualNumbers(A, 28));
        System.out.println(sumOfElementsTillIndex(A, numberOfLessThanOrEqualNumbers(A, 1000)));
        System.out.println(String.format("NumberOfElementsGtCount: %d", (A.size() - numberOfLessThanOrEqualNumbers(A, 1000))));
    }

    private static int sumOfElementsTillIndex(List<Integer> list, int index) {
        return IntStream.range(0, index)
                .map(list::get)
                .sum();
    }
}
