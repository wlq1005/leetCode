package com.wlq.algorithm.dynamic;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author wuliuqing
 * @date 2020/1/19 10:43
 **/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 只考需虑当天最少的买入和最大的卖出
        // 最大买入:buy = max(buy, -price[i])
        // 最大卖出:sell = max(sell, buy + price[i])
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr));
    }
}
