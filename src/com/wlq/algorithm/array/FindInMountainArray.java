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
        int[] arr = new int[]{1, 3, 4, 9, 8, 6, 6, 6, 5, 5, 3, 2, 1};

        public int get(int index) {
            return arr[index];
        }

        public int length() {
            return arr.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 先找出峰顶
        int length = mountainArr.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int max = left;
        int maxVal = mountainArr.get(max);
        if (maxVal == target) {
            return max;
        }
        // 左边二分
        int lTarget = -1;
        int lLeft = 0;
        int lRight = max;
        while (lLeft < lRight) {
            int mid = (lLeft + lRight) / 2;
            if (mountainArr.get(mid) == target) {
                lTarget = mid;
                break;
            } else if (target < mountainArr.get(mid + 1)) {
                lLeft = mid + 1;
            } else {
                lRight = mid;
            }
        }
        // 右边二分
        int rTarget = -1;
        int rLeft = max;
        int rRight = length - 1;
        while (rLeft < rRight) {
            int mid = (rLeft + rRight) / 2;
            if (mountainArr.get(mid) == target) {
                rTarget = mid;
                break;
            } else if (target < mountainArr.get(mid + 1)) {
                rLeft = mid + 1;
            } else {
                rRight = mid;
            }
        }
        return Math.max(lTarget, rTarget);
    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();
        int index = findInMountainArray.findInMountainArray(2, new MountainArray());
        System.out.println(index);
    }
}
