package com.wlq.algorithm.array;

/**
 * 寻找数组的中心索引
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * @author wlq
 * @since 2019/12/4 22:50
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (leftSum == sum - temp - leftSum) {
                return i;
            }
            leftSum += temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3};
        System.out.println(new PivotIndex().pivotIndex(nums));
    }

}
