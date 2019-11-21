package com.wlq.algorithm.linkedlist;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author wlq
 * @since 2019/11/20 00:59
 */
public class LinkedListCycle {


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
