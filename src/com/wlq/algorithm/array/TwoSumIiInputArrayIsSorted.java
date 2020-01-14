package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author wlq
 * @since 2020/1/14 21:14
 */
public class TwoSumIiInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumIiInputArrayIsSorted twoSumIiInputArrayIsSorted = new TwoSumIiInputArrayIsSorted();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 9, 9, 10};
        int[] result = twoSumIiInputArrayIsSorted.twoSum(arr, 18);
        System.out.println(Arrays.toString(result));
    }
}
