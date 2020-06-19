package com.wlq.algorithm.array;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author wuliuqing
 * @date 2020/6/19 17:46
 **/
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        s = s.toUpperCase();
        while (start < end) {
            char a = s.charAt(start);
            if (!Character.isLetterOrDigit(a)) {
                start++;
                continue;
            }
            char b = s.charAt(end);
            if (!Character.isLetterOrDigit(b)) {
                end--;
                continue;
            }
            if (a != b) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome.isPalindrome(str));
    }
}
