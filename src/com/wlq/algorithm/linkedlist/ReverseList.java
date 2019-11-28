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
            // next指针改为指向前一个元素
            head.next = temp;
            // 存储前一个元素
            temp = head;
            // 存储下一个节点
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
