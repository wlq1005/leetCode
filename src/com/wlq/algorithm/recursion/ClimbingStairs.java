package com.wlq.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author wlq
 * @since 2020/3/21 00:18
 */
public class ClimbingStairs {

    private int[] arr;

    public int climbStairs(int n) {
        arr = new int[n + 1];
        return stairs(n);
    }

    private int stairs(int n) {
        if (arr[n] > 0) {
            return arr[n];
        }
        int result;
        if (n < 4) {
            result = n;
        } else {
            result = stairs(n - 2) + stairs(n - 1);
        }
        arr[n] = result;
        return result;
    }

}
