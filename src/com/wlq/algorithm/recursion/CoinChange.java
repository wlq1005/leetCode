package com.wlq.algorithm.recursion;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author wlq
 * @since 2020/7/4 21:50
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int con : coins) {
                if (i - con < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - con] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] conis = new int[]{2};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(conis, 3));
    }
}
