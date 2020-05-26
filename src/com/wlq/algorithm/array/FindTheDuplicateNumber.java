package com.wlq.algorithm.array;

/**
 * 287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author wuliuqing
 * @date 2020/5/26 11:13
 **/
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int s = 0, f = s + 1;
        int n = -1;
        while (s < f && f < length) {
            if (nums[s] == nums[f]) {
                n = nums[s];
                break;
            } else {
                if (f < length - 1) {
                    f++;
                } else {
                    s++;
                    f = s + 1;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int[] arr = new int[]{1, 1};
        System.out.println(findTheDuplicateNumber.findDuplicate(arr));
    }
}
