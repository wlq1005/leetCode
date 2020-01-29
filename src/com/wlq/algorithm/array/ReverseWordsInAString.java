package com.wlq.algorithm.array;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author wlq
 * @since 2020/1/22 15:26
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        if (length < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = length - 1;
        int count = 0;
        while (i >= 0) {
            if (arr[i] != ' ') {
                count++;
            }
            if (arr[i] == ' ' || i == 0) {
                if (count > 0) {
                    if (sb.length() > 0) {
                        sb.append(' ');
                    }
                    int j = i + 1;
                    int k = i + count;
                    // 如果最后个字符不是空格的话则直接拼接
                    if (i == 0 && arr[i] != ' ') {
                        j -= 1;
                        k -= 1;
                    }
                    while (j <= k) {
                        sb.append(arr[j]);
                        j++;
                    }
                    count = 0;
                }
            }
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords("  "));
    }
}
