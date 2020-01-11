package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 稳定性:  不稳定，例如 3,3,1,2 第一次交换后 1,3,3,2，index=0的元素3本来是在index=1的元素3前面，交换后就排到后面去了
 * 时间复杂度: O(n²)
 * 最好情况下元素都是排序好的，不需要交换，但仍需要比较 n * (n - 1) / 2 次
 * 最坏情况下元素都是逆序的，每一趟都需要交换，需要比较 n * (n - 1) / 2 次
 * 空间复杂度: O(1)
 *
 * @author wlq
 * @since 2020/1/11 14:49
 */
public class SelectionSort {

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tempIndex = i;
            // 从已排序的数字后开始，寻找最小的值
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[tempIndex]) {
                    tempIndex = j;
                }
            }
            // 如果存在比当前序列小的，则进行交换
            if (tempIndex > i) {
                int temp = arr[i];
                arr[i] = arr[tempIndex];
                arr[tempIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 8, 10, 1, 3};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
