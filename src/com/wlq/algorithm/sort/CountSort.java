package com.wlq.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 稳定性: 稳定，不改变原序列
 * 时间复杂度: O(n+k)
 * 空间复杂度: O(K)
 *
 * @author wlq
 * @since 2020/1/11 22:49
 */
public class CountSort {

    private int[] sort(int[] arr) {
        // 求出数组中的最大值和最小值
        int min = 0, max = 0;
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        // 构建新的数组，长度为max-min+1
        int[] countArr = new int[max - min + 1];
        // 统计原数组数字出现次数，下标为val - min
        for (int val: arr) {
            countArr[val - min]++;
        }
        // 根据元素出现的次数，把数据添加至结果集中
        int[] result = new int[arr.length];
        int j = 0;
        for(int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                result[j++] = i;
                countArr[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] arr = new int[]{6, 7, 8, 10, 1, 3, 1, 6, 2, 1, 20, 21, 4, 5, 20, 20};
        int[] result = countSort.sort(arr);
        System.out.println(Arrays.toString(result));
    }
}
