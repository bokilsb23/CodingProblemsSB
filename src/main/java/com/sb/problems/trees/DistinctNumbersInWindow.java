package com.sb.problems.trees;

import java.util.*;

import static java.util.Arrays.asList;

public class DistinctNumbersInWindow {


    /**
     * Time complexity of this solution is not good since we keep clearing hashset for every window
     * @param A - list
     * @param B - size of window
     * @return distinct numbers list
     */
    private static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer>  mainQueue = new LinkedList<>(A);

        if(A.size() < B) {
            return new ArrayList<>(Collections.emptyList());
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=0; i<B;i++){
            queue.addLast(mainQueue.remove());
        }
        Set<Integer> windowSet = new HashSet<>(queue);
        result.add(windowSet.size());

        while(mainQueue.size() > 0) {
            queue.remove();
            queue.addLast(mainQueue.remove());
            windowSet.clear();
            windowSet.addAll(queue);
            result.add(windowSet.size());
        }
        return result;
    }

    /**
     * O(n) time complexity
     * @param A - list
     * @param B - window size
     * @return - distinct numbers list
     */
    private static ArrayList<Integer> solution2(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < B; i++)
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);

        result.add(map.size());

        // Traverse through the remaining array
        for (int i = B; i < A.size(); i++) {

            // Remove first element of previous window
            // If there was only one occurrence
            if (map.get(A.get(i-B)) == 1) {
                map.remove(A.get(i-B));
            }

            else // reduce count of the removed element
                map.put(A.get(i-B),  map.get(A.get(i-B)) - 1);

            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);

            // Print count of current window
            result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new ArrayList<>(asList(1,2,1,3,4,3)), 3));
        System.out.println(solution2(new ArrayList<>(asList(1,1,2,2)), 1));
        System.out.println(solution2(new ArrayList<>(asList(1, 2, 1, 3, 4, 2, 3)), 4));

    }

}
