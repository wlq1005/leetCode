package com.wlq.algorithm.array;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @author wlq
 * @since 2020/1/29 23:55
 */
public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] arr = s.toCharArray();
        while (end < s.length()) {
            end = s.indexOf(' ', start);
            if (end < 0) {
                end = s.length();
            }
            reserve(arr, start, end - 1);
            start = end + 1;
        }
        return new String(arr);
    }

    private void reserve(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString3 reverseWordsInAString3 = new ReverseWordsInAString3();
        System.out.println(reverseWordsInAString3.reverseWords("d2223"));
    }
}
