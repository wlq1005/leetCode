package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author wlq
 * @since 2020/2/4 22:55
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length < 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
