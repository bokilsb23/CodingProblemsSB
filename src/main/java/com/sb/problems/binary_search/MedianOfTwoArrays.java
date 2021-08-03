package com.sb.problems.binary_search;

import java.util.List;

public class MedianOfTwoArrays {
    public static void main(String[] args) {

    }


    public double median(List<Integer> A, List<Integer> B) {
        if(A.size() == 2) {
            //TODO:ADD CODE
        }
        if(med(A) < med(B)) {
            return median(A.subList(0, (A.size()/2)+1), B.subList((B.size()/2)+1, B.size()));
        }
        else if(med(A) > med(B)) {
            return median(A.subList((A.size()/2)+1, A.size()), B.subList(0, (B.size()/2)+1));
        }
        return 0.0;
    }



    public double med(List<Integer> A) {
        return A.get(A.size()/2);
    }
}
