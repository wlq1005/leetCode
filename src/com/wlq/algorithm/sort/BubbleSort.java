package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 数字一个个比较，数字大的往后沉
 * <p>
 * 稳定性:
 * arr[j] > arr[j + 1] 稳定
 * arr[j] >= arr[j + 1] 不稳定
 *
 * 时间复杂度:逆向排序时O(n^2)
 * 空间复杂度:O(1)
 *
 * @author wuliuqing
 * @date 2020/1/7 10:08
 **/
public class BubbleSort {

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 每轮比较的次数都比上轮少1次，因为大的数已经沉到了末尾，不需要再排
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{6, 7, 8, 10, 1, 3};
        bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
