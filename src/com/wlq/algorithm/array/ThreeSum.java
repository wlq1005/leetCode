package com.wlq.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author wuliuqing
 * @date 2020/6/12 10:38
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            // 大于的0的，往后也是大于0的，没必要再遍历
            if (nums[first] > 0) {
                break;
            }
            // 与上次的值不能相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < length; second++) {
                // 与上次的值不能相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 2, 1, 0, 5};
        // [[-4,-1,5],[-1,-1,2],[-1,0,1],[-1,0,1]]
        // [[-4,-1,5],[-4,2,2],[-1,-1,2],[-1,0,1]]
        List<List<Integer>> result = threeSum.threeSum(nums);
        result.forEach(f -> System.out.println(Collections.singletonList(f).toString()));
    }

}
