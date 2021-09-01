package com.sb.problems.bit_manipulation;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.solve(Arrays.asList(1, 2, 2, 3, 1)));
        System.out.println(obj.solve(Arrays.asList(1, 2, 2)));
    }

    /**
     * Finds the number that doesn't repeat in an array of integers
     * @param A - list of integers
     * @return - number that doesn't repeat in the list
     */
    private int solve(List<Integer> A) {
        int number = 0;
        for (int a : A) {
            number ^= a;//XOR works here, since if a number is xor'd with itself, it is marked as zero.
            // the only number that remains in the end is the one that didn't reoccur
        }
        return number;
    }
}
