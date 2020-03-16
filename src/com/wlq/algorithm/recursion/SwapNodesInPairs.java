package com.wlq.algorithm.recursion;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author wlq
 * @since 2020/3/17 00:09
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先交换head和head.next
        ListNode secondNode = head.next;
        head.next = swapPairs(secondNode.next);
        secondNode.next = head;
        return secondNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(4);
        l2.next = l3;
        l1.next = l2;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        swapNodesInPairs.swapPairs(l1);
    }
}
