package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * @author wuliuqing
 * @date 2020/6/5 10:19
 **/
public class ShunShiZhenDaYinJuZhenLcof {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int[] result = new int[m * n];
        result[0] = 1;
        int up = 0, down = n - 1, left = 0, right = m - 1;
        int idx = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                result[idx++] = matrix[up][i];
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                result[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result[idx++] = matrix[down][i];
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                result[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ShunShiZhenDaYinJuZhenLcof sh = new ShunShiZhenDaYinJuZhenLcof();
        int[] res = sh.spiralOrder(arr);
        System.out.println(Arrays.toString(res));
    }
}
