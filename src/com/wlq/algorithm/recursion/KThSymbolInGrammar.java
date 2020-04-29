package com.wlq.algorithm.recursion;

/**
 * 779. 第K个语法符号
 * https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 *
 * @author wlq
 * @since 2020/3/31 17:31
 */
public class KThSymbolInGrammar {

    // 输入: N = 1, K = 1
    // 输出: 0
    //
    // 输入: N = 2, K = 1
    // 输出: 0
    //
    // 输入: N = 2, K = 2
    // 输出: 1
    //
    // 输入: N = 4, K = 5
    // 输出: 1
    //
    // 解释:
    // 第一行: 0
    // 第二行: 01
    // 第三行: 0110
    // 第四行: 01101001
    // 第五行: 0110100110010110
    // 来源：力扣（LeetCode）

    public int kthGrammar(int N, int K) {
        if (N == 1 || K == 1) {
            return 0;
        }
        if (N == 2) {
            return 1;
        }
        int i = (K / 2) + (K % 2);
        return kthGrammar(N - 1, i);
    }


    public static void main(String[] args) {
        KThSymbolInGrammar kThSymbolInGrammar = new KThSymbolInGrammar();
        int num = kThSymbolInGrammar.kthGrammar(3, 2);
        System.out.println(num);
    }
}
