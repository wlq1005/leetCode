package com.wlq.algorithm.dp;

/**
 * 1014. 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 *
 * @author wuliuqing
 * @date 2020/6/17 15:44
 **/
public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = A[0];
        int res = 0;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 5, 2, 6};
        BestSightseeingPair bestSightseeingPair = new BestSightseeingPair();
        System.out.println(bestSightseeingPair.maxScoreSightseeingPair(arr));
    }
}
