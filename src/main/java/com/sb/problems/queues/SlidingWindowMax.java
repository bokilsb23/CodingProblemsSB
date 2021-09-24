package com.sb.problems.queues;

import java.util.*;

public class SlidingWindowMax {

    public static void main(String[] args) {
        System.out.println(getSlidingWindowMaximums(Arrays.asList(1,3,-1,-3,5,3,6,7), 3));
    }

    private static ArrayList<Integer> getSlidingWindowMaximums(List<Integer> A, int B) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        int i;
        //First fill the window
        for(i = 0; i < B; i++) {

            while(!queue.isEmpty() && A.get(i) >= A.get(queue.peekLast())) {//keep the largest value in current window at the last index of queue
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for(; i < A.size(); i++) {//for remaining list
            result.add(A.get(queue.peekFirst()));//first value in the queue will be largest for current window

            while(!queue.isEmpty() && queue.peek() <= i-B) {//remove elements that are not in current window
                queue.removeFirst();
            }

            while(!queue.isEmpty() && A.get(i) >= A.get(queue.peekLast())) {//keep the largest value in current window at the last index of queue
                queue.removeLast();
            }
            queue.addLast(i);
        }
        result.add(A.get(queue.peekFirst()));//add element for the last window in the result
        return result;
    }

}
