package com.wlq.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author wlq
 * @since 2020/3/20 22:59
 */
public class FibonacciNumber {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N - 2) + fib(N - 1);
        }
        cache.put(N, result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(13));
    }
}
