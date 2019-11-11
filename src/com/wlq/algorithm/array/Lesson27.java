package com.wlq.algorithm.array;

/**
 * 加一
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 * <p>
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author wlq
 * @since 2018/5/16 17:34
 */
public class Lesson27 {

    public static void main(String[] args) {
        Lesson27 lesson27 = new Lesson27();
        int[] digits1 = new int[]{1, 2, 3};
        digits1 = lesson27.plusOne(digits1);
        for(int num : digits1) {
            System.out.println(num);
        }
        System.out.println("=========================");
        int[] digits2 = new int[]{4, 3, 2, 1};
        digits2 = lesson27.plusOne(digits2);
        for(int num : digits2) {
            System.out.println(num);
        }
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }
}
