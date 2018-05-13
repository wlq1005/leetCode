package com.wulq.learn.array;

/**
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 *
 * @author wlq
 * @since 2018/5/13 20:52
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] numArray = new int[]{1, 1, 2};
        System.out.println(removeDuplicates.removeDuplicates(numArray));
        int[] numArray2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates.removeDuplicates(numArray2));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
