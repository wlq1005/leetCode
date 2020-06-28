package com.wlq.algorithm.recursion;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author wlq
 * @since 2020/6/28 21:05
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int idx = 1;
            int min = dp[i];
            while (i - idx * idx >= 0) {
                min = Math.min(dp[i - idx * idx] + 1, min);
                idx++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(11));
    }

}
