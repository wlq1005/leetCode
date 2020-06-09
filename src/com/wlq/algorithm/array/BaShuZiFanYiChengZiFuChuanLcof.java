package com.wlq.algorithm.array;

/**
 * 面试题46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author wuliuqing
 * @date 2020/6/9 16:16
 **/
public class BaShuZiFanYiChengZiFuChuanLcof {

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        int left = num % 100;
        if (left < 10 || left > 25) {
            return translateNum(num / 10);
        } else {
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }

    public static void main(String[] args) {
        BaShuZiFanYiChengZiFuChuanLcof b = new BaShuZiFanYiChengZiFuChuanLcof();
        System.out.println(b.translateNum(12258));
    }
}
