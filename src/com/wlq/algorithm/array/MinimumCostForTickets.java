package com.wlq.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 983. 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 *
 * @author wlq
 * @since 2020/5/6 00:22
 */
public class MinimumCostForTickets {

    private Integer[] memo;
    private Set<Integer> daySet;
    private int[] costs;

    public int mincostTickets(int[] days, int[] costs) {
        // 扩展成366大小，即1~365
        memo = new Integer[366];
        this.costs = costs;
        daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        // 从第一天开始推
        // 如果没出门 dp(i) = dp(i+1)
        // 如果出门了 dp(i) = min(dp(i+1)+cost[0], dp(i+7)+cost[1], dp(i+30)+cost[2])
        return dp(1);
    }

    private int dp(int day) {
        if (day > 365) {
            return 0;
        }
        if (memo[day] != null) {
            return memo[day];
        }
        if (daySet.contains(day)) {
            memo[day] = Math.min(Math.min(dp(day + 1) + costs[0], dp(day + 7) + costs[1]), dp(day + 30) + costs[2]);
        } else {
            memo[day] = dp(day + 1);
        }
        return memo[day];
    }

    public static void main(String[] args) {
        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
        int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = new int[]{2, 7, 15};
        System.out.println(minimumCostForTickets.mincostTickets(days, costs));
    }
}
