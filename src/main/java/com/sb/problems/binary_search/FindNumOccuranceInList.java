package com.sb.problems.binary_search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.binarySearch;

public class FindNumOccuranceInList {

    /*Given [5, 7, 7, 8, 8, 10] and target value 8,

return 2.*/
    public int findCount(final List<Integer> A, int B) {
        int index = binarySearch(A, B);
        if(index == -1) return 0;
        int count = 1;
        int i = index;
        if(i != 0 && A.get(i-1) == B) {
            while(i > 0) {
                int valueAtIndex= A.get(--i);
                if(valueAtIndex == B){
                    count++;
                }
                else{
                    break;
                }
            }
        }
        int j = index;
        if(j != A.size()-1 && A.get(j+1) == B) {

            while(j < A.size()-1) {
                int valueAtIndex= A.get(++j);
                if(valueAtIndex == B){
                    count++;
                }
                else{
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindNumOccuranceInList obj = new FindNumOccuranceInList();
        System.out.println(obj.findCount(Collections.singletonList(1), 1));
        System.out.println(obj.findCount(Arrays.asList(5, 7, 7, 8, 8, 10), 8));
    }
}
