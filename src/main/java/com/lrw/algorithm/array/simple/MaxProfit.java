package com.lrw.algorithm.array.simple;

/**
 * desc:  买卖股票的最佳时机  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * Author: liurenwang
 * time : 2020/11/15 19:38
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
