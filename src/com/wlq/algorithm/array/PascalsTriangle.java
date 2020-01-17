package com.wlq.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author wlq
 * @since 2019/12/10 21:36
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            List<Integer> preRow = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                row.add(j, preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new PascalsTriangle().generate(1);
        result.forEach(r -> System.out.println(Arrays.toString(r.toArray())));
    }
}
