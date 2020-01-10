package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 稳定性：不稳定
 * 时间复杂度: O(n log n)
 * 空间复杂度: O(1)
 *
 * @author wuliuqing
 * @date 2020/1/8 17:28
 **/
public class HeapSort {

    private void sort(int[] arr) {
        // 构造大根堆
        buildHeap(arr);
        int length = arr.length;
        while (length > 1) {
            // 固定最大值
            swap(arr, 0, length - 1);
            length--;
            // 剩余数重新构造大根堆
            heapIfy(arr, 0, length);
        }
    }

    private void buildHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            while (arr[currentIndex] > arr[fatherIndex]) {
                // 如果当前节点值大于父节点值，则交换值
                swap(arr, currentIndex, fatherIndex);
                // 当前索引重新设置为父节点索引
                currentIndex = fatherIndex;
                // 重新计算父节点索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    private void heapIfy(int[] arr, int index, int length) {
        // 计算左右子节点索引
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;
        while (left < length) {
            // 获取子节点中较大值索引
            int largestIndex = arr[right] > arr[left] && right < length ? right : left;
            // 如果当前值大于子节点最大值，则将最大值索引改为当前索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            // 如果最大值索引等于当前索引，则退出本次构建
            if (largestIndex == index) {
                break;
            }
            // 如果当前值小于子节点最大值，则交换值
            swap(arr, index, largestIndex);
            // 并将当前索引设置为最大值索引
            index = largestIndex;
            // 重新计算左右子节点
            left = (index * 2) + 1;
            right = (index * 2) + 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{30, 9, 15, 11, 5, 7, 2, 20};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
