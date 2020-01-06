package com.wlq.algorithm.array;

import java.util.Arrays;

/**
 * 344.反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author wuliuqing
 * @date 2020/1/6 21:18
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        if (s != null && s.length > 1) {
            int i = 0;
            int j = s.length - 1;
            while (i < j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }
}
