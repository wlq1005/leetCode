package com.wlq.algorithm.array;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author wuliuqing
 * @date 2020/1/16 9:50
 **/
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int sum = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                count = count == 0 ? j + 1 : Math.min(count, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1,7};
        MinimumSizeSubArraySum minimumSizeSubArraySum = new MinimumSizeSubArraySum();
        System.out.println(minimumSizeSubArraySum.minSubArrayLen(8, arr));
    }
}
