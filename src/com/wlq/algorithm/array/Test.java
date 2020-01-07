package com.wlq.algorithm.array;

/**
 * @author wuliuqing
 * @date 2020/1/6 21:40
 **/
public class Test {

    public int arrayPairSum(int[] nums) {
        int i = 0;
        int j = nums.length;
        int sum = 0;
        while (i < j) {
            i++;
            j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            if (i % 2 == 1) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = new int[]{1,6,7,8,9,7};
        System.out.println(test.arrayPairSum(nums));
    }
}
