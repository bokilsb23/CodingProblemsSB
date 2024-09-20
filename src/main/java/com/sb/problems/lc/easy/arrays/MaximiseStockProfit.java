package com.sb.problems.lc.easy.arrays;

/*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.



Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104


* */
public class MaximiseStockProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int lowerPrice = prices[0];;
        int higherPrice = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < lowerPrice) {
                lowerPrice = prices[i];
                higherPrice = prices[i];//Since previous higher price was in the past, reset it to current price
            }
            if(prices[i] > higherPrice) {
                higherPrice = prices[i];
            }
        }
        return higherPrice - lowerPrice;
    }

    public static void main(String[] args) {
        MaximiseStockProfit ms = new MaximiseStockProfit();
        System.out.println(ms.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(ms.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(ms.maxProfit(new int[]{7,2,3,1,5,3,4}));
        System.out.println(ms.maxProfit(new int[]{1,1,1,1,1,1,1}));
    }
}
