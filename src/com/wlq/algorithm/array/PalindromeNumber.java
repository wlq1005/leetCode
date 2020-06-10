package com.wlq.algorithm.array;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author wuliuqing
 * @date 2020/6/10 15:17
 **/
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.charAt(0) == '-') {
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(101201));
    }
}
