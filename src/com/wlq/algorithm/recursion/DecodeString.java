package com.wlq.algorithm.recursion;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author wuliuqing
 * @date 2020/5/28 12:39
 **/
public class DecodeString {

    public String decodeString(String s) {
        if (s == null) {
            return "";
        }
        return decode(s);
    }

    private String decode(String s) {
        if ("".equals(s)) {
            return "";
        }
        if (s.indexOf('[') < 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int startIndex = 0;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            char next = arr[i + 1];
            if (next == '[') {
                if (startIndex == 0) {
                    startIndex = i + 1;
                }
                index++;
            } else if (next == ']') {
                if (index == 0) {
                    String str = decode(s.substring(startIndex + 1, i + 1));
                    int count = arr[i] - '0';
                    for (int j = 0; j < count; j++) {
                        sb.append(str);
                    }
                    startIndex = 0;
                    index = 0;
                }
                index--;
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("pty3[a2[av]rr2[t]]ef2[bc]gh"));
    }
}
