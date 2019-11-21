package com.wlq.algorithm.linkedlist;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author wlq
 * @since 2019/11/20 00:59
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 相遇点
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 环的长度
        ListNode temp = slow.next;
        int size = 1;
        while (slow != temp) {
            temp = temp.next;
            size++;
        }
        // 快慢节点回到起始点，快节点先往前走环的长度的距离，快慢节点再同时每次走一步
        slow = head;
        fast = head;
        for (int i = 0; i < size; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return null;
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
