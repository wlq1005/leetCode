package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author wuliuqing
 * @date 2020/1/7 17:17
 **/
public class QuickSort {

    // 快速排序的基本思想是：通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的关键字均比另一部分记录的关键字小，
    // 再分别对这两部分记录继续进行排序，已达到整个序列有序
    // 一趟快速排序的具体过程可描述为：
    // 1.从待排序列中任意选取一个记录(通常选取第一个记录)作为基准值
    // 2.然后将记录中关键字比它小的记录都安置在它的位置之前
    // 3.将记录中关键字比它大的记录都安置在它的位置之后
    // 4.以该基准值为分界线，将待排序列分成的两个子序列，再进行排序

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int baseVal = arr[low];
            int i = low;
            int j = high;
            while (i < j) {
                // 从后往前查找
                while (i < j && arr[j] >= baseVal) {
                    j--;
                }
                // 小于基准值，赋值给前侧的i
                arr[i] = arr[j];
                // 从前往后查找
                while (i < j && arr[i] <= baseVal) {
                    i++;
                }
                // 大于基准值的，赋值给后侧的j
                arr[j] = arr[i];
            }
            // 此时 i==j, 该点的值就是基准值
            arr[i] = baseVal;
            // 再对基准值两侧的分别再排一遍
            sort(arr, low, i - 1);
            sort(arr, i + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{20,6, 7, 8, 10, 1, 3, 4, 5};
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
