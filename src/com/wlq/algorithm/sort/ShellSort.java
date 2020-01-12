package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 稳定性:
 * 时间复杂度:
 * 空间复杂度:
 *
 * @author wlq
 * @since 2020/1/11 15:46
 */
public class ShellSort {

    private void sort(int[] arr) {

        // 10 / 2 = 5  0~4,5~9
            // 5~10
        // 2 ~10
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
//                for (int j = i - 1; j >= step && arr[j] > temp; j--) {
//                    arr[j + 1] = arr[j];
//                }
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = new int[]{6, 7, 8, 10, 1, 3, 2, 20, 21, 4};
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
