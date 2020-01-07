package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author wuliuqing
 * @date 2020/1/7 17:17
 **/
public class QuickSort {

    private void sort(int[] arr) {

    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{6, 7, 8, 10, 1, 3};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
