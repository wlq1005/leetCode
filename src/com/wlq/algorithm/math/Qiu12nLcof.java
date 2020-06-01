package com.wlq.algorithm.math;

/**
 * 面试题64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author wlq
 * @since 2020/6/2 00:12
 */
public class Qiu12nLcof {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Qiu12nLcof q = new Qiu12nLcof();
        System.out.println(q.sumNums(10));
    }
}
