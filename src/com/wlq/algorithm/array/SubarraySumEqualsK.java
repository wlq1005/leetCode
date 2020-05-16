package com.wlq.algorithm.array;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author wlq
 * @since 2020/5/15 23:27
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 7, 1, 1, 2, 11, 3, 1, 4, 5, 1, 6, 1, 1, 1};
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        subarraySumEqualsK.subarraySum(arr, 5);
        // [28,54,7,-70,22,65,-6]
        //100
    }
}
