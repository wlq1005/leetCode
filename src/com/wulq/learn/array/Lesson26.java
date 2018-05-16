package com.wulq.learn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数组的交集 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 * <p>
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author wlq
 * @since 2018/5/16 17:03
 */
public class Lesson26 {

    public static void main(String[] args) {
        Lesson26 lesson26 = new Lesson26();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] array = lesson26.intersect(nums1, nums2);
        for (int val : array) {
            System.out.println(val);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] intArr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            intArr[k] = list.get(k);
        }
        return intArr;
    }
}
