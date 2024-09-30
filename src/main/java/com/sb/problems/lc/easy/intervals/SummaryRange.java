package com.sb.problems.lc.easy.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
        }
        int first = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - prev == 1) {
                prev = nums[i];
            } else if(nums[i] != prev || i == nums.length - 1) {
                if(first != prev) {
                    result.add(first + "->" + prev);
                } else {
                    result.add(first + "");
                }

                first = nums[i];
                prev = nums[i];
            }
            if(i == nums.length - 1) {
                if(first == prev) {
                    result.add(first +"");
                } else {
                    result.add(first + "->" + prev);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRange s = new SummaryRange();
        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(s.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(s.summaryRanges(new int[]{0}));
        System.out.println(s.summaryRanges(new int[]{}));
    }
}
