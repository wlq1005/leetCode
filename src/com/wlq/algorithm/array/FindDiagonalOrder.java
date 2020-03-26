package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 对角线遍历
 * https://leetcode-cn.com/problems/diagonal-traverse/
 *
 * @author wlq
 * @since 2019/12/5 22:05
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        for (int i = 0; i < m + n - 1; i++) {
            int low = Math.max(0, i - n + 1);
            int high = Math.min(i, m - 1);
            if (i % 2 == 0) {
                for (int j = high; j >= low; j--) {
                    arr[index++] = matrix[j][i - j];
                }
            } else {
                for (int j = low; j <= high; j++) {
                    arr[index++] = matrix[j][i - j];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] result = new FindDiagonalOrder().findDiagonalOrder(arr);
        System.out.println(Arrays.toString(result));
    }
}
