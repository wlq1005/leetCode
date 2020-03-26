package com.wlq.algorithm.array;

/**
 * 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr
 *
 * @author wuliuqing
 * @date 2020/1/3 14:05
 **/
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i <= haystackArr.length - needleArr.length; i++) {
            int j;
            for (j = 0; j < needleArr.length; j++) {
                if (needleArr[j] != haystackArr[i + j]) {
                    break;
                }
            }
            if (j == needleArr.length) {
                return i;
            }
        }
        return haystack.equals(needle) ? 0 : -1;
    }

    public static void main(String[] args) {
        ImplementStrStr test = new ImplementStrStr();
        System.out.println(test.strStr("like", "ik"));
    }
}
