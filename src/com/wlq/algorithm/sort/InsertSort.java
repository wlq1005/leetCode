package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 稳定性: 稳定
 * 时间复杂度: O(n²)
 * 最好情况元素都是有序的,则只需进行n-1次比较 O(n)
 * 最好情况下元素都是逆序的,则需进行n*(n-1)/2次比较, n*(n-1)/2 -(n-1)次移动，所以O(n²)
 * 空间复杂度: O(1)
 *
 * @author wlq
 * @since 2020/1/11 14:51
 */
public class InsertSort {

    private void sort(int[] arr) {
        int i, j, temp;
        // 默认第一个元素为有序的
        for (i = 1; i < arr.length; i++) {
            // 待比较的元素设为临时变量
            temp = arr[i];
            // 待比较的元素从前遍历,如果大于临时的变量，则将当前索引后一位的元素设为当前索引的值
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            // 比较完毕，重新设置临时变量
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 8, 10, 1, 3};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
