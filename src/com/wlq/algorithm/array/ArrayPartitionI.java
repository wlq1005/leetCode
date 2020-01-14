package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * https://leetcode-cn.com/problems/array-partition-i/
 *
 * @author wlq
 * @since 2020/1/14 20:59
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 从小到大排序
        Arrays.sort(nums);
        int result = 0;
        // 直接取奇数位，排序完后，相邻的两数值最接近，计算min之后丢失少
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
        System.out.println(arrayPartitionI.arrayPairSum(arr));
    }
}
