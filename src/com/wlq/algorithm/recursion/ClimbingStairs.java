package com.wlq.algorithm.recursion;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author wlq
 * @since 2020/3/21 00:18
 */
public class ClimbingStairs {

//    private int[] arr;

//    public int climbStairs(int n) {
//        arr = new int[n + 1];
//        return stairs(0, n);
//    }
//
//    private int stairs(int i, int n) {
//        // i:当前级数，n:总共级
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        if (arr[i] > 0) {
//            return arr[i];
//        }
//        arr[n] = stairs(i + 1, n) + stairs(i + 2, n);
//        return arr[n];
//    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
       int first = 1;
       int second = 2;
       for (int i = 3; i <= n; i++) {
           int third = first + second;
           first = second;
           second = third;
       }
       return second;
    }

}

