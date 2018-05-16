package com.wulq.learn.array;

/**
 * 旋转数组
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * @author wlq
 * @since 2018/5/15 14:32
 */
public class Lesson23 {

    public static void main(String[] args) {
        Lesson23 lesson23 = new Lesson23();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        lesson23.rotate(nums, k);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == length) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int t = nums[length - 1];
            for (int j = length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = t;
        }
    }


}
