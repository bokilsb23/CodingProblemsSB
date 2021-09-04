package com.sb.problems.two_pointers;


import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.asList;

/**
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 *
 * Find i, j, k such that :
 *
 * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 *
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 *
 * **abs(x) is absolute value of x and is implemented in the following manner : **
 *
 *       if (x < 0) return -x;
 *       else return x;
 * Example :
 *
 * Input :
 *         A : [1, 4, 10]
 *         B : [2, 15, 20]
 *         C : [10, 12]
 *
 * Output : 5
 *          With 10 from A, 15 from B and 10 from C.
 */
public class Array3Pointers {

    public static void main(String[] args) {
        System.out.println(arr3Pointers(asList(1,4,10), asList(2,15,20), asList(10,12)));
    }


    /**
     * The trick here is to increment the index for the smallest values, so that the difference can be minimized
     * @param A - List A
     * @param B - List B
     * @param C - List C
     * @return - minimum possible value of max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
     */
    private static int arr3Pointers(List<Integer> A, List<Integer> B, List<Integer> C) {
        int i=0, j=0, k=0;
        int min = Integer.MAX_VALUE;

        while(i < A.size() && j < B.size() && k < C.size()) {

            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);

            int currMax = max(max(abs(a-b), abs(b-c)), abs(c-a));
            min = min(currMax, min);
            int currMin = min(min(a, b), c);
            if(currMin == a) i++;
            else if(currMin == b) j++;
            else k++;
        }
        return min;
    }
}
