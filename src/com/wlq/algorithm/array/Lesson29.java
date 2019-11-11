package com.wlq.algorithm.array;

/**
 * 两数之和
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author wlq
 * @since 2018/5/17 19:17
 */
public class Lesson29 {

    public static void main(String[] args) {
        Lesson29 lesson29 = new Lesson29();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        int[] sum = lesson29.twoSum(nums, target);
        for (int num : sum) {
            System.out.println(num);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sum[0] = i;
                    sum[1] = j;
                    break;
                }
            }
        }
        return sum;
    }
}
