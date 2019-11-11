package com.wlq.algorithm.array;

/**
 * 移动零
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author 17050408
 * @since 2018/5/17 11:23
 */
public class Lesson28 {

    public static void main(String[] args) {
        Lesson28 lesson28 = new Lesson28();
        int[] nums = new int[]{0};
        lesson28.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0 || length == 1) {
                continue;
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            index++;
        }
    }
}
