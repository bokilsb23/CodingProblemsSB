package com.sb.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSorterArrays {
    public static void main(String[] args) {
        IntersectionOfSorterArrays obj = new IntersectionOfSorterArrays();

        System.out.println(obj.intersection(Arrays.asList(1,3,4,5,7), Arrays.asList(2,3,5,6)));
        System.out.println(obj.intersection(Arrays.asList(2,5,6), Arrays.asList(4,6,8,10)));
        System.out.println(obj.intersection(Arrays.asList(1,2,3,3,4,5,6), Arrays.asList(3,3,5)));
        System.out.println(obj.intersection(Arrays.asList(1,2,3,3,4,5,6), Arrays.asList(3,5)));
        System.out.println(obj.intersection(Arrays.asList(1,2,3,3,4,5,6), Arrays.asList(1,2,3,3,4,5,6)));
    }

    private List<Integer> intersection(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;

        while(i< A.size() && j < B.size()) {

            if(A.get(i) < B.get(j)){
                i++;
            } else if(A.get(i) > B.get(j)) {
                j++;
            }
            else {
                result.add(A.get(i));
                i++;j++;
            }
        }
        return result;
    }
}
