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
        int[] arr = new int[]{1,1,1,2,1,1,1};

        public int get(int index) {
            return arr[index];
        }

        public int length() {
            return arr.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 先找出峰顶, 封顶算法可参考no.162
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
        int max = left;
        int maxVal = mountainArr.get(max);
        if (maxVal == target) {
            return max;
        }
        // 左边二分
        int lTarget = -1;
        int lLeft = 0;
        int lRight = max - 1;
        while (lLeft < lRight) {
            int mid = (lLeft + lRight) / 2;
            int midVal = mountainArr.get(mid);
            if (target < midVal) {
                lRight = mid - 1;
            } else if (target > midVal) {
                lLeft = mid + 1;
            } else {
                lTarget = mid;
                break;
            }
        }
        // 右边二分
        int rTarget = -1;
        int rLeft = max + 1;
        int rRight = length - 1;
        while (rLeft < rRight) {
            int mid = (rLeft + rRight) / 2;
            int midVal = mountainArr.get(mid);
            if (target < midVal) {
                rLeft = mid + 1;
            } else if (target > midVal) {
                rRight = mid - 1;
            } else {
                rTarget = mid;
                break;
            }
        }
        return Math.min(lTarget, rTarget);
    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();
        int index = findInMountainArray.findInMountainArray(2, new MountainArray());
        System.out.println(index);
    }
}
