package com.wulq.learn.array;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author wlq
 * @since 2018/5/14 11:14
 */
public class Lesson22 {

    public static void main(String[] args) {
        Lesson22 lesson22 = new Lesson22();
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(lesson22.maxProfit(prices1));
        int[] prices2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(lesson22.maxProfit(prices2));
        int[] prices3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(lesson22.maxProfit(prices3));
    }

    /**
     * Solution 1
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    /**
     * Solution 2
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int begin = prices[0];
        int end = prices[0];
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] >= end) {
                end = prices[i];
            } else {
                sum = sum + end - begin;
                begin = prices[i];
                end = prices[i];
            }
        }
        sum = sum + end - begin;
        return sum;
    }

    /**
     * Solution 3
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.min(buy[i - 1], prices[i] - sell[i - 1]);
            sell[i] = Math.max(sell[i - 1], prices[i] - buy[i - 1]);
        }
        return sell[prices.length - 1];
    }
}
