package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author wlq
 * @since 2020/1/14 21:53
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] arr = new int[]{1, 2, 3, 1, 5, 6, 1};
        int length = removeElement.removeElement(arr, 3);
        System.out.println(Arrays.toString(arr));
        System.out.println(length);
    }
}
