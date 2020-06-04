package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * @author wuliuqing
 * @date 2020/6/4 11:57
 **/
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        // 计算左边的乘积
        for (int i = 0; i < nums.length; i++) {
            left[i] = i == 0 ? 1 : left[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (i != length - 1) {
                right = nums[i + 1] * right;
            }
            left[i] = left[i] * right;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 1, 2};
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] result = p.productExceptSelf(arr);
        Arrays.stream(result).forEach(System.out::println);
    }
}
