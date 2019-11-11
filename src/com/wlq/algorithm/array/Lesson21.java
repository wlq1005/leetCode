package com.wlq.algorithm.array;

/**
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * @author wlq
 * @since 2018/5/13 20:52
 */
public class Lesson21 {

    public static void main(String[] args) {
        Lesson21 lesson21 = new Lesson21();
        int[] numArray = new int[]{1, 1, 2};
        System.out.println(lesson21.removeDuplicates(numArray));
        int[] numArray2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(lesson21.removeDuplicates(numArray2));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
