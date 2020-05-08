package com.wlq.algorithm.array;

/**
 * 1095. 山脉数组中查找目标值
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 *
 * @author wuliuqing
 * @date 2020/4/29 22:10
 **/
public class FindInMountainArray {

    static class MountainArray {
        int[] arr = new int[]{1,5,2};

        public int get(int index) {
            return arr[index];
        }

        public int length() {
            return arr.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 先找出峰顶, 峰顶算法可参考no.162
        int top = findMountainTop(mountainArr);
        // 左边二分
        int index = findLeft(mountainArr, 0, top, target);
        if (index > -1) {
            return index;
        }
        return findLeft(mountainArr, top, mountainArr.length(), target);
    }

    private int findMountainTop(MountainArray mountainArr) {
        int length = mountainArr.length();
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findLeft(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (target < midVal) {
                right = mid;
            } else if (right > midVal) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findRight(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (target < midVal) {
                right = mid;
            } else if (right > midVal) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();
        int index = findInMountainArray.findInMountainArray(2, new MountainArray());
        System.out.println(index);
    }
}
