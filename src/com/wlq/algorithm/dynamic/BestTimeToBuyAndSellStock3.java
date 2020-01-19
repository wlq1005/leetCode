package com.wlq.algorithm.dynamic;

/**
 * 123. 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author wuliuqing
 * @date 2020/1/19 15:15
 **/
public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        // 有四种状态 第一次买入(firBuy)，第一次卖出(firSell)，第二次买入(secBuy)，第二次卖出(secSell)
        // firBuy = max(firBuy, prices[i]);
        // firSell = max(firSell, firBuy + prices[i]);
        // secBuy = max(secBuy, firSell - prices[i])
        // secSell = max(secSell, secBuy + prices[i])
        int firBuy = Integer.MIN_VALUE, firSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int i = 0; i < prices.length; i++) {
            firBuy = Math.max(firBuy, -prices[i]);
            firSell = Math.max(firSell, firBuy + prices[i]);
            secBuy = Math.max(secBuy, firSell - prices[i]);
            secSell = Math.max(secSell, secBuy + prices[i]);
        }
        return secSell;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock3 = new BestTimeToBuyAndSellStock3();
        int[] arr = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(bestTimeToBuyAndSellStock3.maxProfit(arr));
    }

}
