package com.wlq.algorithm.linkedlist;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/submissions/
 *
 * @author wlq
 * @since 2019/11/25 21:53
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 奇数节点
        ListNode pre = head;
        // 偶数节点
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            // 偶数节点往前提
            ListNode temp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = temp;
            // 奇偶节点各前进一步
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
