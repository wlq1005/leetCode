package com.wlq.algorithm.array;

/**
 * 至少是其他数字两倍的最大数
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/submissions/
 *
 * @author wlq
 * @since 2019/12/4 23:10
 */
public class DominantIndex {

public int dominantIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1;
    } else if (nums.length == 1) {
        return 0;
    }
    int maxIndex = -1;
    int maxIndex2 = -1;
    for (int i = 0; i < nums.length; i++) {
        int temp = nums[i];
        if (maxIndex == -1) {
            maxIndex = i;
        } else {
            if (temp > nums[maxIndex]) {
                maxIndex2 = maxIndex;
                maxIndex = i;
            } else if (temp == nums[maxIndex]) {
                maxIndex = i;
            } else if (maxIndex2 == -1 || temp > nums[maxIndex2]) {
                maxIndex2 = i;
            }

        }

    }
    if (nums[maxIndex2] * 2 <= nums[maxIndex]) {
        return maxIndex;
    } else {
        return -1;
    }
}

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 4, 9};
        System.out.println(new DominantIndex().dominantIndex(nums));
    }
}
