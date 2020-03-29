package com.wlq.algorithm.recursion;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author wlq
 * @since 2020/3/29 20:37
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return pow(1 / x, -n);
        } else {
            return pow(x, n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // x的2n次方等于x的n次方乘以x的n次方，所以没必要每个都进行乘法
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(0.00001, 2147483647));
    }
}
