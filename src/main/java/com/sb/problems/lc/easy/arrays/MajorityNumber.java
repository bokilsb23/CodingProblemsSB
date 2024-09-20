package com.sb.problems.lc.easy.arrays;

import java.util.HashMap;
import java.util.Map;


/*
* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2



Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


* */
public class MajorityNumber {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int maxNum = 0;
        int maxOccur = 0;
        for(int i=0; i< nums.length; i++) {
            if(numsMap.get(nums[i]) == null) {
                numsMap.put(nums[i], 1);
            } else {
                numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
            }
            if(numsMap.get(nums[i]) > nums.length/2) {
                return nums[i];
            }
            if(maxOccur < numsMap.get(nums[i])) {
                maxOccur = numsMap.get(nums[i]);
                maxNum = nums[i];
            }
        }
        return maxNum;
    }

        /*
        * Follow-up: Could you solve the problem in linear time and in O(1) space?
        *
        * Voting algorithm. We set a candidate, and increase it's count if it occurs, decrease it if it doesn't.
        * Any element that goes to zero is popped and a new element's count starts.
        * */
    public Integer majorityElementBoyerMoore(int[] nums) {
        Integer candidate = null;

        int count=0;

        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            count += (candidate == num ? 1 : -1);
        }

        return candidate;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        MajorityNumber m = new MajorityNumber();
        System.out.println(m.majorityElement(nums));
        System.out.println(m.majorityElementBoyerMoore(nums));

        nums = new int[]{3,2,3};
        System.out.println(m.majorityElement(nums));
        System.out.println(m.majorityElementBoyerMoore(nums));
        nums = new int[]{1,1,1,1,1,1};
        System.out.println(m.majorityElement(nums));
        System.out.println(m.majorityElementBoyerMoore(nums));
        nums = new int[]{1,2,3,4,5,6};
        System.out.println(m.majorityElement(nums));
        System.out.println(m.majorityElementBoyerMoore(nums));
        nums = new int[]{};
        System.out.println(m.majorityElement(nums));
        System.out.println(m.majorityElementBoyerMoore(nums));

        nums = new int[]{2,2,1,3,4,2,2,1,5,5,2,2,2,2};
        System.out.println(m.majorityElementBoyerMoore(nums));
    }
}
