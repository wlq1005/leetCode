package com.wlq.algorithm.heap;

import java.util.*;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author wuliuqing
 * @date 2020/1/10 11:40
 **/
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return null;
        }
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>(16);
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 1) + 1);
        }
        // 只有1个元素的话直接返回第一个
        if (k == 1 && countMap.size() == 1) {
            result.add(nums[0]);
            return result;
        }
        // 根据count排序加入队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        countMap.keySet().forEach(key -> {
            priorityQueue.add(key);
            // 如果队列长度超过需要返回的个数，出队
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        });
        // 此时队列中的key即是前K个高频
        while (priorityQueue.size() > 0) {
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 3, 4, 5};
        TopKFrequentElements elements = new TopKFrequentElements();
        List<Integer> list = elements.topKFrequent(arr, 3);
        System.out.println(list.toString());
    }
}
