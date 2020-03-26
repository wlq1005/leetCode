package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 加一
 * https://leetcode-cn.com/problems/plus-one/
 *
 * @author wlq
 * @since 2019/12/4 23:35
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9};
        int[] newNums = new PlusOne().plusOne(nums);
        System.out.println(Arrays.toString(newNums));
    }
}
