package com.sb.problems.lc.easy.hashmap;

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false



Constraints:

    1 <= n <= 231 - 1
 */
public class HappyNumber {

    public int getSumSquared(int n) {
        int sum = 0;
        while(n !=0) {
            int currVal = n%10;
            sum += (currVal*currVal);
            n = n/10;
        }
        return sum;
    }

    //Using slow and fast pointers.
    public boolean happyNumber(int n) {
        int slow = getSumSquared(n);
        int fast = getSumSquared(slow);

        while(slow != fast && fast != 1) {
            slow = getSumSquared(slow);
            fast = getSumSquared(getSumSquared(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.happyNumber(1));
        System.out.println(h.happyNumber(19));
        System.out.println(h.happyNumber(2));
        System.out.println(h.happyNumber(143071));
        System.out.println(h.happyNumber(367));
        System.out.println(h.happyNumber(139));
    }
}
