package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author wuliuqing
 * @date 2020/1/17 10:17
 **/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        swap(nums, 0, length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, length - 1);
    }

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
