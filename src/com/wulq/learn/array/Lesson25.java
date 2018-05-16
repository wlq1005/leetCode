package com.wulq.learn.array;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author wlq
 * @since 2018/5/16 16:39
 */
public class Lesson25 {

    public static void main(String[] args) {
        Lesson25 lesson25 = new Lesson25();
        int nums1[] = new int[]{2, 2, 1};
        System.out.println(lesson25.singleNumber(nums1));
        int nums2[] = new int[]{4, 1, 2, 1, 2};
        System.out.println(lesson25.singleNumber(nums2));

    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i >= length - 1) {
                return nums[i];
            }
            if (nums[i] == nums[i + 1]) {
                i = i + 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}
