package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * @author wuliuqing
 * @date 2020/6/24 9:40
 **/
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 10000;
        int length = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = length - 1;
                while (second < third) {
                    int sum = nums[first] + nums[second] + nums[third];
                    // 如果和target值一样，那么最接近，直接返回
                    if (target == sum) {
                        return sum;
                    }
                    if (Math.abs(target - sum) < Math.abs(target -  res)) {
                        res = sum;
                    }
                    if (sum > target) {
                        int temp = third - 1;
                        while (second < temp && nums[temp] == nums[third]) {
                            --temp;
                        }
                        third = temp;
                    } else {
                        int temp = second + 1;
                        while (temp  < third && nums[temp] == nums[second]) {
                            ++temp;
                        }
                        second = temp;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(arr, 100));
    }

}
