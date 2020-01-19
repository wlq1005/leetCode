package com.wlq.algorithm.dynamic;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author wuliuqing
 * @date 2020/1/19 15:15
 **/
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(arr));
    }
}
