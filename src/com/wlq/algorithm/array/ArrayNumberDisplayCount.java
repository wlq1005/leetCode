package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * @author wuliuqing
 * @date 2020/4/28 14:18
 **/
public class ArrayNumberDisplayCount {

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int val : nums) {
            x ^= val;
        }
        int flag = x & (-x);
        int result = 0;
        for (int val : nums) {
            if ((flag & val) != 0) {
                result ^= val;
            }
        }
        return new int[]{result, x ^ result};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 4, 6};
        int[] result = new ArrayNumberDisplayCount().singleNumbers(arr);
        System.out.println(Arrays.toString(result));
    }
}
