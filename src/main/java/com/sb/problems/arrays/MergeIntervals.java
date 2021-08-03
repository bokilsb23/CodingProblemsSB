package com.sb.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int[][] resultIntervals = new int[intervals.length][2];
        for(int i = 0; i< intervals.length;i++) {
            int[] currInterval = intervals[i];
            for(int[] interval2 : intervals) {
                if(currInterval[0] == interval2[0] && currInterval[1] == interval2[1]) {
                    continue;
                }
                if(currInterval[1] >= interval2[0] && currInterval[1] <= interval2[1] && currInterval[0] <= interval2[0]) {
                    currInterval[1] = interval2[1];
                    resultIntervals[i] = currInterval;
                }
            }
        }
        return resultIntervals;
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        int [][] results = new int[intervals.length][2];
        results[0] = intervals[0];
        int currResIndex = 0;
        int resultSize = intervals.length;
        for(int i=1; i<intervals.length;i++) {
            int[] res = results[currResIndex];
            int[] curr = intervals[i];
            if (res[1] >= curr[0]) {
                if(res[1] < curr[1]) {
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


    public static void main(String[] args) {
        MergeIntervals me = new MergeIntervals();

        //int[][] merge = me.merge2(new int[][]{new int[]{1, 3}, new int[]{2, 5}, new int[]{8, 10}});
        int[][] merge = me.merge2(new int[][]{new int[]{1, 50}, new int[]{2, 3}, new int[]{2, 8}});
        //int[][] merge = me.merge2(new int[][]{new int[]{1, 10}, new int[]{1, 11}, new int[]{8, 10}});

        Arrays.stream(merge).forEach(i -> {
            System.out.print("[");
            Arrays.stream(i).forEach(j -> System.out.print(""+j+","));
            System.out.println("],");
        });
    }
}
