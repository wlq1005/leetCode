package com.wlq.algorithm.recursion;

import java.util.Arrays;

/**
 * 面试题 16.11. 跳水板
 * https://leetcode-cn.com/problems/diving-board-lcci/
 *
 * @author wlq
 * @since 2020/7/8 23:33
 */
public class DivingBoardLcci {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }

    public static void main(String[] args) {
        DivingBoardLcci div = new DivingBoardLcci();
        System.out.println(Arrays.toString(div.divingBoard(1, 2, 3)));
    }
}
