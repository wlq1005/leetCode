package com.wlq.algorithm.math;

/**
 * 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 *
 * @author wlq
 * @since 2020/8/23 22:34
 */
public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        // 先找出公共前缀，公共前缀后面的再用0补齐
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

    public static void main(String[] args) {
        BitwiseAndOfNumbersRange bit = new BitwiseAndOfNumbersRange();
        System.out.println(bit.rangeBitwiseAnd(5, 7));
    }
}
