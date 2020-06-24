package com.wlq.algorithm.array;

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
        int res = Integer.MAX_VALUE;
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                while (second < third && third < length) {
                    int temp = nums[first] + nums[second] + nums[third];
                    // 如果和target值一样，那么最接近，直接返回
                    if (target == temp) {
                        return temp;
                    }
                    if (res == Integer.MAX_VALUE) {
                        res = temp;
                    } else if (target > temp && target - temp < target - res ) {
                        res = temp;
                    } else if (target < temp && temp - target < res - target) {
                        res = temp;
                    }
                    third++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, -3};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(arr, 1));
    }

}
