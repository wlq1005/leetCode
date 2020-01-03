package com.wlq.algorithm.array;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author wlq
 * @since 2020/1/2 22:51
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (minLength > strs[i].length()) {
                minLength = strs[i].length();
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char temp = '\0';
            for (int j = 0; j < strs.length; j++) {
                char c = strs[j].charAt(i);
                if (temp == '\0') {
                    temp = c;
                }
                if (temp == c && j + 1 == strs.length) {
                    result.append(temp);
                    break;
                } else if (temp != c) {
                    return result.toString();
                }

            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = new String[]{"flower"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

}
