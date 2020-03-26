package com.wlq.algorithm.array;

/**
 * 二进制求和
 * https://leetcode-cn.com/problems/add-binary
 *
 * @author wuliuqing
 * @date 2020/1/2 14:01
 **/
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }
        return a.length() >= b.length() ? add(a, b) : add(b, a);
    }

    private String add(String max, String min) {
        char[] maxArr = max.toCharArray();
        char[] minArr = min.toCharArray();
        int minIndex = minArr.length - 1;
        StringBuilder result = new StringBuilder();
        int pre = 0;
        for (int i = maxArr.length - 1; i >= 0; i--) {
            int m = maxArr[i] - '0';
            int n = (minIndex >= 0 ? minArr[minIndex--] - '0' : 0) + pre;
            int sum = m + n;
            result.append(sum % 2);
            pre = sum / 2 > 0 ? 1 : 0;
        }
        if (pre != 0) {
            result.append(pre);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary("1", "1010"));
    }
}
