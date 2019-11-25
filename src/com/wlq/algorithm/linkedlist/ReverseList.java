package com.wlq.algorithm.linkedlist;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author wuliuqing
 * @date 2019/11/22 14:13
 **/
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode temp = null;
        while (node != null) {
            node = node.next;
            head.next = temp;
            temp = head;
            head = node;
        }
        return temp;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
