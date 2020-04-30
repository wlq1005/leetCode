package com.wlq.algorithm.array;

/**
 * 162. 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 *
 * @author wuliuqing
 * @date 2020/4/30 16:09
 **/
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 二分法找出中间节点，如果小于右边元素，说明峰值在右半部分，下次查询从mid+1开始
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // 否则的话，峰值在左半部分
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 9, 10, 9, 8, 6, 6, 6, 5, 5, 3, 2, 1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(arr));
    }
}
