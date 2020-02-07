package com.wlq.algorithm.array;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author wlq
 * @since 2020/2/7 11:40
 */
public class BeforeYouStart {

    public int singleNumber(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 异或，两位都相等则是0
            num = num ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2, 4, 3};
        BeforeYouStart beforeYouStart = new BeforeYouStart();
        System.out.println(beforeYouStart.singleNumber(nums));
        System.out.println(2 << 2);
    }
}
