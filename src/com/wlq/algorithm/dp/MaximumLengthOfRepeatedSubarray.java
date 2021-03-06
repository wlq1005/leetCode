package com.wlq.algorithm.dp;

/**
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @author wlq
 * @since 2020/7/1 23:33
 */
public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = A.length - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        MaximumLengthOfRepeatedSubarray max = new MaximumLengthOfRepeatedSubarray();
        System.out.println(max.findLength(A, B));
    }

}
