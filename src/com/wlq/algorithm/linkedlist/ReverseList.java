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
        ListNode temp = head;
        ListNode result = null;
        while (temp != null) {
            if (result == null) {
                result = new ListNode(temp.val);
            } else {
                ListNode node = new ListNode(temp.val);
                node.next = result;
                result = node;
            }
            temp = temp.next;
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
