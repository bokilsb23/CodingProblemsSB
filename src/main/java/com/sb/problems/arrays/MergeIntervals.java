package com.sb.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    /**
     * Merges overlapping intervals in an array (Time complexity O(n^2))
     *
     * @param intervals = 2D Array having  arrays of (start,end) elements as values
     * @return - merged interval array
     */
    public int[][] merge(int[][] intervals) {
        int[][] resultIntervals = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            for (int[] interval2 : intervals) {
                if (currInterval[0] == interval2[0] && currInterval[1] == interval2[1]) {
                    continue;
                }
                if (currInterval[1] >= interval2[0] && currInterval[1] <= interval2[1] && currInterval[0] <= interval2[0]) {
                    currInterval[1] = interval2[1];
                    resultIntervals[i] = currInterval;
                }
            }
        }
        return resultIntervals;
    }

    /**
     * Merges overlapping intervals in an array (Time complexity O(nlogn))
     *
     * @param intervals = 2D Array having  arrays of (start,end) elements as values
     * @return - merged interval array
     */
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[][] results = new int[intervals.length][2];
        results[0] = intervals[0];
        int currResIndex = 0;
        int resultSize = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            int[] res = results[currResIndex];
            int[] curr = intervals[i];
            if (res[1] >= curr[0]) {
                if (res[1] < curr[1]) {
                    results[currResIndex] = new int[]{res[0], curr[1]};
                }
                resultSize--;
            } else {
                results[++currResIndex] = curr;
            }
        }
        int[][] finalResult = new int[resultSize][2];
        System.arraycopy(results, 0, finalResult, 0, resultSize);
        return finalResult;
    }

    /**
     * Merges overlapping Intervals in a list (Time complexity O(nlogn))
     *
     * @param intervals = List of Intervals
     * @return - merged interval list
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> results = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(i -> i.start));
        results.add(0, intervals.get(0));
        int currResIndex = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval res = results.get(currResIndex);
            Interval curr = intervals.get(i);
            if (res.end >= curr.start) {
                if (res.end < curr.end) {
                    results.remove(currResIndex);
                    results.add(currResIndex, new Interval(res.start, curr.end));
                }
            } else {
                results.add(++currResIndex, curr);
            }
        }
        return results;
    }

    static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    public static void main(String[] args) {
        MergeIntervals me = new MergeIntervals();

        //int[][] merge = me.merge2(new int[][]{new int[]{1, 3}, new int[]{2, 5}, new int[]{8, 10}});
        int[][] merge = me.merge2(new int[][]{new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 8}});
        //int[][] merge = me.merge2(new int[][]{new int[]{1, 10}, new int[]{1, 11}, new int[]{8, 10}});
        //ArrayList<Interval> merged = me.merge(new ArrayList<>(Arrays.asList(new Interval(1,3), new Interval(2,5), new Interval(8,10))));
        //ArrayList<Interval> merged = me.merge(new ArrayList<>(Arrays.asList(new Interval(1,5), new Interval(2,3), new Interval(2,8))));
        ArrayList<Interval> merged = me.merge(new ArrayList<>(Arrays.asList(new Interval(1, 10), new Interval(1, 11), new Interval(8, 10))));


        merged.stream().forEach(i -> System.out.println(i.toString()));

        Arrays.stream(merge).forEach(i -> {
            System.out.print("[");
            Arrays.stream(i).forEach(j -> System.out.print("" + j + ","));
            System.out.println("],");
        });
    }
}
