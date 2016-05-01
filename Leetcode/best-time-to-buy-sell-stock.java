/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Time - O(n)
 */

public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int lowest = Integer.MAX_VALUE;
        int profit = 0;

        for (int currentPrice : prices) {
            lowest = Math.min(lowest, currentPrice);
            profit = Math.max(profit, currentPrice - lowest);
        }

        return profit;

    }
}