package com.wlq.algorithm.recursion;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author wlq
 * @since 2020/5/29 22:48
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null|| nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 假设有i间房，能偷的金额为dp[i]
        // 不偷第i间的话，偷窃金额就是前 i-1 间的金额总和，记做dp[i - 1]
        // 偷第i间的话，偷窃金额就是前 i-2 间的金额总和加上第i间的金额，记做dp[i - 2] + nums[i]
        // 所以能偷的最高金额则为 Math.max(dp[i - 1], dp[i - 2] + nums[i])
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] str = new int[]{2, 7, 9, 3, 1};
        System.out.println(houseRobber.rob(str));
    }
}
