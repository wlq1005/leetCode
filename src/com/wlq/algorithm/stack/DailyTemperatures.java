package com.wlq.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author wlq
 * @since 2020/6/11 21:08
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[]{};
        }
        int length = T.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                int val = T[index];
                // 当前值小于栈顶值，直接入栈
                // 大于栈顶值，则出栈
                if (T[i] <= val) {
                    stack.push(i);
                    break;
                } else {
                    result[index] = i - index;
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(arr);
        System.out.println(Arrays.toString(result));
    }
}
