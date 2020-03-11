package com.wlq.algorithm.linkedlist;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @author wlq
 * @since 2020/3/11 22:13
 */
public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        int offset = k % size;
        if (offset == 0) {
            return head;
        }
        tail.next = head;
        offset = size - offset;
        while (offset > 0) {
            tail = tail.next;
            offset--;
        }
        ListNode node = tail.next;
        tail.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        RotateList rotateList = new RotateList();
        ListNode node = rotateList.rotateRight(l1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
