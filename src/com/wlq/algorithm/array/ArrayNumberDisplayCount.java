package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
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
