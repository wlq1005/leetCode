package com.wlq.algorithm.math;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author wuliuqing
 * @date 2020/5/9 9:25
 **/
public class Sqrtx {

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(0));
    }
}
