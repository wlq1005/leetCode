package com.wlq.algorithm.array;

/**
 * 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/submissions/
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
        for (int i = 0; i < haystackArr.length; i++) {
            if (i + needle.length() > haystackArr.length) {
                return -1;
            }
            int j = 0, k = i;
            while (j < needleArr.length && haystackArr[k] == needleArr[j]) {
                j++;
                k++;
            }
            if (j == needleArr.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr test = new ImplementStrStr();
        System.out.println(test.strStr("mississippi", "issip"));
    }
}
