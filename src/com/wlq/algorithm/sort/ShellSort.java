package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 稳定性: 不稳定, 分成了若干个子序列单独进行排序
 * 时间复杂度: O(n log n)
 * 空间复杂度: O(1)
 *
 * @author wlq
 * @since 2020/1/11 15:46
 */
public class ShellSort {

    private void sort(int[] arr) {
        // 设定一个增量gap，初始值等于length/2，并且每次对增量进行缩小，gap=gap/2，直至等于1
        // 相当于把一个大的序列拆分成若干个子序列，每个子序列单独进行排序
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < length; i++) {
                // 然后就是对每个序列进行插入排序
                insertSort(arr, i, gap);
            }
        }
    }

    private void insertSort(int[] arr, int i, int gap) {
        int temp = arr[i];
        int j;
        for (j = i - gap; j >= 0 && arr[j] > temp; j = j - gap) {
            arr[j + gap] = arr[j];
        }
        arr[j + gap] = temp;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = new int[]{6, 7, 8, 10, 1, 3, 2, 20, 21, 4, 5};
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
