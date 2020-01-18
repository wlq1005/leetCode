package com.wlq.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuliuqing
 * @date 2020/1/17 17:35
 **/
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 1);
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        return Arrays.asList(arr);
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }


    public static void main(String[] args) {
        PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
        List<Integer> result = pascalsTriangle2.getRow(2);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
