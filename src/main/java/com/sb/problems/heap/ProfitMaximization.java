package com.sb.problems.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Arrays.asList;

public class ProfitMaximization {

    private static int solve(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(A);

        int result = 0;
        for(int i=0; i < B; i++) {
            Integer maxSeatRow = queue.remove();
            if(maxSeatRow == 0) {
                break;
            }
            result += maxSeatRow;
            queue.add(maxSeatRow-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(asList(2,3)), 3));
        System.out.println(solve(new ArrayList<>(asList(1,4)), 2));
        System.out.println(solve(new ArrayList<>(asList(2,3,4,5,1)), 6));
    }
}
