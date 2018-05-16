package com.wulq.learn.array;

/**
 * 存在重复
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author wlq
 * @since 2018/5/16 16:07
 */
public class Lesson24 {

    public static void main(String[] args) {
        Lesson24 lesson24 = new Lesson24();
        int[] nums1 = new int[]{1, 2, 3, 1};
        System.out.println(lesson24.containsDuplicate(nums1));
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(lesson24.containsDuplicate(nums2));
        int[] nums3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(lesson24.containsDuplicate(nums3));
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
