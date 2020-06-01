package com.wlq.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * @author wuliuqing
 * @date 2020/6/1 16:42
 **/
public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return list;
        }
        int max = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 1, 12};
        KidsWithTheGreatestNumberOfCandies kids = new KidsWithTheGreatestNumberOfCandies();
        List<Boolean> result = kids.kidsWithCandies(arr, 10);
        result.forEach(System.out::println);
    }
}
