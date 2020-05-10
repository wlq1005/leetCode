package com.wlq.algorithm.array;

/**
 * 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author wuliuqing
 * @date 2020/5/8 15:39
 **/
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // dp存储以matrix[i][j]为右下角的正方形的长度。这边扩容了1
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        // 如果该位置的值是 00，则 dp(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；
        // 如果该位置的值是 11，则 dp(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的dp值决定。
        // 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 11，状态转移方程如下：
        // dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
        // dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != '0') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i][j]), dp[i + 1][j]) + 1;
                    max = Math.max(dp[i + 1][j + 1], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] arr = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare.maximalSquare(arr));
    }
}
